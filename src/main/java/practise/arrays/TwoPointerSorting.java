package practise.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TwoPointerSorting {
    public static String arrangeStudents(List<Integer> a, List<Integer> b) {
        // Write your code here
        Collections.sort(a);
        Collections.sort(b);
        List<Integer> combined = new ArrayList<>();
        combined.addAll(a);
        combined.addAll(b);
        Collections.sort(combined);
        boolean aFirst = a.get(0) < b.get(0) ? true : false;
        for (int i = 0, j = 0; i < a.size(); i++, j = j + 2) {
            if (aFirst && (combined.get(j) != a.get(i) || combined.get(j + 1) != b.get(i))) {
                return "NO";
            } else if (!aFirst && (combined.get(j) != b.get(i) || combined.get(j + 1) != a.get(i))) {
                return "NO";
            }
        }

        return "YES";
    }

    public static void main(String[] args) {
        System.out.println(arrangeStudents(Arrays.asList(1, 3), Arrays.asList(2, 4)));
    }
}
