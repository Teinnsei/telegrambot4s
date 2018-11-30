/*
 * Copyright 2018 Oleksandr Halahutskyi
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.teinnsei.telegrambot4s.core

import akka.actor.{Actor, ActorLogging, Props}
import com.fasterxml.jackson.annotation.JsonInclude.Include
import com.fasterxml.jackson.databind.{ObjectMapper, PropertyNamingStrategy}
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import com.typesafe.config.ConfigFactory
import io.teinnsei.telegrambot4s.message.event.command.GetUpdates
import io.teinnsei.telegrambot4s.message.event.document._
import io.teinnsei.telegrambot4s.message.{TelegramCommand, TelegramEvent}
import org.asynchttpclient.Dsl._
import org.reflections.Reflections

import scala.collection.JavaConverters._
import scala.compat.java8.FutureConverters._
import scala.concurrent.ExecutionContext
import scala.language.postfixOps

object TelegramActor {

  def props(telegramEventBus: TelegramEventBus): Props = Props(new TelegramActor(telegramEventBus))

}

class TelegramActor(telegramEventBus: TelegramEventBus) extends Actor with ActorLogging {

  private implicit val ec: ExecutionContext = context.dispatcher

  private val token = {
    val defaultApp = ConfigFactory.defaultApplication()
    defaultApp.getString("telegram.bot.token")
  }

  private val objectMapper = new ObjectMapper()
    .registerModule(DefaultScalaModule)
    .setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE)
    .setSerializationInclusion(Include.NON_NULL)
    .setSerializationInclusion(Include.NON_EMPTY)

  private val commandToUrl =
    new Reflections("io.teinnsei.telegrambot4s.api")
      .getSubTypesOf(classOf[TelegramCommand])
      .asScala
      .map { c =>
        val simpleName = c.getSimpleName
        val headNMethodName= simpleName.charAt(0)
        val tailMethodName = simpleName.substring(1)
        val methodName = headNMethodName + tailMethodName
        (c.getName, s"https://api.telegram.org/bot$token/$methodName")
      } toMap

  private val updateUrl = s"https://api.telegram.org/bot$token/getUpdates"

  private val httpClient = asyncHttpClient()

  override def receive: Receive = {
    case getUpdates: GetUpdates =>
      httpClient.preparePost(updateUrl)
        .setHeader("Content-type", "application/json")
        .setBody(objectMapper.writeValueAsString(getUpdates))
        .execute()
        .toCompletableFuture
        .toScala
        .map(_.getResponseBody)
        .map(objectMapper.readValue(_, classOf[ResponseUpdates]))
        .map(_.result)
        .foreach(handleUpdates)

    case command: TelegramCommand =>
      httpClient.preparePost(commandToUrl(command.getClass.getName))
        .setHeader("Content-type", "application/json")
        .setBody(objectMapper.writeValueAsString(command))
        .execute()
        .toCompletableFuture
        .toScala
        .foreach(p => log.info(p.getResponseBody))
  }

  private def handleUpdates(updates: List[Update]): Unit = {
    updates.map(_.toString).foreach(log.info)
    updates.foreach(publishEvents)
  }

  private def publishEvents(update: Update): Unit = {
    update.message.map(m => NewMessage(update.updateId, m)).foreach(publishEvent)
    update.editedMessage.map(m => NewEditMessage(update.updateId, m)).foreach(publishEvent)
    update.channelPost.map(m => NewChannelPost(update.updateId, m)).foreach(publishEvent)
    update.editedChannelPost.map(m => NewEditChannelPost(update.updateId, m)).foreach(publishEvent)
    update.inlineQuery.map(m => NewInlineQuery(update.updateId, m)).foreach(publishEvent)
    update.callbackQuery.map(m => NewCallbackQuery(update.updateId, m)).foreach(publishEvent)
    update.shippingQuery.map(m => NewChippingQuery(update.updateId, m)).foreach(publishEvent)
    update.chosenInlineResult.map(m => NewChosenInlineResult(update.updateId, m)).foreach(publishEvent)
    update.preCheckoutQuery.map(m => NewPreCheckoutQuery(update.updateId, m)).foreach(publishEvent)
  }

  private def publishEvent(event: TelegramEvent): Unit = {
    telegramEventBus.publish(event)
    context.system.eventStream.publish(event)
  }

}
