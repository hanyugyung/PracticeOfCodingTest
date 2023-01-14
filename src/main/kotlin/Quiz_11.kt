
class Solution11 {
    fun solution(numbers: IntArray, signs: BooleanArray): Int {
        val to : (Int, Boolean) -> Int = {
            number, sign -> if(sign) number else number*(-1)
        }

        var answer = 0
        for(i in numbers.indices) answer += to(numbers[i], signs[i])

        return answer
    }
}

fun main(args: Array<String>) {
    val solution11 = Solution11()
    println(solution11.solution(
        intArrayOf(4,7,12), booleanArrayOf(true,false,true)
    ))
}