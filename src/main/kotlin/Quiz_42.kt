fun solution42(topping: IntArray): Int {
    var mineSet = mutableSetOf<Int>()
    var brotherSet = topping.toMutableSet()

    // 토핑 종류, 토핑 개수
    var map = mutableMapOf<Int, Int>()
    for (t in topping) {
        if (map.containsKey(t)) map[t] = map[t]!!.plus(1)
        else map[t] = 1
    }

    // 두 명의 토핑 종류가 같은 경우, <토핑 개수, 방법의 수>
    var tCnt = 0
    var answer = 0

    for (t in topping) {
        mineSet.add(t)
        if (map[t]!! > 1) {
            map[t] = map[t]!!.minus(1)
        } else {
            brotherSet.remove(t)
        }
        if (mineSet.size == brotherSet.size) {
            if (tCnt < mineSet.size) {
                tCnt = mineSet.size
                answer = 1
            } else if(tCnt == mineSet.size) {
                answer++
            }
        }
    }

    return answer

}

fun main(args: Array<String>) {
    println(
        solution42(
            intArrayOf(1, 2, 3, 1, 4)
        )
    )
}