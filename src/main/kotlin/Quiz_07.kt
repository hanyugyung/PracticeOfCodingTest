import java.util.*

class Solution7 {
    fun solution(s: String): Int {
        var answer = s.replace("zero", "0")
        answer = answer.replace("one", "1")
        answer = answer.replace("two", "2")
        answer = answer.replace("three", "3")
        answer = answer.replace("four", "4")
        answer = answer.replace("five", "5")
        answer = answer.replace("six", "6")
        answer = answer.replace("seven", "7")
        answer = answer.replace("eight", "8")
        answer = answer.replace("nine", "9")
        return answer.toInt()
    }
}

fun main(args: Array<String>) {
    val solution7 = Solution7()
    println(solution7.solution("one4seveneight"))
}