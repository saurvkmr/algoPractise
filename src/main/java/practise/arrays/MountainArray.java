package practise.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

public class MountainArray {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        validMountainArray(arr);
    }
    public static boolean validMountainArray(int[] arr) {
        OptionalInt max = Arrays.stream(arr).max();
        if (max.isPresent()) {
            System.out.println(max.getAsInt());
        }
        int len = arr.length;
        if (len < 3)
            return false;
        boolean isIncreasing = false;
        int i = 0;
        for (; i < len - 1; i++) {
            if (arr[i] >= arr[i+1]){
                isIncreasing = false;
                break;
            }
        }
        for(; i < len - 1; i++) {
            if (arr[i] >= arr[i+1])
                return false;
        }
        return true;
    }
}
