import kotlin.math.PI
import kotlin.math.pow
import kotlin.math.roundToInt

abstract class GeometryObject(height: Int, baseLength: Int) {
    protected var _height: Int = 0
    protected var _baseLength: Int = 0
    protected var _lateralProjection: Double = 0.0
    protected var _aboveProjection: Double = 0.0
    protected var _volume: Double = 0.0

    init {
        _height = height;
        _baseLength = baseLength;
    }

    abstract fun findAboveProjection()
    abstract fun findLateralProjection()
    abstract fun findVolume()

    override fun toString(): String {
        return "Объем ${this.javaClass.toString().split(" ")[1]}: ${_volume.roundToInt()}\n" +
                "Площадь боковой проекции: ${_lateralProjection.roundToInt()}\n" +
                "Площадь проекции сверху: ${_aboveProjection.roundToInt()}"
    }
}

class Cone(height: Int, baseLength: Int) : GeometryObject(height, baseLength) {

    override fun findAboveProjection() {
        _aboveProjection = PI * _baseLength.toDouble().pow(2) / 4
    }

    override fun findLateralProjection() {
        _lateralProjection = _baseLength.toDouble() * _height / 2;
    }

    override fun findVolume() {
        _volume = PI * _baseLength.toDouble().pow(2) * _height / 12
    }
}

class Cube(height: Int, baseLength: Int) : GeometryObject(height, baseLength) {

    override fun findAboveProjection() {
        _aboveProjection = _baseLength.toDouble().pow(2)
    }

    override fun findLateralProjection() {
        _lateralProjection = _baseLength.toDouble().pow(2)
    }

    override fun findVolume() {
        _volume = _baseLength.toDouble().pow(3);
    }

}

class Pyramid(height: Int, baseLength: Int) : GeometryObject(height, baseLength) {

    override fun findAboveProjection() {
        _aboveProjection = _baseLength.toDouble().pow(2)
    }

    override fun findLateralProjection() {
        _lateralProjection = _baseLength.toDouble() * _height / 2
    }

    override fun findVolume() {
        _volume = _baseLength.toDouble().pow(2) * _height / 3
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
            figure.findAboveProjection()
            figure.findLateralProjection()
            figure.findVolume()
            println(figure)
        }

        "куб" -> {
            figure = Cube(height, baseLength)
            figure.findAboveProjection()
            figure.findLateralProjection()
            figure.findVolume()
            println(figure)
        }

        "пирамида" -> {
            figure = Pyramid(height, baseLength)
            figure.findAboveProjection()
            figure.findLateralProjection()
            figure.findVolume()
            println(figure)
        }

        else -> println("Некорректное название фигуры!")
    }
}
