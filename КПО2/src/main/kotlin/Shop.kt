import kotlin.system.exitProcess

/**
 * Класс, представляющий магазин.
 * @property products Список товаров в магазине.
 * @property customers Список зарегистрированных пользователей магазина.
 * @property balance Баланс магазина.
 */
class Shop {
    var products: MutableList<Product> = mutableListOf()
    var customers: MutableList<Customer> = mutableListOf()
    var balance: Int = 0

    /**
     * Регистрация нового пользователя.
     */
    fun registerCustomer() {
        println("===== Регистрация нового пользователя =====")
        print("Введите логин: ")
        val login: String = readlnOrNull() ?: exitProcess(1)
        val customer: Customer
        while (true) {
            print("Введите пароль: ")
            val password1: String = readLine() ?: exitProcess(1)
            print("Повторите пароль: ")
            val password2: String = readLine() ?: exitProcess(1)
            if (password1 == password2) {
                customer = Customer(login, password1)
                println("Успешная регистрация!\n")
                break
            }
            println("Пароли не совпадают! Попробуйте еще раз.\n")
        }
        customers.add(customer)
    }

    /**
     * Просмотр списка товаров в магазине.
     */
    fun watchProducts() {
        println("\n===== Товары в магазине =====")
        products.forEach { product -> println(product) }
        println()
    }

    /**
     * Оформление покупки для пользователя.
     * @param customer Пользователь, совершающий покупку.
     * @param shoppingCart Корзина покупок пользователя.
     */
    fun buyProduct(customer: Customer, shoppingCart: ShoppingCart) {
        println("\n===== Оформление покупки для пользователя ${customer.login} =====")
        if (shoppingCart.items.isEmpty()) {
            println("Корзина пуста. Выберите товары для покупки.\n")
            return
        }

        println("Выбранные товары в корзине:")
        shoppingCart.items.forEach { (product, quantity) ->
            println("${product.name} (Количество: $quantity)")
        }

        println("\n===== Подтверждение покупки =====")
        var totalCost = 0
        shoppingCart.items.forEach { (product, quantity) ->
            val productFromShop = products.find { it == product }
            if (productFromShop != null) {
                if (productFromShop.number >= quantity) {
                    totalCost += product.price * quantity
                } else {
                    println("Ошибка: Недостаточно товара ${product.name} в наличии!")
                    return
                }
            } else {
                println("Ошибка: Товар ${product.name} не существует в магазине.")
                return
            }
        }

        println("\nИтоговая стоимость покупки: $$totalCost")


        println("Оплата прошла успешно!")
        balance += totalCost;
        println("Баланс машазина составляет: $balance.")

        // Обновляем количество товаров в магазине
        shoppingCart.items.forEach { (product, quantity) ->
            val productFromShop = products.find { it == product }
            productFromShop?.number = productFromShop?.number?.minus(quantity) ?: 0
        }

        println("\n===== Покупка завершена успешно =====\n")
    }
}