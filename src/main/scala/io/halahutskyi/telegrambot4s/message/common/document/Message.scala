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

package io.halahutskyi.telegrambot4s.message.common.document

import io.halahutskyi.telegrambot4s.message.games.document.Game
import io.halahutskyi.telegrambot4s.message.passport.document.PassportData
import io.halahutskyi.telegrambot4s.message.payment.document.{Invoice, SuccessfulPayment}
import io.halahutskyi.telegrambot4s.message.{ChatId, TelegramDocument}

final case class Message(messageId: Int,
                         date: Int,
                         chat: Chat,
                         from: Option[User] = None,
                         forwardFrom: Option[User] = None,
                         forwardFromChat: Option[Chat] = None,
                         forwardFromMessageId: Option[Int] = None,
                         forwardSignature: Option[String] = None,
                         forwardDate: Option[Int] = None,
                         replyToMessage: Option[Message] = None,
                         editDate: Option[Int] = None,
                         mediaGroupId: Option[String] = None,
                         authorSignature: Option[String] = None,
                         text: Option[String] = None,
                         entities: List[MessageEntity] = Nil,
                         captionEntities: List[MessageEntity] = Nil,
                         audio: Option[Audio] = None,
                         document: Option[Document] = None,
                         animation: Option[Animation] = None,
                         game: Option[Game] = None,
                         photo: List[PhotoSize] = Nil,
                         sticker: Option[Sticker] = None,
                         video: Option[Video] = None,
                         voice: Option[Voice] = None,
                         videoNote: Option[VideoNote] = None,
                         caption: Option[String] = None,
                         contact: Option[Contact] = None,
                         location: Option[Location] = None,
                         venue: Option[Venue] = None,
                         newChatMembers: List[User] = Nil,
                         leftChatMember: Option[User] = None,
                         newChatTitle: Option[String] = None,
                         newChatPhoto: List[PhotoSize] = Nil,
                         deleteChatPhoto: Option[Boolean] = Some(false),
                         groupChatCreated: Option[Boolean] = Some(false),
                         supergroupChatCreated: Option[Boolean] = Some(false),
                         channelChatCreated: Option[Boolean] = Some(false),
                         migrateToChatId: Option[Int] = None,
                         migrateFromChatId: Option[Int] = None,
                         pinnedMessage: Option[Message] = None,
                         invoice: Option[Invoice] = None,
                         successfulPayment: Option[SuccessfulPayment] = None,
                         connectedWebsite: Option[String] = None,
                         passportData: Option[PassportData] = None) extends TelegramDocument {

  def chatId: ChatId = chat.id

}
