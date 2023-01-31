import java.util.*

fun solution37(ingredient: IntArray): Int {
    var answer: Int = 0

    var stack = Stack<Int>()

    for (i in 0..ingredient.size - 1) {
        if (stack.size < 3) stack.push(ingredient[i])
        else {
            if (ingredient[i] != 1) {
                stack.push(ingredient[i])
                continue
            }
            var m = stack.peek()
            if (m != 3) {
                stack.push(ingredient[i])
                continue
            }
            stack.pop()
            var v = stack.peek()
            if (v != 2) {
                stack.push(m)
                stack.push(ingredient[i])
                continue
            }
            stack.pop()
            var b = stack.peek()
            if (b != 1) {
                stack.push(v)
                stack.push(m)
                stack.push(ingredient[i])
                continue
            }
            stack.pop()
            answer++
        }
    }

    return answer
}

fun main(args: Array<String>) {
    println(
        solution37(
            intArrayOf(2, 1, 1, 2, 3, 1, 2, 3, 1)
        )
    )
}