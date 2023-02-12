import java.util.Collections
import java.util.stream.Collectors

fun solution55(genres: Array<String>, plays: IntArray): IntArray {

    var map = mutableMapOf<String, Int>()
    for(i in plays.indices) {
        map[genres[i]] = (if(map[genres[i]] == null) 0 else map[genres[i]])!! + plays[i]
    }

    var sortedGenres = map.entries.sortedByDescending { it.value }
        .map { it.key }

    var sortedPlayMap = mutableMapOf<String, List<Pair<Int, Int>>>()

    var zipList = genres.zip(plays.mapIndexed { index, play -> Pair(index, play) })

    var answerList = mutableListOf<Int>()

    for(genre in sortedGenres) {
        sortedPlayMap[genre] = zipList.filter { it.first  == genre}.map { it.second }
            .sortedWith (compareBy<Pair<Int, Int>> { it.second }.reversed().thenBy { it.first }).take(2)
        answerList.addAll(sortedPlayMap[genre]!!.stream().map { it.first }.collect(Collectors.toList()))
    }


    return answerList.toIntArray()
}

fun main(args: Array<String>) {
    println(
        solution55(
            arrayOf("classic", "pop", "classic", "classic"), intArrayOf(500, 2500, 800, 800)
        )
    )
}