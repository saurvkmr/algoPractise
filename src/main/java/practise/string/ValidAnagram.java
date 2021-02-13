package practise.string;

import java.util.Map;
import java.util.HashMap;

public class ValidAnagram {
    public static void main(String[] args) {
        System.out.println(isAnagramUsingMap("car", "arc"));
        System.out.println(isAnagramUsingCharArray("car", "arc"));
    }

    private static boolean isAnagramUsingMap(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Integer> chars = new HashMap<>();
        char c;
        int count;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            count = chars.getOrDefault(c, 0);
            chars.put(c, ++count);
        }

        for (int i = 0; i < t.length(); i++) {
            c = t.charAt(i);
            count = chars.getOrDefault(c, 0);
            if (count == 0)
                return false;
            else if (count == 1)
                chars.remove(c);
            else
                chars.put(c, --count);
        }
        return chars.isEmpty();
    }

    // chars will be always small characters
    private static boolean isAnagramUsingCharArray(String s, String t) {
        int[] chars = new int[26];
        int a = 97, count, idx;
        char c;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            idx = c - a;
            count = chars[idx];
            chars[idx] = ++count;
        }

        for (int i = 0; i < t.length(); i++) {
            c = t.charAt(i);
            idx = c - a;
            count = chars[idx];
            chars[idx] = --count;
        }

        for (int i : chars) {
            if (i > 0 || i < 0)
                return false;
        }
        return true;
    }
}
