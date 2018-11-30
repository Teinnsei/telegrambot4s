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

package io.teinnsei.telegrambot4s.message.passport.document

import io.teinnsei.telegrambot4s.message.TelegramDocument

sealed trait PassportElementError extends TelegramDocument

final case class PassportElementErrorDataField(source: String,
                                               `type`: String,
                                               fieldName: String,
                                               dataHash: String,
                                               message: String) extends PassportElementError

final case class PassportElementErrorFile(source: String,
                                          `type`: String,
                                          fileHash: String,
                                          message: String) extends PassportElementError


final case class PassportElementErrorFiles(source: String,
                                           `type`: String,
                                           fileHashes: List[String],
                                           message: String) extends PassportElementError

final case class PassportElementErrorFrontSide(source: String,
                                               `type`: String,
                                               fileHash: String,
                                               message: String) extends PassportElementError

final case class PassportElementErrorReverseSide(source: String,
                                                 `type`: String,
                                                 fileHash: String,
                                                 message: String) extends PassportElementError

final case class PassportElementErrorSelfie(source: String,
                                            `type`: String,
                                            fileHash: String,
                                            message: String) extends PassportElementError

final case class PassportElementErrorTranslationFile(source: String,
                                                     `type`: String,
                                                     fileHash: String,
                                                     message: String) extends PassportElementError


final case class PassportElementErrorTranslationFiles(source: String,
                                                      `type`: String,
                                                      fileHashes: List[String],
                                                      message: String) extends PassportElementError

final case class PassportElementErrorUnspecified(source: String,
                                                 `type`: String,
                                                 elementHash: String,
                                                 message: String) extends PassportElementError
