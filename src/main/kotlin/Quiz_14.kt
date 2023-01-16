import java.lang.Integer.max
import java.util.*

fun solution(num: Int, arr: Array<IntArray>): Int {
    var cache = arrayOf(IntArray(num+1){0}, IntArray(num+1){0})

    cache[0][1] = arr[0][1]
    cache[1][1] = arr[1][1]

    if(num > 1) {
        cache[0][2] = cache[1][1] + arr[0][2]
        cache[1][2] = cache[0][1] + arr[1][2]

        for(i in 3..num) {
            for(j in 0..1) {
                cache[j][i] = max(cache[1-j][i-1], cache[1-j][i-2]) + arr[j][i]
            }

        }
    }

    return max(cache[0][num], cache[1][num])
}

fun main(args: Array<String>) {
    var sc = Scanner(System.`in`)
    var testCount = sc.nextInt()
    sc.nextLine()
    repeat(testCount) {
        val n = sc.nextInt()
        sc.nextLine()
        var arr = arrayOf(IntArray(n+1){0}, IntArray(n+1){0})
        for(i in 0..1) {
            for(j in 1..n) {
                arr[i][j] = sc.nextInt()
            }
            sc.nextLine()
        }

        println(solution(n, arr))
    }
}