fun solution30(numbers: IntArray): String {
    val answer = numbers.map { it.toString() }
        .sortedWith { s1, s2 -> (s2 + s1).compareTo(s1 + s2) }
        .joinToString("")

    return if (answer.startsWith("0")) "0" else answer
}


fun main(args: Array<String>) {
    println(
        solution30(
            intArrayOf(
                9, 3, 30, 34, 5
            )
        )
    )
}