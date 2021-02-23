package practise.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/587/week-4-february-22nd-february-28th/3650/
public class FindElementInSortedMatrix {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        //int[][] arr = {{1,1}};
        int find = 20;
        System.out.println(findElementUsingBinarySearch(arr, find));
    }

    // as row and column are sorted,
    // target out possible columns in which the element can be present
    // by looking column first and colum last
    // once we get possible columns do binary search on them
    private static boolean isElementPresent(int[][] matrix, int target) {
        int width = matrix.length, len = matrix[0].length;
        List<Integer> possibleCols = new ArrayList<>(len);
        for (int j = 0; j < width; j++) {
            if (target >= matrix[0][j] && target <= matrix[len - 1][j])
                possibleCols.add(j);
        }
        for (Integer j : possibleCols) {
            for (int i = 0; i < len; i++) {
                if (target == matrix[i][j]) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean findElementUsingBinarySearch(int[][] matrix, int target) {
        int width = matrix.length, len = matrix[0].length;
        for (int[] i : matrix) {
            if (binarySearch(i, 0, len-1, target))
                return true;
        }
        return false;
    }

    private static boolean binarySearch(int[] arr, int start, int end, int target) {
        int mid = 0;
        while (start <= end) {
            mid = start + ( end - start ) / 2;
            if (arr[mid] > target)
                end = mid - 1;
            else if (arr[mid] < target)
                start = mid + 1;
            else
                return true;
        }
        return false;
    }
}
