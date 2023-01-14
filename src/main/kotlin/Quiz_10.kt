
class Solution10 {
    fun solution(numbers: IntArray): Int {
        val lst = numbers.toList()
        return 45 - numbers.sum()
    }
}



fun main(args: Array<String>) {
    val solution10 = Solution10()
    println(solution10.solution(
        intArrayOf(1,2,3,4,6,7,8,0)
    ))
}