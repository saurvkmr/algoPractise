package practise.string

import java.lang.StringBuilder

fun main() {
    println(repeatString("abc", "cabcabca"))
    println(repeatString("a", "aa"))
}

private fun repeatString(a: String, b: String): Int {
    var maxRepeat = if (b.length < a.length) 2 else (b.length / a.length) + 2
    var i = 1
    var sb = StringBuilder()
    while (i <= maxRepeat) {
        sb.append(a)
        if (i < maxRepeat - 2) {
            i++
            continue
        }
        if (sb.contains(b))
            return i
        i++
    }
    return -1


}