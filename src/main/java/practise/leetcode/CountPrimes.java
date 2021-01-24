package practise.leetcode;

public class CountPrimes {
    public static void main(String[] args) {
        System.out.println(new CountPrimes().countPrimes(110));
    }
    public int countPrimes(int n) {
        int i = 2, count = 0;
        while (i<=n) {
            if (isPrime(i)) {
                count++;
            }
            i++;
        }
        return count;
    }

    boolean isPrime(int n) {
        int root = (int)Math.round(Math.sqrt(n));
        for (int i = 2; i <= root; i++) {
            if (n%i == 0)
                return false;
        }
        return true;
    }
}
