import java.lang.Integer.min
import java.util.*

class Solution12 {
    fun solution(num: Int): Int {
        var cache = Array<Int>(1000001) { 0 }

        // bottom-up
        for (i in 2..num) {
            if (i % 6 == 0) cache[i] = min(cache[i / 2], cache[i / 3]) + 1
            else if (i % 3 == 0) cache[i] = min(cache[i / 3], cache[i - 1]) + 1
            else if (i % 2 == 0) cache[i] = min(cache[i / 2], cache[i - 1]) + 1
            else cache[i] = cache[i - 1] + 1
        }

        return cache[num]
    }
}

fun main(args: Array<String>) {
    val n = Scanner(System.`in`)
    println(Solution12().solution(n.nextInt()))
}