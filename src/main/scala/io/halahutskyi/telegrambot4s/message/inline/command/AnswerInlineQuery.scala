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

package io.halahutskyi.telegrambot4s.message.inline.command

import io.halahutskyi.telegrambot4s.message.inline.document.InlineQueryResult
import io.halahutskyi.telegrambot4s.message.TelegramCommand

final case class AnswerInlineQuery(inlineQueryId: String,
                                   results: List[InlineQueryResult],
                                   cacheTime: Option[Int] = None,
                                   isPersonal: Option[Boolean] = None,
                                   nextOffset: Option[String] = None,
                                   switchPmText: Option[String] = None,
                                   switchPmParameter: Option[String] = None) extends TelegramCommand
