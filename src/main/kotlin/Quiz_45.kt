fun solution45(n: Int): String {
    var answer = ""

    var subak = arrayOf("수", "박")
    for(i in 0..n-1) {
        answer += subak[i%2]
    }

    return answer
}

fun main(args: Array<String>) {
    println(
        solution45(
            5
        )
    )
}