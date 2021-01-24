package practise.leetcode;

/**
 * You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in adjacent plots.
 * Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n, return if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule.
 * <p>
 * Example 1:
 * Input: flowerbed = [1,0,0,0,1], n = 1
 * Output: true
 * <p>
 * Example 2:
 * Input: flowerbed = [1,0,0,0,1], n = 2
 * Output: false
 */
public class Flowerbed {
    public static void main(String[] args) {
        Flowerbed f = new Flowerbed();
        int[] arr = {0};
        System.out.println(f.canPlaceFlowers(arr, 1));
    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        if (len == 1 && flowerbed[0] == 0)
            return true;
        for (int i = 0; i < len ; i++) {
            if (i == 0 && flowerbed[i] == 0 && flowerbed[i + 1] == 0) {
                flowerbed[i] = 1;
                n--;
            } else if (i == len - 1 && flowerbed[i] == 0 && flowerbed[i - 1] == 0) {
                flowerbed[i] = 1;
                n--;
            } else if (i > 0 && i < len - 1) {
                if (flowerbed[i - 1] == 0 && flowerbed[i] == 0 && flowerbed[i + 1] == 0) {
                    flowerbed[i] = 1;
                    n--;
                }
            }
            if (n == 0) {
                break;
            }
        }
        return n == 0;
    }
}
