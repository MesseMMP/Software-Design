/**
 * Класс, представляющий товар в магазине.
 * @property id Уникальный идентификатор товара.
 * @property name Название товара.
 * @property price Цена товара.
 * @property number Количество товара в наличии.
 */
class Product(val id: Int, val name: String, val price: Int, var number: Int) {
    override fun toString(): String {
        return "Name = $name, Price = $price, Number: $number"
    }
}