package practise.arrays;

import java.util.HashMap;

public class NumberOfLargestSq {
    public static void main(String[] args) {
        int[][] rectangles = {{5, 8}, {3, 9}, {5, 12}, {16, 5}};
        System.out.println(countGoodRectangles(rectangles));
        /*int[][] rectangles = {{5, 8}, {3, 9}, {3, 12}};
        System.out.println(countGoodRectangles(rectangles));*/
    }

    public static int countGoodRectangles(int[][] rectangles) {
        HashMap<Integer, Integer> squaresCount = new HashMap<>();
        int max = 0;
        for (int[] arr : rectangles) {
            int min = Math.min(arr[0], arr[1]);
            int count = squaresCount.getOrDefault(min, 0);
            squaresCount.put(min, ++count);
            max = Math.max(max, min);
        }
        return squaresCount.get(max);
    }
}
