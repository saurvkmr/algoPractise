package practise.arrays

import java.lang.StringBuilder
import kotlin.math.abs
import kotlin.streams.asSequence

fun main() {
    println(countValleys("UDDDUDUU"))
    println(countValleys(generateHike()))
    println(countValleys(generateHike()))
    println(countValleys(generateHike()))
    println(countValleys(generateHike()))
}

private fun countValleys(hike: String): Int {
    var altitude = 0
    var prevAltitude = 0
    var valleyCount = 0
    for (i in hike) {
        prevAltitude = altitude
        when (i) {
            'U' -> altitude++
            'D' -> altitude--
        }
        if (prevAltitude == 0 && altitude < 0) {
            valleyCount++
        }
    }
    return valleyCount
}

private fun generateHike(): String {
    val source = "DU"
    var hike = java.util.Random().ints(20, 0, source.length)
        .asSequence()
        .map(source::get)
        .joinToString("")
    var countU = 0
    var countD = 0
    for (i in hike) {
        when (i) {
            'U' -> countU++
            'D' -> countD++
        }
    }
    val sb = StringBuilder(hike)
    val charToAdd = if (countD - countU > 0) 'U' else 'D'

    repeat((1..abs(countD - countU)).count()) {
        sb.append(charToAdd)
    }
    return sb.toString()
}