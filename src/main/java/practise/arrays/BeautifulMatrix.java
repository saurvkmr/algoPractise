package practise.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// matrix is beautiful if sum of each rows and columns are equal
public class BeautifulMatrix {

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 2, 3}, {3, 2, 1}};
        System.out.println(isBeautiful(matrix));
    }

    private static boolean isBeautiful(int[][] matrix) {
        int rowSum, colSum;
        Set<Integer> sums = new HashSet<>(matrix[0].length);
        Arrays.stream(matrix)
                .forEach(row ->
                        sums.add(Arrays.stream(row).sum()));
        return sums.size() == 1;
    }
}
