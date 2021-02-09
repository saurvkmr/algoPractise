package strings;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import practise.misc.ServeIceCream;

public class TestServeIceCream {

    @Test
    public void testAll() {
        assertAll(
                () -> {
                    int[] money = {5, 5, 5, 10, 20};
                    assertTrue(new ServeIceCream().ableToServe(money));
                },
                () -> {
                    int[] money = {5, 5, 5};
                    assertTrue(new ServeIceCream().ableToServe(money));
                },
                () -> {
                    int[] money = {10, 10};
                    assertFalse(new ServeIceCream().ableToServe(money));
                },
                () -> {
                    int[] money = {20, 10};
                    assertFalse(new ServeIceCream().ableToServe(money));
                },
                () -> {
                    int[] money = {5, 10, 20};
                    assertFalse(new ServeIceCream().ableToServe(money));
                }
        );
    }
}
