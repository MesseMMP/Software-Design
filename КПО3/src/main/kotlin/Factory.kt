package org.example

// Интерфейс для товара
interface Component {
    fun displayInfo(): String
}

// Классы для каждого типа товара
data class Motherboard(
    val id: Int,
    val name: String,
    val price: Double,
    val socketType: String,
    val processorCount: Int,
    val memoryType: String
) : Component {
    override fun displayInfo(): String {
        return "Motherboard: $name (ID: $id)\n" +
                "Price: $price\n" +
                "Socket Type: $socketType\n" +
                "Processor Count: $processorCount\n" +
                "Memory Type: $memoryType"
    }
}

data class Processor(
    val id: Int,
    val name: String,
    val price: Double,
    val socketType: String,
    val coreCount: Int,
    val clockSpeed: Double
) : Component {
    override fun displayInfo(): String {
        return "Processor: $name (ID: $id)\n" +
                "Price: $price\n" +
                "Socket Type: $socketType\n" +
                "Core Count: $coreCount\n" +
                "Clock Speed: $clockSpeed GHz"
    }
}

data class HardDrive(
    val id: Int,
    val name: String,
    val price: Double,
    val capacity: Int,
    val rotationSpeed: Int
) : Component {
    override fun displayInfo(): String {
        return "Hard Drive: $name (ID: $id)\n" +
                "Price: $price\n" +
                "Capacity: $capacity GB\n" +
                "Rotation Speed: $rotationSpeed RPM"
    }
}

// Интерфейс для фабрики
interface ComponentFactory {
    fun createComponent(id: Int, name: String, price: Double): Component
}

// Фабрики для каждого типа товара
class MotherboardFactory : ComponentFactory {
    override fun createComponent(id: Int, name: String, price: Double): Component {
        // Дополнительные параметры для материнской платы
        return Motherboard(id, name, price, "Socket123", 4, "DDR4")
    }
}

class ProcessorFactory : ComponentFactory {
    override fun createComponent(id: Int, name: String, price: Double): Component {
        // Дополнительные параметры для процессора
        return Processor(id, name, price, "Socket456", 8, 3.2)
    }
}

class HardDriveFactory : ComponentFactory {
    override fun createComponent(id: Int, name: String, price: Double): Component {
        // Дополнительные параметры для жесткого диска
        return HardDrive(id, name, price, 1000, 7200)
    }
}

fun main() {
    // Пример использования
    val motherboardFactory = MotherboardFactory()
    val processorFactory = ProcessorFactory()
    val hardDriveFactory = HardDriveFactory()

    val motherboard = motherboardFactory.createComponent(1, "ASUS XYZ", 150.0)
    val processor = processorFactory.createComponent(2, "Intel Core i7", 300.0)
    val hardDrive = hardDriveFactory.createComponent(3, "Seagate Barracuda", 80.0)

    println("1. Полная номенклатура комплектующих:")
    println("Motherboard:\n${motherboard.displayInfo()}\n")
    println("Processor:\n${processor.displayInfo()}\n")
    println("Hard Drive:\n${hardDrive.displayInfo()}\n")

    println("2. Детальная информация по товару (по номенклатурному номеру):")
    val componentId = 2 // Идентификатор компонента, для примера взят процессор
    val detailedComponent = processorFactory.createComponent(componentId, "Dummy Component", 0.0)
    println(detailedComponent.displayInfo())
}
