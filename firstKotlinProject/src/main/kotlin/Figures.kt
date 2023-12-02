import kotlin.math.PI
import kotlin.math.pow
import kotlin.math.roundToInt
import kotlin.math.sqrt

abstract class GeometryObject(val height: Int, val baseLength: Int) {
    protected var _height: Int = 0
    protected var _baseLength: Int = 0
    protected var _lateralProjection: Double = 0.0
    protected var _aboveProjection: Double = 0.0
    protected var _volume: Double = 0.0

    init {
        _height = height;
        _baseLength = baseLength;
    }

    override fun toString(): String {
        return "Объем ${this.javaClass.toString().split(" ")[1]}: ${_volume.roundToInt()}\n" +
                "Площадь боковой проекции: ${_lateralProjection.roundToInt()}\n" +
                "Площадь проекции сверху: ${_aboveProjection.roundToInt()}"
    }
}

class Cone(height: Int, baseLength: Int) : GeometryObject(height, baseLength) {
    init {
        _aboveProjection = PI * _baseLength.toDouble().pow(2) / 4
        _lateralProjection = _baseLength.toDouble() * _height / 2;
        _volume = _aboveProjection * _height / 3
    }
}

class Cube(height: Int, baseLength: Int) : GeometryObject(height, baseLength) {
    init {
        _lateralProjection = _baseLength.toDouble().pow(2)
        _aboveProjection = _baseLength.toDouble().pow(2)
        _volume = _height.toDouble().pow(3);
    }
}

class Pyramid(height: Int, baseLength: Int) : GeometryObject(height, baseLength) {
    init {
        _lateralProjection = _baseLength.toDouble().pow(2)
        _aboveProjection = _baseLength.toDouble() * _height / 2
        _volume = _aboveProjection * _height / 3
    }
}

fun main(args: Array<String>) {
    println("Введите тип фигуры: ")
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
