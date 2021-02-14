package heap

import java.util.*

fun main() {
    maxHeap(intArrayOf(1, 2, 3, 4, 6, 5, 7, 8, 9))
    minHeap(intArrayOf(1, 2, 3, 4, 6, 5, 7, 8, 9))
}

private fun maxHeap(nums: IntArray) {
    val maxHeap = PriorityQueue<Int>(nums.size, Collections.reverseOrder())
    nums.forEach { maxHeap.offer(it) }
    while (maxHeap.isNotEmpty())
        println(maxHeap.poll())
    //maxHeap.forEach { println(it) }
}

private fun minHeap(nums: IntArray) {
    val maxHeap = PriorityQueue<Int>(nums.size)
    nums.forEach { maxHeap.offer(it) }
    while (maxHeap.isNotEmpty())
        println(maxHeap.poll())
}
