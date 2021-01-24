package practise.arrays

fun longestSubStrWithoutRepeatingChar(s: String): Int {
    if (s.isEmpty())
        return 0
    val uniqueChar = HashSet<Char>()
    var front = 1;
    var back = 0;
    var maxLen = 1
    uniqueChar.add(s[back])
    while (front < s.length) {
        if (!uniqueChar.contains(s[front])) {
            uniqueChar.add(s[front])
            front++
            maxLen = Math.max(maxLen, front - back)
        } else if (back != front && s[back] != s[front]) {
            uniqueChar.remove(s[back])
            back++
        } else {
            front++
            back++
        }
    }
    return maxLen
}

fun main() {
    println(longestSubStrWithoutRepeatingChar("abcabcbb"))
    println(longestSubStrWithoutRepeatingChar("bbb"))
    println(longestSubStrWithoutRepeatingChar("example"))
    println(longestSubStrWithoutRepeatingChar("pwwkew"))
    println(longestSubStrWithoutRepeatingChar(""))
    println(longestSubStrWithoutRepeatingChar("au"))
}