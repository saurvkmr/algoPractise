package practise.string;

public class StringContains {
    public static void main(String[] args) {
        System.out.println(stringContains("a", ""));
    }

    private static int stringContains(String haystack, String needle) {
        int len = needle.length();
        if (haystack.equals(needle) || len == 0)
            return 0;


        for (int i = 0; i < haystack.length(); ) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                if (compare(haystack, needle, i))
                    return i;
            } else
                i = i + len;
        }

        return -1;
    }

    private static boolean compare(String haystack, String needle, int idx) {
        int i = 0;
        while (idx < idx + needle.length() && idx < haystack.length() && i < needle.length()) {
            if (haystack.charAt(idx) != needle.charAt(i))
                return false;
            idx++;
            i++;
        }
        return true;
    }
}
