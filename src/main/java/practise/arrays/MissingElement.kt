package practise.arrays

// https://leetcode.com/problems/set-mismatch/

fun main() {
    var res = findMissing(intArrayOf(1,2,3,5,5))
    println("${res[0]} ${res[1]}")
}

private fun findMissing(arr: IntArray): IntArray {
    val missingDup = IntArray(2)
    val elem = IntArray(arr.size + 1)
    for (i in arr) {
        elem[i] += 1
    }
    for (i in 1 until elem.size) {
        if (elem[i] == 2)
            missingDup[0] = i
        else if (elem[i] == 0)
            missingDup[1] = i
        if (missingDup[0] != 0 && missingDup[1] != 0)
            break
    }
    return missingDup
}