package practise.arrays;

public class FlowerBed {
    public static void main(String[] args) {
        int[] flowerBed = {0, 0, 0};
        System.out.println(canPlaceFlowers(flowerBed, 2));
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) return true;
        if (flowerbed.length == 1 && n == 1 && flowerbed[0] == 0)
            return true;

        int canPlace = 0;
        for (int i = 0; i < flowerbed.length; i += 2) {
            if (i == 0) {
                if (flowerbed[i] == 0 && flowerbed[i + 1] == 0) {
                    canPlace++;
                    flowerbed[i] = 1;
                }
            } else if (i == flowerbed.length - 1) {
                if (flowerbed[i] == 0 && flowerbed[i - 1] == 0) {
                    canPlace++;
                    flowerbed[i] = 1;
                }
            } else if (flowerbed[i] == 0 && flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
                canPlace++;
                flowerbed[i] = 1;
            }
        }
        if (canPlace >= n)
            return true;
        canPlace = 0;
        for (int i = 1; i < flowerbed.length; i += 2) {
            if (i == flowerbed.length - 1) {
                if (flowerbed[i] == 0 && flowerbed[i - 1] == 0) {
                    canPlace++;
                    flowerbed[i] = 1;
                }
            } else if (flowerbed[i] == 0 && flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
                canPlace++;
                flowerbed[i] = 1;
            }
        }

        return canPlace >= n;
    }
}
