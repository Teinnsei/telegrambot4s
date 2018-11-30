# telegrambot4s

-- IN PROGRESS --

## How to usage

Create Telegram event listener

```scala
import akka.actor.{Actor, ActorRef, Props}
import io.teinnsei.telegrambot4s.message.common.command.SendMessage
import io.teinnsei.telegrambot4s.message.common.document.{InlineKeyboardButton, InlineKeyboardMarkup}
import io.teinnsei.telegrambot4s.message.event.document.NewMessage
import io.teinnsei.telegrambot4s.util.CommonImplicit._

object NewMessageListener {

  def props(telegramActor: ActorRef): Props = Props(new NewMessageListener(telegramActor))

}

class NewMessageListener(telegramActor: ActorRef) extends Actor {

  override def receive: Receive = {
    case nMsg: NewMessage =>
     // on message send the same message
      telegramActor ! SendMessage(
        chatId = nMsg.message.chatId, 
        text = "I have got the next message: \"${nMsg.message.text}\""
      )
      
      // on message send the inline keyboard with reference to google
      
      telegramActor ! SendMessage(
        chatId = nMsg.message.chatId,
        text = "Below reference to google.com. Click button.",
        replyMarkup = InlineKeyboardMarkup(
          inlineKeyboard = List(List(
            InlineKeyboardButton(
              "google.com",
              url = "https://google.com"
            )
          ))
        )
      )
  }
}


```

Create runner

```scala
import akka.actor.{ActorRef, ActorSystem}
import io.teinnsei.telegrambot4s.message.event.command.GetUpdates
import io.teinnsei.telegrambot4s.message.event.document.NewMessage
import io.teinnsei.telegrambot4s.core._

import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits._
import scala.language.postfixOps

object Application extends App {

  private val system = ActorSystem("telegram-bot")

  private val eventBus: TelegramEventBus = new TelegramEventBus
  private val telegramActor: ActorRef = system.actorOf(TelegramActor.props(eventBus))

  private val newMessageListenerActor: ActorRef = system.actorOf(NewMessageListener.props(telegramActor))
  eventBus.subscribe(newMessageListenerActor, classOf[NewMessage])

  system.scheduler.schedule(5 seconds, 5 seconds)(telegramActor ! GetUpdates())

}

```