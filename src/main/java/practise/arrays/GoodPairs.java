package practise.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * A pair (i,j) is called good if nums[i] == nums[j] and i < j.
 * <p>
 * Return the number of good pairs.
 * Input: nums = [1,2,3,1,1,3]
 * Output: 4
 * Explanation: There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed.
 * Input: nums = [1,1,1,1]
 * Output: 6
 * Explanation: Each pair in the array are good.
 */
public class GoodPairs {

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 2};
        System.out.println(countGoodPairs(arr));
    }

    static int countGoodPairs(int[] arr) {
        int pairs = 0;
        Map<Integer, Integer> count = new HashMap<>();
        Arrays.stream(arr)
                .forEach(e -> {
                    count.computeIfAbsent(e, k -> 0);
                    count.computeIfPresent(e, (k, v) -> v + 1);
                });
        for (Map.Entry entry : count.entrySet()) {
            int val = (Integer) entry.getValue();
            pairs += (val * (val - 1)) / 2;
        }
        return pairs;
    }
}
