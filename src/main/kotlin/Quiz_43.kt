fun solution43(data: Array<IntArray>, col: Int, row_begin: Int, row_end: Int): Int {
    var answer: Int = 0

    var sortedData = data.sortedWith(compareBy<IntArray> { it[col-1] }.thenBy { -it[0] })

    for(i in row_begin-1..row_end-1) {
        var currTmp = 0
        for(j in sortedData[i]) {
            if(i == row_begin-1) {
                answer += (j % (i+1))
            }
            else {
                currTmp += (j % (i+1))
            }
        }
        if(i != row_begin-1) {
            answer = answer xor currTmp
        }
    }

    return answer
}

fun main(args: Array<String>) {
    println(
        solution43(
            arrayOf(intArrayOf(2,2,6), intArrayOf(1,5,10), intArrayOf(4,2,9), intArrayOf(3,8,3)), 2, 2, 3
        )
    )
}