import kotlin.math.sqrt

fun solution49(number: Int, limit: Int, power: Int): Int {

    // 약수 구하는 알고리즘
    // 대상 값의 제곱근까지 0으로 나누어 떨어지는 수를 구한 뒤, 그 값들로 대상 값을 나누고 나눈 후 나온 값들을 모두 합친 값
    // O(sqrt(x)) 시간복잡도로 해결 가능

    var weapon = IntArray(number)
    weapon[0] = 1

    var lst = mutableSetOf<Int>()
    for(i in 2..number) {
        var num = sqrt(i.toFloat()).toInt()
        for(j in 1..num) {
            if(i % j == 0) {
                lst.add(j)
                lst.add(i/j)
            }
        }

        weapon[i-1] = if(lst.size > limit) power else lst.size
        lst.clear()
    }

    return weapon.sum()
}

fun main(args: Array<String>) {
    println(
        solution49(
            5, 3, 2
        )
    )
}