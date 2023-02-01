
fun solution40(array: IntArray, commands: Array<IntArray>): IntArray {
    var answer = IntArray(commands.size)

    commands.forEachIndexed { cmd_index, it ->
        answer[cmd_index] = array.filterIndexed { index, i -> index >= it[0]-1 && index <= it[1]-1 }.sorted()[it[2]-1]
    }

    return answer
}

fun main(args: Array<String>) {
    println(
        solution40(
            intArrayOf(1, 5, 2, 6, 3, 7, 4)
        , arrayOf(intArrayOf(2, 5, 3), intArrayOf(4, 4, 1), intArrayOf(1, 7, 3))
        )
    )
}