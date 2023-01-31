
fun solution38(a: Int, b: Int, n: Int): Int {
    var answer: Int = 0

    var tmp = n

    while(tmp >= a) {
        answer += (tmp/a) * b
        tmp = (tmp%a + (tmp/a) * b)
    }

    return answer
}

fun main(args: Array<String>) {
    println(
        solution38(
            2, 1, 20
        )
    )
}