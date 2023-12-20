fun main() {
    val product1 = Product(0, "iPhone", 1000, 5)
    val product2 = Product(1, "MacBook", 2500, 1)
    val product3 = Product(2, "AirPods", 350, 2)
    val product4 = Product(3, "iMac", 3000, 3) // Changed initial quantity
    val shop = Shop()
    shop.products = mutableListOf(product1, product2, product3, product4)

    // Регистрация пользователя
    shop.registerCustomer()
    val customer1 = shop.customers[0]

    // Просмотр товаров в магазине
    shop.watchProducts()

    // Добавление товаров в корзину
    val shoppingCart = ShoppingCart()
    shoppingCart.addItem(product1, 2)
    shoppingCart.addItem(product4, 1)

    // Покупка товаров
    shop.buyProduct(customer1, shoppingCart)

    // Просмотр обновленного списка товаров в магазине
    shop.watchProducts()

    // Вывод информации о пользователе и балансе магазина
    shop.customers.forEach { println(it) }
    println("Баланс магазина: $${shop.balance}")
}