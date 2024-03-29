package persistence.calculator

import akka.actor.ActorSystem

class CalculatorSpec extends PersistenceSpec(ActorSystem("test")) with PersistenceCleanup {
  "The Calculator" should {
    "recover last known result after crash" in {
      val calc = system.actorOf(Calculator.props, Calculator.name)
      calc ! Calculator.Add(1d)
      calc ! Calculator.GetResult
      expectMsg(1d)

      calc ! Calculator.Subtract(0.5d)
      calc ! Calculator.GetResult
      expectMsg(0.5d)

      killActors(calc)

      val calcResurrected = system.actorOf(Calculator.props, Calculator.name)
      calcResurrected ! Calculator.GetResult
      expectMsg(0.5d)

      calcResurrected ! Calculator.Add(1d)
      calcResurrected ! Calculator.GetResult
      expectMsg(1.5d)
    }
  }
}
