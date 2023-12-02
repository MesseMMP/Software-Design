fun main(args: Array<String>) {
    var count = 0;
    for (i in 0..<args.lastIndex){
        if (args[i] == args[i+1]){
            ++count
        }
    }
    println(args.size - count)
}
