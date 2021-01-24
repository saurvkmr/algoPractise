package practise.leetcode;

/**
 * A perfect number is a positive integer that is equal to the sum of its positive divisors, excluding the number itself.
 * A divisor of an integer x is an integer that can divide x evenly.
 * Given an integer n, return true if n is a perfect number, otherwise return false.
 *
 * Input: num = 28
 * Output: true
 * Explanation: 28 = 1 + 2 + 4 + 7 + 14
 * 1, 2, 4, 7, and 14 are all divisors of 28.
 */
public class PrefectNumber {
    public static void main(String[] args) {
        PrefectNumber f = new PrefectNumber();
        System.out.println(f.checkPerfectNumber(28));
    }
    public boolean checkPerfectNumber(int num) {
        int sum = 1, div = 2;
        int half = (num / 2);
        while(div <= half) {
            if (num % div == 0) {
                System.out.println(div);
                sum += div;
            }
            div++;
        }
        return sum == num;
    }
}
