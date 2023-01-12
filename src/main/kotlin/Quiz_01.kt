class Solution1 {
    fun solution(survey: Array<String>, choices: IntArray): String {
        var typeMap = mutableMapOf("R" to 0
                , "T" to 0
                , "C" to 0
                , "F" to 0
                , "J" to 0
                , "M" to 0
                , "A" to 0
                , "N" to 0)

        val result: (String, Int) -> Unit = { type, choice ->
        if(choice > 4) {
            typeMap[type.substring(1)] = typeMap[type.substring(1)]!! + (choice - 4)
        } else if(choice < 4) {
            typeMap[type.substring(0, 1)] = typeMap[type.substring(0, 1)]!! + (4 - choice)
        }
    }

        // 검사 시작
        for(i in 0..survey.size-1) result(survey[i], choices[i])

        // 성격 유형 도출
        var answer:String = ""
        answer += (if(typeMap["R"]!! >= typeMap["T"]!!) "R" else "T")
        answer += (if(typeMap["C"]!! >= typeMap["F"]!!) "C" else "F")
        answer += (if(typeMap["J"]!! >= typeMap["M"]!!) "J" else "M")
        answer += (if(typeMap["A"]!! >= typeMap["N"]!!) "A" else "N")

        return answer
    }
}
