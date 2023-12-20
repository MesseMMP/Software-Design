/**
 * Класс, представляющий пользователя магазина.
 * @property login Логин пользователя.
 * @property password Хэш-код пароля пользователя.
 */

class Customer(var login: String, private var password: String) {
    init {
        password = password.hashCode().toString()
    }

    override fun toString(): String {
        return "Login: $login, Password: $password"
    }
}
