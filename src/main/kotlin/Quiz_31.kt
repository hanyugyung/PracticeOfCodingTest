fun solution31(maps: Array<String>): IntArray {
    var answer = mutableListOf<Int>()

    var w = maps.size
    var h = maps[0].length

    val mapArr = Array(w) { Array(h) { "-1" } }
    for (i in 0..w - 1) {
        mapArr[i] = maps[i].toCharArray().map { it -> it.toString() }.toTypedArray()
    }

    val direction = arrayOf(arrayOf(0, 1), arrayOf(1, 0), arrayOf(0, -1), arrayOf(-1, 0))

    fun dfs(i: Int, j: Int, mapArr: Array<Array<String>>): Int {

        if (!((i >= 0 && i < w) && (j >= 0 && j < h)) || mapArr[i][j] == "0") return 0
        if (mapArr[i][j] == "X") {
            mapArr[i][j] = "0"
            return 0
        }
        var tmp = mapArr[i][j].toInt()

        mapArr[i][j] = "0"

        for (k in 0..3) {
            tmp += dfs(i + direction[k][0], j + direction[k][1], mapArr)
        }

        return tmp
    }

    for (i in 0..w - 1) {
        var tmp = 0
        for (j in 0..h - 1) {
            tmp += dfs(i, j, mapArr)
            if (tmp != 0) answer.add(tmp)
            tmp = 0
        }
    }

    return if (answer.size == 0) IntArray(1) { -1 } else answer.sorted().toIntArray()
}


fun main(args: Array<String>) {
    println(
        solution31(
            arrayOf(
                "X591X", "X1X5X", "X231X", "1XXX1"
            )
        ).joinToString(" ,")
    )
}