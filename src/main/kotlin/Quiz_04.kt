class Solution4 {
    fun solution(new_id: String): String {

        var answer = new_id

        while(!isAppropriate(answer)) {
            answer = recommendId(answer)
        }

        return answer

    }

    private fun isAppropriate(new_id: String): Boolean {
        if(new_id.length !in 3..15) return false
        if(new_id.any { c -> "~!@#\$%^&*()=+[{]}:?,<>/".contains(c) || c.isUpperCase() })  return false
        if(new_id.startsWith(".") || new_id.endsWith(".")) return false

        return true
    }

    private fun recommendId(new_id: String): String {
        var recommendedId = new_id

        // 1
        recommendedId = recommendedId.lowercase()

        // 2
        recommendedId = recommendedId.filter { c -> !"~!@#\$%^&*()=+[{]}:?,<>/".contains(c) }

        // 3
        while(recommendedId.contains("..")) {
            recommendedId = recommendedId.replace("..", ".")
        }

        // 4
        if(recommendedId.startsWith(".")) recommendedId = recommendedId.substring(1)
        if(recommendedId.endsWith(".")) recommendedId = recommendedId.substring(0, recommendedId.length-1)

        // 5
        if(recommendedId.isEmpty()) recommendedId = "a"

        // 6
        if(recommendedId.length > 15) recommendedId = recommendedId.substring(0, 15)

        // 7
        if(recommendedId.length < 3) {
            while(recommendedId.length != 3) {
                recommendedId += recommendedId.substring(recommendedId.length-1)
            }
        }

        return recommendedId
    }
}