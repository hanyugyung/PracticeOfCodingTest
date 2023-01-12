import java.util.*

class Solution6 {
    fun solution(n: Int, k: Int): IntArray {

        var answer = mutableListOf<Int>()
        var arr: Array<Int> = Array(n) {i -> i + 1}

        var i = 1
        var cnt = 1
        while(answer.size != n) {

            if(cnt == k) {
                answer.add(arr[(i-1)%n])
                arr[(i-1)%n] = 0
                cnt = 0
            }

            i++
            if(arr[(i-1)%n] != 0) {
                cnt++
            }
        }

        return answer.toIntArray()
    }
}

fun main(args: Array<String>) {
    val solution6 = Solution6()

    var input = Scanner(System.`in`)

    val n = input.nextInt()
    val k = input.nextInt()
    val answer = solution6.solution(n, k)

    print("<")
    for(i in 0 until n) {
        if ( i == n-1) {
            print(answer[i])
        } else {
            print(answer[i].toString() + ", ")
        }
    }
    print(">")

}