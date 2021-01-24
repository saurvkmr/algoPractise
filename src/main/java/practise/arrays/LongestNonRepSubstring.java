package practise.arrays;

import java.util.HashSet;
import java.util.Set;

public class LongestNonRepSubstring {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
    public static int lengthOfLongestSubstring(String s) {
        int front = 0, back = 0, maxLen = 0, len = s.length();
        int i = 0;
        Set<Character> c = new HashSet<>();
        while(i < len) {
            while(front < len && !c.contains(s.charAt(i))) {
                front++;
                c.add(s.charAt(i));
                i++;
                if (maxLen < (front-back)) {
                    maxLen = (front-back);
                }
            }
            c.remove(s.charAt(back++));
            c.add(s.charAt(front++));
            i++;
        }
        return maxLen;

    }
}
