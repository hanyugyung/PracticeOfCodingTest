fun solution28(progresses: IntArray, speeds: IntArray): IntArray {
    var answer = mutableListOf<Int>()

    val total = progresses.size
    var lst = IntArray(total) {0} // 작업이 소요되는 일수

    for(i in 0 until total) {
        lst[i] = (if ((100-progresses[i]) % speeds[i] == 0) (100-progresses[i]) / speeds[i] else (100-progresses[i]) / speeds[i] + 1)
    }

    for(i in lst.indices) {
        var count = 1
        if( lst[i] == 0 ) continue
        else {
            for(j in i+1..total-1) {
                if(lst[i] >= lst[j]) {
                    count++
                    lst[j] = 0
                } else {
                    break
                }
            }
        }
        answer.add(count)
    }

    return answer.toIntArray()
}


fun main(args: Array<String>) {
    println(
        solution28(
            intArrayOf(
                95, 90, 99, 99, 80, 99
            ), intArrayOf(
                1, 1, 1, 1, 1, 1
            )
        ).joinToString(" ,")
    )
}