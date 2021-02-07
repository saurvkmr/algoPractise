package practise.list;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/group-the-people-given-the-group-size-they-belong-to/
public class DividePeopleInGroups {
    public static void main(String[] args) {
        int[] groupSize = {3, 3, 3, 3, 3, 1, 3};
        groupThePeople(groupSize);
    }

    private static List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> grouped = new ArrayList<>();
        Map<Integer, List<Integer>> groups = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            int size = groupSizes[i];
            List<Integer> group = groups.getOrDefault(size, new ArrayList<>(size));
            group.add(i);
            groups.put(size, group);
            if (group.size() == size) {
                grouped.add(group);
                groups.remove(size, group);
            }
        }
        return grouped;
    }
}
