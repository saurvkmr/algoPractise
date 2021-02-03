package strings;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import practise.string.NextLexicographicalHigher;

public class NextLexicographicalHigherTest {
    @Test
    public void getNextLexicographicalHigherWordTest() {
        NextLexicographicalHigher lexicographicalHigher = new NextLexicographicalHigher();
        assertAll(
                () -> assertEquals("lmon", lexicographicalHigher.getNextLexicographicalHigherWord("lmno")),
                () -> assertEquals("no answer", lexicographicalHigher.getNextLexicographicalHigherWord("dcba")),
                () -> assertEquals("no answer", lexicographicalHigher.getNextLexicographicalHigherWord("dcbb")),
                () -> assertEquals("acbd", lexicographicalHigher.getNextLexicographicalHigherWord("abdc")),
                () -> assertEquals("abdc", lexicographicalHigher.getNextLexicographicalHigherWord("abcd")),
                () -> assertEquals("fedcbabdc", lexicographicalHigher.getNextLexicographicalHigherWord("fedcbabcd"))
        );
    }
}
