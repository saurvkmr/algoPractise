package heap;

import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class FrequencySort {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 5, 7, 9, 6, 8, 5, 3, 5, 21, 3, 5, 6, 3, 4, 5, 6, 7, 9, 6, 4};
        freqSort(nums);
    }

    public static void freqSort(int[] nums) {
        Queue<NumberFrequency> maxHeap = new PriorityQueue<>(nums.length, Collections.reverseOrder());
        Map<Integer, Integer> freqs = new HashMap<>();
        int freq;
        for (int num : nums) {
            freq = freqs.getOrDefault(num, 0);
            freqs.put(num, ++freq);
        }

        for (Map.Entry<Integer, Integer> entry : freqs.entrySet()) {
            NumberFrequency nf = new NumberFrequency(entry.getKey(), entry.getValue());
            maxHeap.offer(nf);
        }

        while (!maxHeap.isEmpty()) {
            NumberFrequency numberFrequency = maxHeap.poll();
            System.out.println("number " + numberFrequency.getNumber() + " with frequency " + numberFrequency.getOccurrence());
        }
    }

    private static class NumberFrequency implements Comparable<NumberFrequency> {
        private int number;
        private int occurrence;

        public NumberFrequency(int otherNumber, int otherOccurrence) {
            this.number = otherNumber;
            this.occurrence = otherOccurrence;
        }

        public int getOccurrence() {
            return occurrence;
        }

        public int getNumber() {
            return number;
        }

        @Override
        public int compareTo(@NotNull NumberFrequency numberFrequency) {
            return Integer.compare(this.occurrence, numberFrequency.occurrence);
        }
    }
}
