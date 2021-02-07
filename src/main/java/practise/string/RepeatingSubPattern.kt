package practise.string

import java.lang.StringBuilder

fun main() {
    println(isRepeatingSubStr("abababab"))
}

private fun stringRotation(s: String) {
    var arr = s.toCharArray()
    var rotationCount = 0
}

private fun isRepeatingSubStr(s: String): Boolean {
    var front = 0
    var pattern = StringBuilder()
    while (front < s.length) {
        pattern.append(s[front])
        if (isValidPattern(pattern.toString(), s))
            return true
        front++
    }
    return false
}

private fun isValidPattern(pattern : String, original: String):Boolean {
    if (original.length == pattern.length || original.length % pattern.length != 0)
        return false
    var arr = original.split(pattern)
    for (i in arr) {
        if (i.isNotBlank())
            return false
    }
    return true
}