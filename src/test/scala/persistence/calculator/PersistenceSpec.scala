package persistence.calculator

import akka.actor.{ActorRef, ActorSystem}
import akka.testkit.{ImplicitSender, TestKit}
import com.typesafe.config.Config
import org.scalatest.{BeforeAndAfterAll, Matchers, WordSpecLike}

abstract class PersistenceSpec(system: ActorSystem) extends TestKit(system)
  with ImplicitSender
  with WordSpecLike
  with Matchers
  with BeforeAndAfterAll
  with PersistenceCleanup {

  def this(name: String, config: Config) = this(ActorSystem(name, config))

  override protected def beforeAll(): Unit = deleteStorageLocations()

  override protected def afterAll(): Unit = {
    deleteStorageLocations()
    TestKit.shutdownActorSystem(system)
  }

  def killActors(actors: ActorRef*): Unit = {
    actors.foreach{ actor =>
      watch(actor)
      system.stop(actor)
      expectTerminated(actor)
    }
  }
}
