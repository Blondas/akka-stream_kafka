package actors

import actors.Ping.{Initialize, PingMessage}
import actors.Pong.PongMessage
import akka.actor.{Actor, ActorLogging, ActorRef, Props}

class Ping extends Actor with ActorLogging{
  var counter = 0

  val pongActor: ActorRef = createPong()

  override def receive = {
    case Initialize =>
      log.info("Initializing PingActor")
      pongActor ! PingMessage()

    case PongMessage =>
      Thread.sleep(1000)
      counter += 1
      log.info("PongMessage received")
      sender ! PingMessage()
  }

  def createPong(): ActorRef = context.actorOf(Pong.props(), "pong")
}

object Ping {
  case object Initialize
  case class PingMessage()

  def props = Props(new Ping)
}
