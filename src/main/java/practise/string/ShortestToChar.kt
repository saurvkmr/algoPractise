package practise.string
// https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/584/week-1-february-1st-february-7th/3631/
fun main() {
    shortestToChar("loveleetcode", 'e')
}

private fun shortestToChar(s: String, c: Char): IntArray {
    val result = IntArray(s.length)
    for (i in s.indices) {
        if (s[i] == c)
            result[i] = 0
        else
            result[i] = 200
    }
    var charIdx = 0
    while (charIdx < result.size) {
        if (result[charIdx] == 0)
            for (i in result.indices) {
                result[i] = Math.min(result[i], Math.abs(i - charIdx))
            }
        charIdx++
    }
    return result
}