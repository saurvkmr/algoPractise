package practise.arrays;

public class ValidMountain {
    public boolean validMountainArray(int[] arr) {
        int flip = 0, increasingCount = 0, decreasingCount = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i]== arr[i + 1] || flip != 0 && arr[i] < arr[i + 1])
                return false;
            if (flip == 0 && arr[i] < arr[i + 1])
                increasingCount++;
            if (flip == 0 && arr[i] > arr[i + 1]) {
                flip++;
                decreasingCount++;
            }
        }
        if (flip == 0 || increasingCount == 0 || decreasingCount == 0)
            return false;
        return flip == 1;
    }
}
