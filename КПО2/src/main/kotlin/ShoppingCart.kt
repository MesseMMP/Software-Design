/**
 * Класс, представляющий корзину покупок пользователя.
 * @property items Карта товаров и их количества в корзине.
 */
class ShoppingCart {
    val items: MutableMap<Product, Int> = mutableMapOf()
    /**
     * Добавление товара в корзину с указанным количеством.
     * @param product Товар для добавления.
     * @param quantity Количество товара.
     */
    fun addItem(product: Product, quantity: Int) {
        items[product] = items.getOrDefault(product, 0) + quantity
    }
}