package heap

import java.util.*

fun main() {
    println(findKthLargest(intArrayOf(2, 5, 6, 8, 3, 4, 9, 10), 4))
}

private fun findKthLargest(nums: IntArray, k: Int): Int {
    val q = PriorityQueue<Int>(nums.size, Collections.reverseOrder())
    nums.forEach { q.add(it) }
    q.forEachIndexed { index, i -> if (index == k - 1) return i }
    return 0
}