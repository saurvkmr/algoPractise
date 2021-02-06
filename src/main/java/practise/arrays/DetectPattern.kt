package practise.arrays

// https://leetcode.com/problems/detect-pattern-of-length-m-repeated-k-or-more-times/
fun main() {
    println(containsPattern(intArrayOf(1, 2, 1, 2, 1, 1, 1, 3), 2, 2))
    println(containsPattern(intArrayOf(1, 2, 1, 2, 1, 3), 2, 3))
    println(containsPattern(intArrayOf(1, 2, 3, 1, 2), 2, 2))
    println(containsPattern(intArrayOf(2, 2), 1, 2)) // 2,2,1,2,2,1,1,1,2,1
    println(containsPattern(intArrayOf(2, 2, 1, 2, 2, 1, 1, 1, 2, 1), 2, 2))
}

private fun containsPattern(arr: IntArray, m: Int, k: Int): Boolean {
    var count = 0
    var i = 0
    var j = i + m
    while (j < arr.size) {
        if (arr[i] !== arr[j])
            count = 0
        else if (++count == (k - 1) * m)
            return true
        i++
        j++
    }
    return false
}