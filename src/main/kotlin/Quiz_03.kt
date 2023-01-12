class Solution3 {
    fun solution(id_list: Array<String>, report: Array<String>, k: Int): IntArray {

        var reportLst = report.toList().distinct()

        var map = mutableMapOf<String, Int>()
        id_list.iterator().forEach {
            map[it] = 0
        }

        var limitedIdMap = mutableMapOf<String, MutableList<String>>()
        reportLst.iterator().forEach {
            var arr = it.split(" ") // arr[0] -> 신고자, arr[1] -> 신고당한자
            if(limitedIdMap.containsKey(arr[1])) {
                limitedIdMap[arr[1]]?.add(arr[0])
            } else {
                limitedIdMap[arr[1]] = mutableListOf(arr[0])
            }
        }

        limitedIdMap
            .filter { (key, value) -> value.size >= k }
            .flatMap { it.value }
            .forEach { map[it] = map[it]!! + 1 }

        var answer = map.map { map[it.key]!! }
        return answer.toIntArray()
    }
}