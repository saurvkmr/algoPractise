package practise.arrays;

public class MaxContigiousSum {
    public static void main(String[] args) {
        int[] nums = {1,2,4,5,6,-110,8,9};
        System.out.println(getMaxContigiousSum(nums));
    }

    static int getMaxContigiousSum(int[] nums) {
        int maxSum = 0, sum = 0;
        for(int i = 0; i<nums.length; i++) {
            if (nums[i] < 0)
                maxSum = sum;
            sum += nums[i];
            if (sum < 0)
                sum = 0;
        }
        return sum > maxSum ? sum : maxSum;
    }
}
