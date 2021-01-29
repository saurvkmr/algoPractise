package practise.arrays

import java.util.*

/*
Given a array of integers find the index which  partitions the array to two with high numbers and low numbers.
For example [5, -1, 3, 8,6] the index 3 will partition the array to [5,-1,3] and [8,6]
all the numbers in the second partition are greater than first. The solution has to work in O(n).
 */

// if maxIdx < minIdx - so such point

fun partition(arr: IntArray) {
    var min = Int.MAX_VALUE;
    var max = Int.MIN_VALUE;
    var minIdx = 0;
    var maxIdx = 0
    for (i in arr.indices) {
        when {
            arr[i] < min -> {
                min = arr[i]
                minIdx = i
            }
            arr[i] > max -> {
                max = arr[i]
                maxIdx = i
            }
        }
    }
    println("$min $minIdx $max $maxIdx")
    if (minIdx > maxIdx) {
        println("Partition not possible")
        return
    }
    // find max_num_left_to_min the min
    // after which from left iterate and check first idx where arr[idx] < max_num_left_to_min
    var maxNumLeftToMin = min
    for (i in 0..minIdx) {
        maxNumLeftToMin = Math.max(maxNumLeftToMin, arr[i])
    }
    //println("maxNumLeftToMin is $maxNumLeftToMin")
    var partitionIdx = -1
    for (i in arr.size - 1 downTo 0) {
        if (arr[i] <= maxNumLeftToMin) {
            partitionIdx = i
            break
        }
    }
    if (partitionIdx > maxIdx) {
        println("Partition not possible")
        return
    }
    println("partition idx is $partitionIdx")
    println("first arr: ${arrayOf(arr.copyOfRange(0, partitionIdx+1)).contentDeepToString()}" +
            " second arr ${arrayOf(arr.copyOfRange(partitionIdx+1, arr.size)).contentDeepToString()}")
}

fun main() {
    partition(intArrayOf(5, -1, 3, 8, 6, 2))
}