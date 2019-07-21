package persistence.shopper

class Items {

}

case class Item(productId: String, number: Int, unitPrice: BigDecimal) {
  def aggregate(item: Item): Option[Item] =
    if (item.productId == productId) Some(copy(number = number + item.number)) else None

  def update(number: Int): Item = copy(number = number)
}
