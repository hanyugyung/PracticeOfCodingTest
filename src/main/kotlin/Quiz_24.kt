fun solution24(n: Int, computers: Array<IntArray>): Int {
    var answer = 0

    // 대칭 확인, 대칭이 아닌 경우 대칭으로 바꿔줌
    for (i in computers.indices) {
        for (j in i until computers.size) {
            if (computers[i][j] != computers[j][i]) {
                computers[i][j] = 1
                computers[j][i] = 1
            }
        }
    }

    fun dfs(i: Int, j: Int) {
        computers[i][j] = 0
        for (k in computers.indices) {
            if (computers[i][k] == 1) {
                computers[i][k] = 0
                dfs(k, k)
            }
        }
    }

    for (i in computers.indices) {
        if (computers[i][i] == 0) {
            continue;
        }
        answer++
        dfs(i, i)
    }

    return answer
}

fun main(args: Array<String>) {

    println(
        solution24(
            5, arrayOf(
                intArrayOf(1, 1, 1, 1, 0),
                intArrayOf(1, 1, 0, 0, 1),
                intArrayOf(0, 0, 1, 0, 0),
                intArrayOf(1, 0, 0, 1, 0),
                intArrayOf(0, 1, 0, 0, 1)
            )
        )
    )

    println(
        solution24(
            2, arrayOf(
                intArrayOf(1, 0), intArrayOf(0, 1)
            )
        )
    )

    println(
        solution24(
            3, arrayOf(
                intArrayOf(1, 1, 1), (intArrayOf(1, 1, 1)), intArrayOf(1, 1, 1)
            )
        )
    )

    println(solution24(1, arrayOf(intArrayOf(1))))

    println(
        solution24(
            5, arrayOf(
                intArrayOf(1, 1, 0, 0, 0),
                intArrayOf(1, 1, 1, 0, 0),
                intArrayOf(0, 1, 1, 1, 0),
                intArrayOf(0, 0, 1, 1, 1),
                intArrayOf(0, 0, 0, 1, 1)
            )
        )
    )

    println(
        solution24(
            7, arrayOf(
                intArrayOf(1, 0, 0, 0, 0, 0, 1),
                intArrayOf(0, 1, 1, 0, 1, 0, 0),
                intArrayOf(0, 1, 1, 1, 0, 0, 0),
                intArrayOf(0, 0, 1, 1, 0, 0, 0),
                intArrayOf(0, 1, 0, 0, 1, 1, 0),
                intArrayOf(0, 0, 0, 0, 1, 1, 1),
                intArrayOf(1, 0, 0, 0, 0, 1, 1)
            )
        )
    )
}