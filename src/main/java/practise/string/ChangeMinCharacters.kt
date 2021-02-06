package practise.string

// https://leetcode.com/contest/weekly-contest-225/problems/change-minimum-characters-to-satisfy-one-of-three-conditions/

fun main() {
    /*println(countChangesReq("aba", "caa"))
    println(countChangesReq("dabadd", "cda"))
    println(countChangesReq("aaaaa", "bbbb"))*/
    println(countChangesReq("dee", "a"))
}

private fun countChangesReq(a: String, b: String): Int {
    val charCountA = HashMap<Char, Int>()
    val charCountB = HashMap<Char, Int>()
    var count = 0
    for (i in a) {
        count = charCountA.getOrDefault(i, 0)
        charCountA[i] = ++count
    }
    for (i in b) {
        count = charCountB.getOrDefault(i, 0)
        charCountB[i] = ++count
    }
    val oneDistinctLetterChangesCount = countChangesForOneDistinctLetter(charCountA, charCountB, a.length, b.length)
    val costOfIncreasingA = makeIncreasing(charCountA, charCountB, a.length, b.length)
    val costOfIncreasingB = makeIncreasing(charCountB, charCountA, b.length, a.length)
    println(costOfIncreasingA)
    println(costOfIncreasingB)
    println(oneDistinctLetterChangesCount)
    var min = Math.min(costOfIncreasingA, costOfIncreasingB)
    return Math.min(min, oneDistinctLetterChangesCount)
}

private fun countChangesForOneDistinctLetter(
    charCountA: HashMap<Char, Int>,
    charCountB: HashMap<Char, Int>,
    lenA: Int,
    lenB: Int
): Int {
    var maxCount = 0
    var count = 0
    for ((k, v) in charCountA) {
        count = v + charCountB.getOrDefault(k, 0)
        maxCount = Math.max(maxCount, count)
    }
    return lenA + lenB - maxCount
}

private fun makeIncreasing(
    charCount_1: HashMap<Char, Int>,
    charCount_2: HashMap<Char, Int>,
    len_1: Int,
    len_2: Int
): Int {
    var maxInA = 0
    var maxInB = 0
    var minInA = 200
    var minInB = 200
    for ((k, _) in charCount_1) {
        maxInA = Math.max(maxInA, k.toInt())
        minInA = Math.min(minInA, k.toInt())
    }
    for ((k, _) in charCount_2) {
        maxInB = Math.max(maxInB, k.toInt())
        minInB = Math.min(minInB, k.toInt())
    }
    if (maxInA < minInB)
        return 0
    return if (len_2 < len_1) {
        when {
            maxInB > maxInA -> len_2 - charCount_2[maxInB.toChar()]!!
            maxInB < maxInA -> len_2
            else -> len_2 - charCount_2[maxInB.toChar()]!! + len_2 - charCount_2[maxInB.toChar()]!!
        }
    } else {
        when {
            maxInB > maxInA -> len_1 - charCount_2[maxInB.toChar()]!!
            maxInB < maxInA -> len_1
            else -> len_2 - charCount_2[maxInB.toChar()]!! + len_1 - charCount_2[maxInB.toChar()]!!
        }
    }
    return 0
}