package practise.list;

import java.util.Arrays;
import java.util.List;

public class FindFirst {
    public static void main(String[] args) {
        System.out.println(findNumber(Arrays.asList(1, 2, 3, 4, 5), 5));
    }

    private static String findNumber(List<Integer> arr, int k) {
        // Write your code here
        return arr.parallelStream().filter(i -> i == k).count() > 0 ? "YES" : "NO";

    }
}
