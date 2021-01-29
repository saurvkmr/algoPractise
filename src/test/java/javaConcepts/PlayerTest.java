package javaConcepts;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PlayerTest {
    @Test
    public void testPlayer() {
        Player player1 = new Player(2, "Ronaldo", "Ch");
        Player player2 = new Player(1, "Messi", "Leo");

        List<Player> players = Arrays.asList(player1, player2);
        Collections.sort(players);

        assertAll(
                () -> assertEquals( players.get(0), player2),
                () -> assertEquals( players.get(1), player1)
        );

    }
}
