package practise.string

import java.lang.StringBuilder
import java.util.*
import java.util.stream.Collectors

fun main() {
    println(simplifyPath("/home//foo/"))
}

private fun simplifyPath(path: String): String {
    val split = path.split("/")
    val canonicalPath = StringBuilder("/")
    val q = ArrayDeque<String>()
    for (i in split) {
        if (i == "" || i == ".")
            continue
        if (i == ".." && q.isNotEmpty())
            q.removeLast()
        else if (i != "..")
            q.add(i)
    }
    canonicalPath.append(q.stream().collect(Collectors.joining("/")))
    return canonicalPath.toString()
}