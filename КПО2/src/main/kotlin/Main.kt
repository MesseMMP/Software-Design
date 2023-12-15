fun main(args: Array<String>) {
    val product1 = Product(0, "iPhone", 1000, 5)
    val product2 = Product(0, "MacBook", 2500, 1)
    val product3 = Product(0, "AirPods", 350, 2)
    val product4 = Product(0, "iMac", 3000, 0)
    val shop: Shop = Shop()
    shop.products = mutableListOf(product1, product2, product3, product4);
    shop.registerCustomer()
    val customer1 = shop.customers[0]
    shop.watchProducts()
    shop.buyProduct(product1)
    shop.watchProducts()
    shop.buyProduct(product4 )
    shop.watchProducts()
    shop.customers.forEach { println(it) }
    println("Баланс магазина: ${shop.balance}")

}