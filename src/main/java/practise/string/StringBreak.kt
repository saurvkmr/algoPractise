package practise.string

import java.lang.StringBuilder

fun sliceString(input: String, size: Int) {
    var start = 0
    var end = size
    while(end <= input.length) {
        removeDups(input.substring(start, end))
        start = end
        end += size
    }
}

fun removeDups(slicedStr: String) {
    val uniqueChar = HashSet<Char>()
    var outPut = StringBuilder()
    for (i in slicedStr) {
        if (!uniqueChar.contains(i)) {
            outPut.append(i)
            uniqueChar.add(i)
        }
    }
    println(outPut)
}

fun main() {
    sliceString("AAABCADDE", 3)
}