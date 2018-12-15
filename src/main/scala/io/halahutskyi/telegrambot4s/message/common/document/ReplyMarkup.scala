/*
 * Copyright 2018 Oleksandr Halahutskyi
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance extends the License.
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

package io.halahutskyi.telegrambot4s.message.common.document

import io.halahutskyi.telegrambot4s.message.Matrix
import io.halahutskyi.telegrambot4s.message.TelegramDocument

sealed trait ReplyMarkup extends TelegramDocument

final case class InlineKeyboardMarkup(inlineKeyboard: Matrix[InlineKeyboardButton]) extends ReplyMarkup

final case class ReplyKeyboardRemove(removeKeyboard: Boolean = true, selective: Option[Boolean] = None) extends ReplyMarkup

final case class ForceReply(selective: Option[Boolean] = None, forceReply: Boolean = true) extends ReplyMarkup

final case class ReplyKeyboardMarkup(keyboard: Matrix[KeyboardButton],
                                     resizeKeyboard: Option[Boolean] = None,
                                     oneTimeKeyboard: Option[Boolean] = None,
                                     selective: Option[Boolean] = None) extends ReplyMarkup

