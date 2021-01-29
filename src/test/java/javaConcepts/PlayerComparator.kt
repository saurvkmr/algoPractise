package javaConcepts

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.function.Executable
import java.util.Collections.sort

class PlayerComparator {
    @Test
    fun testComparator() {
        val player1 = Player(2, "Ronaldo", "Ch")
        val player2= Player(1, "Messi", "Leo")
        val players = mutableListOf(player1, player2)
        sort(players, PlayerRankingComparator())
        assertAll(
            Executable {
                Assertions.assertEquals(players[0],
                    player2)
            },
            Executable {
                Assertions.assertEquals(players[1],
                    player1)
            }
        )
    }
}