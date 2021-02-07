package practise.misc

// https://leetcode.com/problems/moving-stones-until-consecutive/

fun main() {
    val arr = movingStores(7,4,1)
    print("${arr[0]} ${arr[1]}")
}

// stones are consecutive if diff between max and min is 2
private fun movingStores(a: Int, b: Int, c: Int): IntArray {
    val res = IntArray(2)
    val l = if (a > b) if (b > c) c else b else if (a > c) c else a // min
    val h = if (a < b) if (b < c) c else b else if (a < c) c else a // max
    val m = if (a !== l && a !== h) a else if (b !== l && b !== h) b else c // mid
    if (h - l != 2) {
        val startDifference = m - l - 1
        val endDifference = h - m - 1
        res[0] = if (startDifference <= 1 || endDifference <= 1) 1 else 2
        res[1] = h - l - 2
    }
    return res
}
