
fun solution41(clothes: Array<Array<String>>): Int {
    var answer = 1

    var map = mutableMapOf<String, Int>()

    clothes.forEach {
        if(map.containsKey(it[1])) {
            map[it[1]] = map[it[1]]!!.plus(1)
        } else {
            map[it[1]] = 1
        }
    }

    for(v in map.values) {
        answer *= (1+v)
    }

    return answer - 1 // a b c 는 의상 수, (1+a)(1+b)(1+c) - 1 == (a+b+c) + (ab + bc + ca) + abc
}

fun main(args: Array<String>) {
    println(
        solution41(
            arrayOf(arrayOf("yellow_hat", "headgear"), arrayOf("blue_sunglasses", "eyewear"), arrayOf("green_turban", "headgear"))
        )
    )
}