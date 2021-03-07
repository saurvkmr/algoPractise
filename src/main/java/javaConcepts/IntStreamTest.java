package javaConcepts;

import java.util.Optional;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class IntStreamTest {
    public static void main(String[] args) {
        System.out.println(IntStream.of(10, 20, 30, 40).sum());
        System.out.println(IntStream.rangeClosed(0, 100).sum());
        System.out.println(IntStream.iterate(0, i -> i + 5).limit(100).sum());
        IntPredicate isEven = e -> e % 2 == 0;
        System.out.println(IntStream.rangeClosed(0, 100).noneMatch(isEven));
    }
}
