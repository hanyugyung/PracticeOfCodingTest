fun solution(numbers: IntArray, target: Int): Int {
    var answer = 0

    fun dfs(sum: Int, i : Int) {
        if(i == numbers.size - 1) {
            if(sum + numbers[i] == target) answer++;
            if(sum + numbers[i]*(-1) == target) answer++;
        } else {
            dfs(sum+numbers[i], i+1)
            dfs(sum+numbers[i]*(-1), i+1)
        }
    }

    dfs(0, 0)

    return answer
}

fun main(args: Array<String>) {


    println(solution(intArrayOf(4, 1, 2, 1), 4))
}