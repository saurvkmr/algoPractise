package practise.arrays;

public class LongestContinious {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        System.out.println(len(arr));
    }

    private static int len(int[] arr) {
        if (arr.length == 0)
            return 0;
        int front = 1, back = 0, maxLen = 0, temp = arr[0];
        while (front < arr.length) {
            if (arr[front] > temp) {
                temp = arr[front];
                front++;
                maxLen = Math.max(maxLen, front - back);
            } else {
                temp = arr[front];
                back = front;
                front++;
            }

        }
        return maxLen;
    }
}
