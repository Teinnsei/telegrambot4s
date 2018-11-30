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

package io.teinnsei.telegrambot4s.message.common.document

import io.teinnsei.telegrambot4s.message.InputFile
import io.teinnsei.telegrambot4s.message.TelegramDocument

sealed trait InputMedia extends TelegramDocument

final case class InputMediaAnimation(`type`: String,
                                     media: String,
                                     thumb: Option[InputFile] = None,
                                     caption: Option[String] = None,
                                     parseMode: Option[String] = None,
                                     duration: Option[Int] = None,
                                     performer: Option[String] = None,
                                     title: Option[String] = None) extends InputMedia

final case class InputMediaAudio(`type`: String,
                                 media: String,
                                 thumb: Option[InputFile] = None,
                                 caption: Option[String] = None,
                                 parseMode: Option[String] = None) extends InputMedia


final case class InputMediaDocument(`type`: String,
                                    media: String,
                                    thumb: InputFile,
                                    caption: Option[String] = None,
                                    parseMode: Option[String] = None) extends InputMedia

final case class InputMediaPhoto(`type`: String,
                                 media: String,
                                 thumb: Option[InputFile] = None,
                                 caption: Option[String] = None,
                                 parseMode: Option[String] = None,
                                 width: Option[Int] = None,
                                 height: Option[Int] = None,
                                 duration: Option[Int] = None,
                                 supportsStreaming: Option[Boolean] = None) extends InputMedia

final case class InputMediaVideo(`type`: String,
                                 media: String,
                                 thumb: Option[InputFile],
                                 caption: Option[String] = None,
                                 parseMode: Option[String] = None,
                                 width: Option[Int] = None,
                                 height: Option[Int] = None,
                                 duration: Option[Int] = None) extends InputMedia
