package practise.arrays;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/contains-duplicate-ii/
public class ContainsDuplicate {

    public static void main(String[] args) {
        int[] arr = {1,2,3,1};
        System.out.println(containsNearbyDuplicate(arr, 3));
    }

    private static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (seen.containsKey(nums[i]) && i - seen.get(nums[i]) <= k)
                return true;
            seen.put(nums[i], i);
        }
        return false;
    }
}
