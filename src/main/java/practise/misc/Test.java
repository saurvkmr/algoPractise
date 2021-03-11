package practise.misc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        /*List<String> names = Arrays.asList("Saurav");
        System.out.println(returnName(names));*/
        mapOps();
    }

    private static String returnName(List<String> names) {
        return names.stream()
                .findFirst()
                .orElse("");
    }

    private static void mapOps() {
        Map<Integer, Integer> freq = new HashMap<>();
        freq.computeIfAbsent(0, k -> 0);
        freq.computeIfAbsent(1, k -> 0);
        freq.computeIfAbsent(2, k -> 0);
        freq.computeIfAbsent(3, k -> 0);
        freq.computeIfAbsent(4, k -> 0);
        freq.forEach((k, v) -> System.out.println(k + " " + v));

        freq.computeIfPresent(0, (k, v) -> v + 1);
        freq.computeIfPresent(0, (k, v) -> v + 1);
        freq.computeIfPresent(1, (k, v) -> v + 1);
        freq.computeIfPresent(2, (k, v) -> v + 1);
        freq.computeIfPresent(3, (k, v) -> v + 1);
        freq.computeIfPresent(4, (k, v) -> v + 1);

        freq.forEach((k, v) -> System.out.println(k + " " + v));

    }
}
