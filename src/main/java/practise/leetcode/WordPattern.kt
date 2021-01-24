package practise.leetcode

fun main() {
    print(wordPattern("abba","dog cat cat dog"))
}

fun wordPattern(pattern: String, s: String): Boolean {
    val arr = s.split(" ")
    if (pattern.length != arr.size)
        return false
    val pattStr = HashMap<Char, String>(arr.size)
    val strPatt = HashMap<String, Char>(arr.size)
    for (i in pattern.indices) {
        val c = pattern[i]
        val word = arr[i]
        if (pattStr.containsKey(c)) {
            if (!pattStr[c].equals(word) && strPatt[word] != c)
                return false
        }
        pattStr.putIfAbsent(c, word)
        strPatt.putIfAbsent(word, c)
        if (pattStr.size != strPatt.size)
            return false
    }
    return true
}