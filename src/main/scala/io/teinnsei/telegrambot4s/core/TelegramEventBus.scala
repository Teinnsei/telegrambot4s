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

import akka.actor.ActorRef
import akka.event.{EventBus, LookupClassification}
import io.teinnsei.telegrambot4s.message.TelegramEvent

import scala.language.postfixOps

class TelegramEventBus extends EventBus with LookupClassification {

  override type Event = TelegramEvent
  override type Classifier = Class[_]
  override type Subscriber = ActorRef

  override protected def mapSize(): Int = 128

  override protected def compareSubscribers(a: ActorRef, b: ActorRef): Int = a compareTo b

  override protected def classify(event: Event): Classifier = event.getClass

  override protected def publish(event: Event, subscriber: ActorRef): Unit = subscriber ! event

}