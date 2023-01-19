import java.util.*

fun solution(location: Int, length: Int, arr: IntArray): Int {

    var answer = 1

    Arrays.sort(arr) // 정렬

    var tapeStart: Double = arr[0] - 0.5
    var tapeEnd: Double = tapeStart + length

    for (i in 1 until location) {
        if (arr[i] > tapeEnd) {
            answer++
            tapeStart = arr[i] - 0.5
            tapeEnd = tapeStart + length
        }
    }

    return answer;
}

fun main(args: Array<String>) {
    var sc = Scanner(System.`in`)
    var location = sc.nextInt()
    var length = sc.nextInt()
    sc.nextLine()

    var arr = IntArray(location) { 0 }


    for (i in 0 until location) {
        arr[i] = sc.nextInt()
    }

    println(solution(location, length, arr))
}