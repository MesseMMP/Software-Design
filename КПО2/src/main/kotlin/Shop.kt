class Shop {
    var products: MutableList<Product> = mutableListOf()
    var customers: MutableList<Customer> = mutableListOf()
    var balance: Int = 0
    fun registerCustomer() {
        println("Введите логин:")
        val login: String = readln();
        val customer: Customer
        while (true){
            println("Введите пароль:")
            val password1: String = readln();
            println("Введите пароль повторно:")
            val password2: String = readln()
            if (password1 == password2) {
                customer = Customer(login, password1)
                println("Успешная регистрация!")
                break
            }
            println("Пароли не совпадают!")
        }
        customers.add(customer)
    }

    fun watchProducts() {
        products.forEach { product -> println(product) }
    }

    fun buyProduct(product: Product) {
        val productFromShop = products.find { it == product}
        if (productFromShop != null) {
            if (productFromShop.number > 0){
                println("Покупка совершена!")
                balance += product.price
                productFromShop.number -= 1
            } else{
                println("Такого товара нет в наличии!")
            }
        } else {
            println("Такого товара не существует")
        }
    }

}