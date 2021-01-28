package practise.string;

public class StringToInteger {
    public static void main(String[] args) {
        stringToInt("-123");
    }

    private static void stringToInt(String s) {
        char[] arr = s.toCharArray();
        int num = 0, pow = arr.length-1;
        boolean isNeg = false;
        for (char c : arr) {
            if (c == 45) {
                isNeg = true;
                pow--;
                continue;
            } else if (c >= 48 && c <= 57) {
                num += Math.pow(10, pow) * (c - 48);
                pow--;
            } else {
                System.out.println("Not a number");
                return;
            }
        }
        num = isNeg ? num * -1 : num;
        System.out.println(num);
    }
}
