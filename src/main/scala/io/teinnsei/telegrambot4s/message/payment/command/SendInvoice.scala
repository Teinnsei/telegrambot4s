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

package io.teinnsei.telegrambot4s.message.payment.command

import io.teinnsei.telegrambot4s.message.common.document.InlineKeyboardMarkup
import io.teinnsei.telegrambot4s.message.payment.document.LabeledPrice
import io.teinnsei.telegrambot4s.message.TelegramCommand

final case class SendInvoice(chatId: Int,
                             title: String,
                             description: String,
                             payload: String,
                             providerToken: String,
                             startParameter: String,
                             currency: String,
                             prices: List[LabeledPrice],
                             providerData: Option[String] = None,
                             photoUrl: Option[String] = None,
                             photoSize: Option[Int] = None,
                             photoWidth: Option[Int] = None,
                             photoHeight: Option[Int] = None,
                             needName: Option[Boolean] = None,
                             needPhoneNumber: Option[Boolean] = None,
                             needEmail: Option[Boolean] = None,
                             needShippingAddress: Option[Boolean] = None,
                             sendPhoneNumberToProvider: Option[Boolean] = None,
                             sendEmailToProvider: Option[Boolean] = None,
                             isFlexible: Option[Boolean] = None,
                             disableNotification: Option[Boolean] = None,
                             replyToMessageId: Option[Int] = None,
                             replyMarkup: Option[InlineKeyboardMarkup] = None) extends TelegramCommand