import java.util.*

class Solution9 {
    fun solution(board: Array<IntArray>, moves: IntArray): Int {
        val stack = Stack<Int>()

        var answer = 0
        var last = 0
        moves.iterator().forEach {
            var nothing = true // 아무것도 빼지 않았을때
            for (i in board.indices) {
                if (board[i][it - 1] > 0) {
                    stack.push(board[i][it - 1])
                    board[i][it - 1] = 0
                    nothing = false
                    break
                }
            }

            if(!nothing) {
                if (stack.size >= 2 && last == stack.peek()) {
                    stack.pop()
                    stack.pop()
                    answer += 2
                }

                if (stack.isNotEmpty()) {
                    last = stack.peek()
                }
            }
        }

        return answer
    }
}



fun main(args: Array<String>) {
    val solution9 = Solution9()
    println(solution9.solution(
        arrayOf(intArrayOf(0,0,0,0,0)
            , intArrayOf(0,0,1,0,3)
            , intArrayOf(0,2,5,0,1)
            , intArrayOf(4,2,4,4,2)
            , intArrayOf(3,5,1,3,1))
        , intArrayOf(1,5,3,5,1,2,1,4)
    ))
}