package practise.arrays

import java.util.*
import kotlin.collections.ArrayList

// https://leetcode.com/problems/last-stone-weight/

fun main() {
    println(lastStoneWeight(intArrayOf(2, 7, 4, 1, 8, 1)))
    println(lastStoneWeightUsingHeap(intArrayOf(2, 7, 4, 1, 8, 1)))
}

private fun lastStoneWeightUsingHeap(stones: IntArray): Int {
    val heap = PriorityQueue<Int>(Collections.reverseOrder())
    stones.map { heap.add(it) }
    var max = 0
    var secMax = 0
    while (heap.size > 1) {
        max = heap.poll()
        secMax = heap.poll()
        if (max - secMax > 0)
            heap.add(max - secMax)
    }
    return if (heap.isEmpty()) 0 else heap.poll()
}

private fun lastStoneWeight(stones: IntArray): Int {
    var list = ArrayList(stones.toList())
    var size = list.size
    var max = 0
    var secMax = 0
    while (size >= 2) {
        max = list.max()!!
        list.remove(max)
        secMax = list.max()!!
        list.remove(secMax)
        if (max - secMax > 0)
            list.add(max - secMax)
        size = list.size
    }
    return if (list.isEmpty()) 0 else list[0]
}