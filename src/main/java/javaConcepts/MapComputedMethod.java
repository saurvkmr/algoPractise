package javaConcepts;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MapComputedMethod {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 3, 5, 7, 6, 2, 4, 6, 80};
        testComputeMethod(arr);
    }

    private static void testComputeMethod(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();
        Arrays.stream(arr)
                .forEach(num -> {
                    freq.computeIfAbsent(num, k -> 0);
                    freq.computeIfPresent(num, (k, v) -> v + 1);
                });
        freq.forEach((k, v) -> System.out.println(k + " " + v));
    }


}
