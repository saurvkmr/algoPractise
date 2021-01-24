package practise.arrays;

public class BuySaleStock {
    public static void main(String[] args) {
        int[] arr = {1,4,6,3,7,9,2};
        System.out.println(worst(arr));
        System.out.println(best(arr));
    }

    private static int worst(int[] arr) {
        int i = -1, profit = 0;
        while(i++ < arr.length) {
            int j = i;
            while(j < arr.length) {
                if (arr[j] < arr[i])
                    profit = Math.max(profit, arr[i] - arr[j]);
                j++;
            }
        }
        return profit;
    }

    private static int best(int[] arr) {
        int minPrice = arr[0], maxProfit = 0, profit = 0;
        for(int i = 0; i < arr.length; i++) {
            minPrice = Math.min(minPrice, arr[i]);
            profit = arr[i] - minPrice;
            maxProfit = Math.max(maxProfit, profit);
        }
        return maxProfit;
    }
}
