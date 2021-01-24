package practise.string;

/**
 * if by swapping two characters one string converts to another string then they are called buddy string
 * - abc , cba - true
 * - abc , cab - false
 */
public class FindBuddyString {
    public static void main(String[] args) {
        String a = "abc";
        String b = "bca";
        System.out.println(isBuddy(a, b));
    }

    static boolean isBuddy(String a, String b) {
        int count = 0;
        if (a.length() != b.length())
            return false;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                count++;
                /*if (count > 2)
                    return false;*/
            }
        }
        return count == 2;
    }

}
