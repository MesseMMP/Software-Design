import kotlin.math.PI
import kotlin.math.pow
import kotlin.math.roundToInt

abstract class GeometryObject(height: Int, baseLength: Int) {
    protected var _height: Int = 0
    protected var _baseLength: Int = 0

    init {
        _height = height;
        _baseLength = baseLength;
    }

    abstract fun findAboveProjection(): Double
    abstract fun findLateralProjection(): Double
    abstract fun findVolume(): Double

    override fun toString(): String {
        return "Объем ${this.javaClass.toString().split(" ")[1]}: ${findVolume().roundToInt()}\n" +
                "Площадь боковой проекции: ${findLateralProjection().roundToInt()}\n" +
                "Площадь проекции сверху: ${findAboveProjection().roundToInt()}"
    }
}

class Cone(height: Int, baseLength: Int) : GeometryObject(height, baseLength) {

    override fun findAboveProjection(): Double {
        return PI * _baseLength.toDouble().pow(2) / 4
    }

    override fun findLateralProjection(): Double {
        return _baseLength.toDouble() * _height / 2;
    }

    override fun findVolume(): Double {
        return PI * _baseLength.toDouble().pow(2) * _height / 12
    }
}

class Cube(height: Int, baseLength: Int) : GeometryObject(height, baseLength) {

    override fun findAboveProjection(): Double {
        return _baseLength.toDouble().pow(2)
    }

    override fun findLateralProjection(): Double {
        return _baseLength.toDouble().pow(2)
    }

    override fun findVolume(): Double {
        return _baseLength.toDouble().pow(3);
    }

}

class Pyramid(height: Int, baseLength: Int) : GeometryObject(height, baseLength) {

    override fun findAboveProjection(): Double {
        return _baseLength.toDouble().pow(2)
    }

    override fun findLateralProjection(): Double {
        return _baseLength.toDouble() * _height / 2
    }

    override fun findVolume(): Double {
        return _baseLength.toDouble().pow(2) * _height / 3
    }

}

fun main(args: Array<String>) {
    println("Введите тип фигуры(конус/куб/пирамида): ")
    val name: String = readln()
    println("Введите высоту фигуры: ")
    val height: Int = readln().toInt()
    println("Введите основание/диаметр фигуры: ")
    val baseLength: Int = readln().toInt()
    val figure: GeometryObject;
    when (name) {
        "конус" -> {
            figure = Cone(height, baseLength)
            println(figure)
        }

        "куб" -> {
            figure = Cube(height, baseLength)
            println(figure)
        }

        "пирамида" -> {
            figure = Pyramid(height, baseLength)
            println(figure)
        }

        else -> println("Некорректное название фигуры!")
    }
}
