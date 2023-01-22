fun solution25(sizes: Array<IntArray>): Int {

    sizes.forEach {
        if(it[0] < it[1]) {
            val tmp = it[0]
            it[0] = it[1]
            it[1] = tmp
        }
    }

    var maxW = sizes[0][0]
    var maxH = sizes[0][1]
    for(i in sizes.indices) {
        if(sizes[i][0] > maxW) maxW = sizes[i][0]
        if(sizes[i][1] > maxH) maxH = sizes[i][1]
    }

    return maxW * maxH
}

fun main(args: Array<String>) {
    println(
        solution25(
            arrayOf(
                intArrayOf(10, 7),
                intArrayOf(12, 3),
                intArrayOf(8, 15),
                intArrayOf(14, 7),
                intArrayOf(5, 15)
            )
        )
    )
}