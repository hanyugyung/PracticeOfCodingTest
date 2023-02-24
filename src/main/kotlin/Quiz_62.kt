fun solution62(keymap: Array<String>, targets: Array<String>): IntArray {

    var answer = IntArray(targets.size)

    var map = mutableMapOf<Char, Int>()

    for (key in keymap) {
        val cArr = key.toCharArray()
        for ((i, c) in cArr.withIndex()) {
            if (map.containsKey(c)) {
                if (map[c]!! > i + 1) map[c] = i + 1
            } else map[c] = i + 1
        }
    }

    for((i, t) in targets.withIndex()) {
        var cnt = 0
        val cArr = t.toCharArray()
        for (c in cArr) {
            if (map.containsKey(c)) {
                cnt += map[c]!!
            } else {
                cnt = -1
                break
            }
        }

        answer[i] = cnt
    }

    return answer
}

fun main(args: Array<String>) {
    println(
        solution62(
            arrayOf("ABACD", "BCEFD"), arrayOf("ABCD", "AABB")
        )
    )
}