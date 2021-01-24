package practise.leetcode;

public class PalindromeStr {
    public static void main(String[] args) {
        PalindromeStr p = new PalindromeStr();
        System.out.println(p.isPalindrome("0P"));
    }
    public boolean isPalindrome(String s) {
        int start = 0, end = s.length() -1 ;
        s = s.toLowerCase();
        while (start < end) {
            if (!Character.isLetterOrDigit(s.charAt(start)))
                start++;
            else if (!Character.isLetterOrDigit(s.charAt(end)))
                 end--;
            else if (s.charAt(start) != s.charAt(end))
                return false;
            else {
                start++;
                end--;
            }
        }
        return true;
    }
}
