package practise.string

/*
Given two equal-size strings s and t. In one step you can choose any character of t and replace it with another character.
Return the minimum number of steps to make t an anagram of s.
An Anagram of a string is a string that contains the same characters with a different (or the same) ordering.
Input: s = "bab", t = "aba"
Output: 1
Explanation: Replace the first 'a' in t with b, t = "bba" which is anagram of s.
Input: s = "leetcode", t = "practice"
Output: 5
Explanation: Replace 'p', 'r', 'a', 'i' and 'c' from t with proper characters to make t anagram of s.
 */

fun minStepsForAnagram(s: String, t: String): Int {
    val sChars = HashMap<Char, Int>()
    val tChars = HashMap<Char, Int>()

    for (i in s.indices) {
        var sCharCount = sChars.getOrDefault(s[i], 0)
        sChars[s[i]] = ++sCharCount
        var tCharCount = tChars.getOrDefault(t[i], 0)
        tChars[t[i]] = ++tCharCount
    }

    var diffCount = 0
    // t has that char but in diff num
    // t don't have that char
    for ((k, v) in sChars) {
        diffCount += if (tChars.containsKey(k)) {
            val diff = v - tChars[k]!!
            if (diff > 0) diff else 0
        } else {
            v
        }
    }
    return diffCount
}

fun minSteps(s: String, t: String): Int {
    val freqS = CharArray(26)
    val freqT = CharArray(26)
    var ans = 0
    val aInt = 'a'.toInt()
    for (c in s)
        freqS[c - 'a']++

    for (c in t)
        freqT[c - 'a']++

    for (i in 0 until 26) {
        if (freqT[i] < freqS[i])
            ans += freqS[i] - freqT[i]
    }

    return ans
}