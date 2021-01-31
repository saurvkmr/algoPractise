package strings

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import practise.string.minSteps
import practise.string.minStepsForAnagram

class MinStepsAnagramTest {
    @Test
    fun minStepsForAnagramTest() {
        assertEquals(0, minStepsForAnagram("xxyyzz", "xxyyzz"))
        assertEquals(4, minStepsForAnagram("friend", "family"))
        assertEquals(1, minStepsForAnagram("aba", "bab"))
        assertEquals(0, minStepsForAnagram("anagram", "mangaar"))
        /*assertEquals(minStepsForAnagram("xxyyzz", "xxyyzz"), 0)
        assertEquals(minStepsForAnagram("xxyyzz", "xxyyzz"), 0)*/
    }

    @Test
    fun minStepsTest() {
        assertEquals(0, minSteps("xxyyzz", "xxyyzz"))
        assertEquals(4, minSteps("friend", "family"))
        assertEquals(1, minSteps("aba", "bab"))
        assertEquals(0, minSteps("anagram", "mangaar"))
        /*assertEquals(minStepsForAnagram("xxyyzz", "xxyyzz"), 0)
        assertEquals(minStepsForAnagram("xxyyzz", "xxyyzz"), 0)*/
    }
}