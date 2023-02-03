fun solution46(s: String): IntArray {
    var answer: IntArray = IntArray(s.length)

    var cArr = s.toCharArray()

    answer[0] = -1
    for(i in 1..cArr.size-1) {
        var tmpIndex = 0
        for(j in 0..i-1) {
            if(cArr[i] == cArr[j]) {
                tmpIndex = (i-j)
            }
        }
        if(tmpIndex == 0) answer[i] = -1
        else answer[i] = tmpIndex
    }

    return answer
}

fun main(args: Array<String>) {
    println(
        solution46(
            "banana"
        )
    )
}