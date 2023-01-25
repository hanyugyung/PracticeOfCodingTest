fun solution26(k: Int, tangerine: IntArray): Int {
    var answer: Int = 0

    var map = mutableMapOf<Int, Int>()

    for(i in tangerine.indices) {
        if(map.containsKey(tangerine[i])) map.put(tangerine[i], map[tangerine[i]]!! + 1)
        else map.put(tangerine[i], 1)
    }

    val lst = map.values.toList().sortedDescending()

    var tmp = 0
    var i = 0
    do {
        tmp += lst[i]
        answer++
        i++
    } while (tmp < k)

    return answer
}

fun main(args: Array<String>) {
    println(
        solution26(
            1, intArrayOf(
                1
            )
        )
    )
}