import java.util.*

class Solution13 {
    fun solution(num: Int): Int {
        var cache = Array(1001) { 0 }

        // bottom-up
        for (i in 1..num) {
            when (i) {
                1 -> cache[1] = 1
                2 -> cache[2] = 2

                // (cache[i-2] + cache[i-1]) % 10007 와 cache[i] % 10007 는 같은 값
                // 오버플로우 방지를 위해 매 연산 시 % 연산
                else -> cache[i] = (cache[i-2] + cache[i-1]) % 10007
            }
        }

        return cache[num]
    }
}

fun main(args: Array<String>) {
    val n = Scanner(System.`in`)
    println(Solution13().solution(n.nextInt()))
}