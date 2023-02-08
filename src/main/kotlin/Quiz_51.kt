fun solution51(emergency: IntArray): IntArray {
    var answer = IntArray(emergency.size)

    val lst = emergency.sortedDescending();

    for ((i, e) in emergency.withIndex()) {
        answer[i] = lst.indexOf(e) + 1
    }

    return answer
}

fun main(args: Array<String>) {
    println(
        solution51(
            intArrayOf(3, 76, 24)
        )
    )
}