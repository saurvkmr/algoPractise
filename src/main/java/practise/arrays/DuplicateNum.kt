package practise.arrays

fun main() {
    println(duplicateNum(intArrayOf(1,3,4,2,2)))
}

private fun duplicateNum(nums: IntArray):Int {
    val actualSum = nums.sum()
    val len = nums.size
    val expectedSum = (len * (len - 1)) / 2
    return actualSum - expectedSum
}