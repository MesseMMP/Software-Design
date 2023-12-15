class Product(val id: Int, val name: String, val price: Int, var number : Int) {
    override fun toString(): String {
        return "Name = $name, Price = $price, Number: $number"
    }
}