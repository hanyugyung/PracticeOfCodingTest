import java.util.*

fun solution33(numbers: IntArray): IntArray {
    var answer = IntArray(numbers.size) {-1}

    var stack = Stack<Int>()
    for ((i, num) in numbers.withIndex()) {
        if (stack.empty()) {
            stack.push(i)
        } else {
            while (!stack.empty()) {
                if (numbers[stack.peek()] < num) {
                    answer[stack.pop()] = num
                } else {
                    stack.push(i)
                    break
                }
            }
            if(stack.empty()) stack.push(i)
        }
    }

    return answer
}


fun main(args: Array<String>) {
    println(
        solution33(
            intArrayOf(2, 3, 3, 5)
        )
    )
}