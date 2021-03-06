package javaConcepts;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public class PartitionOddEven {
    public static void main(String[] args) {
        List<Integer> nums = getNums(50, 1000);
        //System.out.println(nums);
        createPartition(nums);
    }

    private static void createPartition(final List<Integer> nums) {
        Map<Boolean, List<Integer>> collect = nums.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println(collect.get(Boolean.TRUE));
        System.out.println(collect.get(Boolean.FALSE));

        Map<Boolean, Double> collect2 = nums.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0,
                        Collectors.averagingInt(Integer::intValue)));
        System.out.println(collect2.get(Boolean.TRUE));
        System.out.println(collect2.get(Boolean.FALSE));
    }

    private static List<Integer> getNums(int size, int limit) {
        return new Random().ints(0, limit)
                .limit(size)
                .boxed()
                .collect(Collectors.toList());
    }
}
