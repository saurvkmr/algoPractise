package practise.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/*
Given an array of integers, determine whether the array can be sorted in ascending order using only one of the following operations one time.
    Swap two elements.
    Reverse one sub-segment

    2
    4 2
    yes
    swap 1 2

    3
    3 1 2
    no

 */
public class AlmostSorted {

    public static void main(String[] args) {
        int[] arr = {3,1,2};
        isAlmostSorted(arr);
    }

    private static void isAlmostSorted(int[] arr) {
        if (arr.length == 1) {
            System.out.println("yes");
            return;
        }
        CountDownLatch latch = new CountDownLatch(2);
        List<Integer> swappable = new ArrayList<>(2);
        List<Integer> reversible = new ArrayList<>(2);
        Executor ex = Executors.newFixedThreadPool(2);
        try {
            ex.execute(() -> isSwap(arr, swappable, latch));
            ex.execute(() -> isReversible(arr, reversible, latch));
            latch.await();
            if (swappable.size() == 2) {
                System.out.println("yes");
                System.out.println("swap " + swappable.get(0) + " " + swappable.get(1));
            } else if (reversible.size() == 2) {
                System.out.println("yes");
                System.out.println("reverse " + reversible.get(0) + " " + reversible.get(1));
            } else {
                System.out.println("no");
            }
            System.exit(0);
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }

    // count how times increasing in breaking
    // if only return a new arr with those idx
    private static void isSwap(int[] arr, List<Integer> swappable, CountDownLatch latch) {
        int increasingBreakPointCount = 0;
        if (arr.length == 2 && arr[0] > arr[1]) {
            swappable.add(0);
            swappable.add(1);
        } else {
            for (int i = 0; i < arr.length - 2; i++) {
                if (arr[i] > arr[i + 1]) {
                    if (increasingBreakPointCount < 2) {
                        swappable.add(i);
                    } else {
                        swappable = new ArrayList<>(2);
                        return;
                    }
                }
            }
        }
        latch.countDown();
    }

    // count if there exists a segment where all elements are decreasing
    // outside that segment all elements are increasing
    // segment length more than 2
    private static void isReversible(int[] arr, List<Integer> reversible, CountDownLatch latch) {
        int reverseSegFirstIdx = -1, reverseSegSecIdx = -1;
        for (int i = 0; i < arr.length - 1; i++) {
            if (reverseSegFirstIdx == -1 && arr[i] > arr[i + 1])
                reverseSegFirstIdx = i;
            else if (reverseSegFirstIdx != -1 && reverseSegSecIdx == -1 && arr[i] < arr[i + 1] && arr[reverseSegFirstIdx] < arr[i+1])
                reverseSegSecIdx = i;
            else if (reverseSegFirstIdx != -1 && reverseSegSecIdx != -1 && arr[i] > arr[i + 1]) {
                latch.countDown();
                return;
            }
        }
        if (reverseSegFirstIdx != -1 && reverseSegSecIdx == -1) {
            reversible.add(reverseSegFirstIdx);
            reversible.add(arr.length - 1);
        } else if (reverseSegFirstIdx != -1 && reverseSegSecIdx != -1) {
            reversible.add(reverseSegFirstIdx);
            reversible.add(reverseSegSecIdx);
        }
        int temp;
        while (reverseSegFirstIdx <= reverseSegSecIdx) {
            temp = arr[reverseSegFirstIdx];
            arr[reverseSegFirstIdx] = arr[reverseSegSecIdx];
            arr[reverseSegSecIdx] = temp;
            reverseSegFirstIdx++;
            reverseSegSecIdx--;
        }
        //isReversible(arr, reversible, latch);
        latch.countDown();
    }
}
