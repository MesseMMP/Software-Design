import kotlin.random.Random

fun main(args: Array<String>) {
    val n: Int = readln().toInt();
    val table: Array<Array<Int>> = Array(n) { Array(n) { 0 } }
    for (i in 0..<n){
        for(j in 0..<n){
            val randomNumber = Random.nextInt(0, 10)
            table[i][j] = randomNumber;
        }
    }
    var sum = 0
    for (i in 1..<n){
        var j = n-1
        repeat(i){
            sum += table[i][j]
            --j
        }
    }

    for(row in table){
        for(cell in row){
            print("$cell ")
        }
        println()
    }
    println("\nСумма чисел под побочной диагональю: $sum")
}

