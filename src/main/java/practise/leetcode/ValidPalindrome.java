package practise.leetcode;

//Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.
public class ValidPalindrome {
    public static void main(String[] args) {
        ValidPalindrome p = new ValidPalindrome();
        System.out.println(p.validPalindrome("abbac"));
    }

    public boolean validPalindrome(String s) {
        String reversed = reversed(s);
        if (s.equals(reversed))
            return true;
        int start = 0, end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            } else {
                String removeLeft = new StringBuilder(s).replace(start, start + 1, "").toString();
                if (removeLeft.equals(reversed(removeLeft))) {
                    return true;
                }
                String removeRight = null;
                if (end == s.length() - 1) {
                    removeRight = s.substring(0, s.length() - 1);
                } else {
                    removeRight = new StringBuilder(s).replace(end, end + 1, "").toString();
                }
                System.out.println(removeRight);
                if (removeRight.equals(reversed(removeRight))) {
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    private String reversed(String s) {
        return new StringBuilder(s).reverse().toString();
    }
}
