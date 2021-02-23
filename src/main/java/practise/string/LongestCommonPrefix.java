package practise.string;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        //String[] strs = {"flower", "flow", "flight"};
        String[] strs = {"a"};
        System.out.println(longestCommonPrefix(strs));
    }

    private static String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder("");
        int idx = 0, elementCount = 0;
        boolean exhausted = false;
        while (strs.length > 0) {
            if (strs[elementCount].length() <= idx )
                break;
            char c = strs[elementCount].charAt(idx);
            while (elementCount < strs.length) {
                if (idx > strs[elementCount].length()
                        || c != strs[elementCount].charAt(idx)) {
                    exhausted = true;
                    break;
                }
                elementCount++;
            }
            if (exhausted || idx == strs.length)
                break;
            idx++;
            sb.append(c);
            elementCount = 0;
        }
        return sb.toString();
    }
}
