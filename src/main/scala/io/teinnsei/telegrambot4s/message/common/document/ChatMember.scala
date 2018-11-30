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

import io.teinnsei.telegrambot4s.message.TelegramDocument

final case class ChatMember(user: User,
                            status: String,
                            untilDate: Option[Int] = None,
                            canBeEdited: Option[Boolean] = None,
                            canChangeInfo: Option[Boolean] = None,
                            canPostMessages: Option[Boolean] = None,
                            canEditMessages: Option[Boolean] = None,
                            canDeleteMessages: Option[Boolean] = None,
                            canInviteUsers: Option[Boolean] = None,
                            canRestrictMembers: Option[Boolean] = None,
                            canPinMessages: Option[Boolean] = None,
                            canPromoteMembers: Option[Boolean] = None,
                            canSendMessages: Option[Boolean] = None,
                            canSendMediaMessages: Option[Boolean] = None,
                            canSendOtherMessages: Option[Boolean] = None,
                            canAddWebPagePreviews: Option[Boolean] = None) extends TelegramDocument
