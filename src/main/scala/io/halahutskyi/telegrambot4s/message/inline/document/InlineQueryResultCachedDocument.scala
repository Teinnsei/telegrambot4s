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

package io.halahutskyi.telegrambot4s.message.inline.document

import io.halahutskyi.telegrambot4s.message.common.document.InlineKeyboardMarkup
import io.halahutskyi.telegrambot4s.message.TelegramDocument

final case class InlineQueryResultCachedDocument(`type`: String,
                                                 id: String,
                                                 videoFileId: String,
                                                 title: String,
                                                 description: Option[String] = None,
                                                 caption: Option[String] = None,
                                                 parseMode: Option[String] = None,
                                                 replyMarkup: Option[InlineKeyboardMarkup] = None,
                                                 inputMessageContent: Option[InputMessageContent] = None) extends TelegramDocument
