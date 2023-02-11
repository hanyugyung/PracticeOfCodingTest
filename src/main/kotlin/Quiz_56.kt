fun solution55(answers: IntArray): IntArray {

    var supoza_1 = intArrayOf(1,2,3,4,5)
    var supoza_2 = intArrayOf(2,1,2,3,2,4,2,5)
    var supoza_3 = intArrayOf(3,3,1,1,2,2,4,4,5,5)

    var supoza_1_score = 0
    var supoza_2_score = 0
    var supoza_3_score = 0

    for(i in 0..answers.size-1) {
        if(supoza_1[i%5] == answers[i]) supoza_1_score++
        if(supoza_2[i%8] == answers[i]) supoza_2_score++
        if(supoza_3[i%10] == answers[i]) supoza_3_score++
    }

    var maxScore = Math.max(Math.max(supoza_1_score, supoza_2_score), supoza_3_score)

    var answerLst = mutableListOf<Int>()
    if(supoza_1_score == maxScore) answerLst.add(1)
    if(supoza_2_score == maxScore) answerLst.add(2)
    if(supoza_3_score == maxScore) answerLst.add(3)

    return answerLst.toIntArray()
}

fun main(args: Array<String>) {
    println(
        solution55(
            intArrayOf(1,2,3,4,5)
        )
    )
}