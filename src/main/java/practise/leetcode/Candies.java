package practise.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Candies {
    public static void main(String[] args) {
        System.out.println(1.0/0.0);
    }
    public int distributeCandies(int[] candyType) {
        Set<Integer> candies = new HashSet<>();
        Arrays.stream(candyType).forEach(c -> candies.add(c));
        int allowedCount = candyType.length / 2;
        return candies.size() > allowedCount ? allowedCount : candies.size();
    }
}
