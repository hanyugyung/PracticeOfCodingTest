fun solution58(s: String): Int {
    var answer: Int = 0

    var arr = intArrayOf(0, 0)

    var location = 0

    while(location < s.length) {
        var nextLocation = location+1
        var c = s[location]
        arr[0] = 1
        while(arr[0] != arr[1] && nextLocation < s.length) {
            if(s[nextLocation] == c) arr[0]++
            else arr[1]++
            nextLocation++
        }
        arr[0] = 0
        arr[1] = 0
        answer++
        location = nextLocation
    }

    return answer
}

fun main(args: Array<String>) {
    println(
        solution58(
            "aaabbaccccabba"
        )
    )
}