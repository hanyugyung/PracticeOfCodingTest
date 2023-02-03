fun solution47(s: String, skip: String, index: Int): String {
    var answer: String = ""

    var alpha = "abcdefghijklmnopqrstuvwxyz".toList()
    var strArr = s.toCharArray()

    for(i in 0..strArr.size - 1) {
        var cnt = index
        var loc = alpha.indexOf(strArr[i])
        var j = 0
        while(cnt != 0) {
            j++
            if(!skip.contains(alpha[(loc+j)%26])) cnt--
        }
        answer += alpha[(loc+j) % 26]
    }


    return answer
}

fun main(args: Array<String>) {
    println(
        solution47(
            "ybcde", "az", 1
        )
    )
}