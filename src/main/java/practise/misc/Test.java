package practise.misc;

import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Saurav");
        System.out.println(returnName(names));
    }

    private static String returnName(List<String> names) {
        return names.stream()
                .findFirst()
                .orElse("");
    }
}
