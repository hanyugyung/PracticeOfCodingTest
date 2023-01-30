fun solution36(t: String, p: String): Int {
    var answer: Int = 0

    var partLength = p.length
    var allLength = t.length

    var pInt = p.toLong()

    for (i in 0..allLength - partLength) {
        if (t.substring(i, i + partLength).toLong() <= pInt) answer++
    }

    return answer
}


fun main(args: Array<String>) {
    println(
        solution36(
            "2", "2"
        )
    )
}