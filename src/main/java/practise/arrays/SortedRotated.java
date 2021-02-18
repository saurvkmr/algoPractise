package practise.arrays;

import java.util.Arrays;

public class SortedRotated {

    public static void main(String[] args) {
        int[] arr = {7, 9, 1, 1, 1, 3};
        System.out.println(isSortedRotated(arr));
    }

    private static boolean isSortedRotated(int[] nums) {
        //int min = Arrays.stream(nums).min();
        int count = 0, len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] > nums[(i + 1) % len])
                count++;
        }

        if (count > 1) return false;
        return true;
    }
}
