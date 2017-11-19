package actors

import actors.Ping.PingMessage
import actors.Pong.PongMessage
import akka.actor.{Actor, ActorLogging, Props}

class Pong extends Actor with ActorLogging {
  override def receive = {
    case PingMessage() =>
      log.info("PingMessage received")
      sender ! PongMessage()

  }
}

object Pong {
  case class PongMessage()
  def props() = Props(new Pong())
}
