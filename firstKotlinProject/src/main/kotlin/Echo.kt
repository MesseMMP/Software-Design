fun main(args: Array<String>) {
    val inputString: String = readln()
    val arrayWords: List<String> = inputString.split(" ")
    val lastWord: String = arrayWords[arrayWords.lastIndex]
    println(inputString)
    repeat(3){
        println(lastWord)
    }
}
