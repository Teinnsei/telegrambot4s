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

package io.teinnsei.telegrambot4s.message.inline.document

import io.teinnsei.telegrambot4s.message.common.document.{Location, User}
import io.teinnsei.telegrambot4s.message.TelegramDocument

final case class ChosenInlineResult(resultId: String,
                                    from: Option[User] = None,
                                    location: Option[Location] = None,
                                    inlineMessageId: Option[String] = None,
                                    query: Option[String] = None) extends TelegramDocument