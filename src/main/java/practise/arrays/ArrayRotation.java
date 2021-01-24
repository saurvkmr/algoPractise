package practise.arrays;

public class ArrayRotation {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        rotateArray(arr, 12);
    }

    private static int[] rotateArray(int[] arr, int k) {
        int len = arr.length;
        int[] rotatedArray = new int[len];
        k = k % len;
        for (int i = 0; i< len; i++) {
            int pos = i + k;
            if (pos > len -1 ) {
                pos = pos % len;
            }
            rotatedArray[pos] = arr[i];
        }
        print(rotatedArray);
        return rotatedArray;
    }

    static void print(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
