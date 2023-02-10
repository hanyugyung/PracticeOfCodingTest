fun solution52(elements: IntArray): Int {
    var numSet = HashSet<Int>()
    numSet.add(elements.sum())
    for(i in 0..elements.size-2) {
        for(j in 0..elements.size-1) {
            var tmp = 0
            for(k in j..i+j) {
                tmp += elements[k%elements.size]
            }
            numSet.add(tmp)
        }
    }
    return numSet.size
}

fun main(args: Array<String>) {
    println(
        solution52(
            intArrayOf(7,9,1,1,4)
        )
    )
}