import kotlin.math.abs

class Solution8 {

    private val numberMap = mapOf<Int, Pair<Int, Int>>(1 to Pair(0, 0), 2 to Pair(0, 1), 3 to Pair(0, 2)
        , 4 to Pair(1, 0), 5 to Pair(1, 1), 6 to Pair(1, 2)
        , 7 to Pair(2, 0), 8 to Pair(2, 1), 9 to Pair(2, 2)
        , 10 to Pair(3, 0), 0 to Pair(3, 1), 12 to Pair(3, 2))

    fun solution(numbers: IntArray, hand: String): String {

        var answer = ""
        var leftHandPointer = 10
        var rightHandPointer = 12
        numbers.iterator().forEach {
            if(it == 1 || it == 4 || it == 7) {
                answer += "L"
                leftHandPointer = it
            } else if(it == 3 || it == 6 || it == 9){
                answer += "R"
                rightHandPointer = it
            } else {
                // 근접한 손 찾기
                var tmpAns = compareDistance(it, hand, leftHandPointer, rightHandPointer)
                answer += tmpAns
                if(tmpAns == "L") leftHandPointer = it else rightHandPointer = it
            }
        }

        return answer
    }

    private fun compareDistance(location: Int, hand: String, left: Int, right: Int) : String {
        var p = numberMap[location]!!
        var pLeft = numberMap[left]!!
        var pRight = numberMap[right]!!

        var distanceLeft = abs(p.first - pLeft.first) + abs(p.second - pLeft.second)
        var distanceRight = abs(p.first - pRight.first) + abs(p.second - pRight.second)

        if(distanceLeft < distanceRight) {
            return "L"
        } else if (distanceLeft > distanceRight) {
            return "R"
        } else {
            return if (hand == "left") "L" else "R"
        }
    }
}



fun main(args: Array<String>) {
    val solution8 = Solution8()
    println(solution8.solution(intArrayOf(1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5), "right"))
}