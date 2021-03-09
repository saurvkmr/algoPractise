package practise.leetcode;

import java.util.List;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SelfDividingNum {
    public static void main(String[] args) {
        //System.out.println(selfDividingNumbers(1, 22));
        System.out.println(isSelfDividing(21));
    }

    private static List<Integer> selfDividingNumbers(int left, int right) {
        IntPredicate isSelfDividing = num -> isSelfDividing(num);
        return IntStream.rangeClosed(left, right)
                .filter(isSelfDividing)
                .boxed()
                .collect(Collectors.toList());
    }

    private static boolean isSelfDividing(int n) {
        int rem = 0, num = n;
        while (num > 0) {
            rem = num % 10;
            if (rem == 0 || n % rem != 0)
                return false;
            num = num / 10;
        }
        return true;
    }
}
