package practise.misc;

// https://leetcode.com/problems/calculate-money-in-leetcode-bank/
public class MoneyInBank {
    public static void main(String[] args) {
        System.out.println(calculateMoney(20));
        //System.out.println(calculateMoneyBruteForce(8));
    }

    private static int calculateMoney(int n) {
        int weeks = n / 7;
        int extraDays = n % 7;
        int totalMoney = 0;
        int j = 7;
        for (int i = 0; i < weeks; i++) {
            totalMoney += getSum(j) - getSum(i);
            j++;
        }
        int seedMoneyForExtraDays = weeks + 1;
        seedMoneyForExtraDays = (extraDays * seedMoneyForExtraDays) + getSum(extraDays-1);
        return totalMoney + seedMoneyForExtraDays;
    }

    private static int getSum(int i) {
        return ((i * (i + 1)) / 2);
    }
}
