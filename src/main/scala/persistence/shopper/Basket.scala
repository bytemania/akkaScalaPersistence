package persistence.shopper

import akka.actor.{ActorLogging, Props}
import akka.persistence.PersistentActor

object Basket {
  def props = Props(new Basket)

  def name(shopperId: Long) = s"basket_$shopperId"

  sealed trait Command extends Shopper.Command
  case class Add(item: Item, shopperId: Long) extends Command
  case class RemoveItem(productId: String, shopperId: Long) extends Command
  case class UpdateItem(item: String, number: Int, shopperId: Long) extends Command
  case class Clear(shopperId: Long) extends Command
  case class Replace(items: Items, shopperId: Long) extends Command
  case class GetItems(shopperId: Long) extends Command
  case class CountRecoveredEvents(shopperId: Long) extends Command
  case class RecoveredEventsCount(count: Long)

  sealed trait Event extends Serializable
  case class Added(item: Item) extends Event
  case class ItemRemoved(productId: String) extends Event
  case class ItemUpdated



}

class Basket extends PersistentActor with ActorLogging {
  override def receiveRecover: Receive = ???

  override def receiveCommand: Receive = ???

  override def persistenceId: String = ???
}
