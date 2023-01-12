class Solution2 {
    fun solution(today: String, terms: Array<String>, privacies: Array<String>): IntArray {
        var answer = mutableListOf<Int>()

        var map = mutableMapOf<String, Int>()
        for(term in terms) {
            var str = term.split(" ")
            map[str[0]] = str[1].toInt()*28
        }

        val todayY = today.substring(0, 4)
        val todayM = today.substring(5, 7)
        val todayD = today.substring(8, 10)
        for((i, privacy) in privacies.withIndex()) {
            val termDays: Int = if(privacy.substring(0, 4) == todayY) {
                (1 + 28 - privacy.substring(8, 10).toInt()) +
                        (todayM.toInt() - privacy.substring(5, 7).toInt() - 1) * 28 +
                        todayD.toInt()

                } else {
                    (1 + 28 - privacy.substring(8, 10).toInt()) +
                            (todayY.toInt() - privacy.substring(0, 4).toInt() - 1) * 12 * 28 +
                            (12 - privacy.substring(5, 7).toInt() + todayM.toInt() - 1) * 28 +
                            todayD.toInt()
                }
            if(map[privacy.substring(11)]!! < termDays) {
                answer.add(i+1)
            }
        }

        return answer.toIntArray()
    }
}