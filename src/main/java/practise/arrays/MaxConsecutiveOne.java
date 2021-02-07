package practise.arrays;

public class MaxConsecutiveOne {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int k = 2;
        /*int[] arr = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int k = 3;*/
        System.out.println(maxConsecutiveOne(arr, k));
    }

    private static int maxConsecutiveOne(int[] A, int K) {
        int maxOnes = 0, count = 0, back = 0, front = 0, currZeroCount = 0;
        while (front != A.length) {
            if (currZeroCount < K || A[front] == 1) {
                if (A[front] == 0) {
                    currZeroCount++;
                }
                count++;
                front++;
            } else {
                maxOnes = Math.max(maxOnes, count);
                if (A[back] == 0)
                    currZeroCount--;
                back++;
                count--;
            }
        }
        return Math.max(maxOnes, count);
    }

    public int longestOnes(int[] A, int K) {
        int left = 0;

        for (int right = 0; right < A.length; right++) {
            K -= 1 - A[right];
            if (K < 0) {
                K += 1 - A[left++];
            }
        }

        return A.length - left;
    }
}
