fun solution32(number: IntArray): Int {
    var answer: Int = 0

    for(i in 0..number.size - 1) {
        for(j in 0.. number.size - 1) {
            for(k in 0..number.size - 1) {
                if(i != j && j != k && i != k) {
                    if(number[i] + number[j] + number[k] == 0) answer++
                }
            }
        }
    }

    return answer / 6 // 3개를 뽑아 특정 수 0을 만드는 경우 순서를 고려하지 않으므로 3! 만큼 나눈다
}

fun main(args: Array<String>) {
    println(
        solution32(
            intArrayOf(0, 0, 0)
        )
    )
}