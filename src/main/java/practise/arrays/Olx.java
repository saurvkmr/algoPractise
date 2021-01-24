package practise.arrays;

import java.util.Arrays;

public class Olx {
    public static void main(String[] args) {
        int[] juice =  {1, 1, 5};
        int[] capacity =  {6, 5, 8};
        System.out.println(solution(juice, capacity));
    }

    public static int solution(int[] juice, int[] capacity) {
        // write your code in Java SE 8
        int[] emptyCapacity = new int[capacity.length];

        for (int i = 0; i < juice.length; i++){
            emptyCapacity[i] = capacity[i] - juice[i];
        }
        int maxCapLeft = 0, alreadyPoured = 0;
        for (int i = 0; i < juice.length; i++){
            if (maxCapLeft < emptyCapacity[i]) {
                maxCapLeft = emptyCapacity[i];
                alreadyPoured = i;
            }
        }
        juice[alreadyPoured] = Integer.MAX_VALUE;
        int mixed = 1, i = 0;
        Arrays.sort(juice);
        while(maxCapLeft > 0 && i < juice.length) {
            if (maxCapLeft >= juice[i]) {
                maxCapLeft -= juice[i];
                mixed++;
            }
            i++;
        }
        return mixed;
    }
}
