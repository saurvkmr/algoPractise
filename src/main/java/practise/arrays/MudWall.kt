package practise.arrays

import kotlin.math.max
import kotlin.math.min

fun maxHeight(wallPositions: Array<Int>, wallHeights: Array<Int>): Int {
    // Write your code here
    var lastWall = wallPositions[wallPositions.size - 1]
    val allWalls = Array<Int>(lastWall, {0})
    val heights = Array<Int>(lastWall, {0})

    for (i in wallPositions.indices) {
        allWalls[wallPositions[i]-1] = wallPositions[i]
        heights[wallPositions[i]-1] = wallHeights[i]
    }

    var maxHeight = 0
    var i = 0
    while (i < allWalls.size) {
        if (allWalls[i] == 0 && i != 0) {
            var start = i
            val end = nextWallAt(allWalls, start)
            while(start < end) {
                var wallHeight = 0
                if (end - start == 1) {
                    wallHeight = min(heights[start - 1], heights[start + 1]) + 1
                } else {
                    if (heights[start - 1] != 0)
                        wallHeight = heights[start - 1] + 1
                }
                heights[start] = wallHeight
                start++
            }
            i = start
            continue
        }
        i++
    }
    var j = heights.size - 1
    while(j > 1)  {
        if (Math.abs(heights[j] - heights[j - 1]) > 1) {
            heights[j-1] = min(heights[j], heights[j - 1]) + 1
        }
        j--
    }

    println()
    for (i in heights) {
        print(" $i")
    }

    for (i in heights) {
        maxHeight = max(maxHeight, i)
    }
    return maxHeight
}

fun nextWallAt(wallPositions: Array<Int>, start: Int): Int {
    var end = 0
    for (i in start until wallPositions.size) {
        if (wallPositions[i] != 0) {
            end = i
            break
        }
    }
    return end
}

// [1, 3, 7]
// [4, 3, 3]
fun main() {
    val wallPositions = Array<Int>(6, {0})
    val wallHeights = Array<Int>(6, {0})

    wallPositions[0] = 7
    wallPositions[1] = 12
    wallPositions[2] = 16
    wallPositions[3] = 22
    wallPositions[4] = 26
    wallPositions[5] = 29

    wallHeights[0] = 8
    wallHeights[1] = 8
    wallHeights[2] = 9
    wallHeights[3] = 8
    wallHeights[4] = 8
    wallHeights[5] = 11

    println(maxHeight(wallPositions, wallHeights))
}