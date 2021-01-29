package practise.string

// aaabbbcccdddddeeeeef -> a3b3c3d4e5f1

fun main() {
    println("aaabbbcccdddddeeeeef".runLengthEncoding())
}

inline fun String.runLengthEncoding():String {
    val output = StringBuilder()
    var count = 0
    var c: Char = this[0]
    for (i in this) {
        if (i == c) {
            count++
        } else {
            output.append("$c$count")
            c = i
            count = 1
        }
    }
    if (count > 0) {
        output.append("$c$count")
    }
    return output.toString()
}