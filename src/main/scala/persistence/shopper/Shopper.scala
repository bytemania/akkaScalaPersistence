package persistence.shopper

object Shopper {

  trait Command {
    def shopperId: Long
  }

}
