package practise.arrays

fun main() {
    findMajorityElement(intArrayOf(1,3,4,5,35,3,3,3))
}

private fun findMajorityElement(nums: IntArray) {
    var majorityElement: Int = 0
    var counter = 0

    for (i in nums) {
        when {
            counter == 0 -> majorityElement = i
            i != majorityElement -> counter--
            else -> counter++
        }
    }
    print(majorityElement)
}