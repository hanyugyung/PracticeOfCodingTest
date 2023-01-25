fun solution27(fees: IntArray, records: Array<String>): IntArray {

    var carMap = mutableMapOf<String, MutableList<String>>()

    // 차번호 - 출입기록
    for(i in records.indices) {
        val tmp = records[i].split(" ")
        if(carMap.containsKey(tmp[1])) {
            var record = carMap[tmp[1]]!!
            record.add(tmp[0])
            carMap.put(tmp[1], record)
        }
        else carMap.put(tmp[1], mutableListOf(tmp[0]))
    }

    var lst = carMap.map{
        var fee = 0
        val tmp = it.value
        if(tmp.size % 2 == 1) tmp.add("23:59")
        for(i in 1..tmp.size - 1 step 2) {
            fee += calculateMinute(tmp[i-1], tmp[i])
        }

        if(fees[0] >= fee) {
            fee = fees[1]
        } else {
            fee = if((fee-fees[0]) % fees[2] == 0) fees[1] + (fee-fees[0])/fees[2] * fees[3]
                else fees[1] + ((fee-fees[0])/fees[2] * fees[3]) + fees[3]
        }

        Pair(it.key, fee)
    }.sortedBy { it.first }.map { it.second }


    return lst.toIntArray()
}

fun calculateMinute(inTime: String, outTime: String) : Int {
    var m_in = inTime.substring(3)
    var h_in = inTime.substring(0, 2)

    var m_out = outTime.substring(3)
    var h_out = outTime.substring(0, 2)

    return 60 - m_in.toInt() + m_out.toInt() + (h_out.toInt() - h_in.toInt() - 1) * 60
}


fun main(args: Array<String>) {
    println(
        solution27(
            intArrayOf(
                180, 5000, 10, 600
            ), arrayOf(
                "05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"
            )
        )
    )
}