package practise.arrays;

/**
 * Given a non-empty array of integers, return the third maximum number in this array.
 * If it does not exist, return the maximum number. The time complexity must be in O(n).
 *
 * the third maximum here means the third maximum distinct number.
 * Both numbers with value 2 are both considered as second maximum.
 */
public class ThirdMaxElement {
    public static void main(String[] args) {
        int[] arr = {1,2};
        System.out.println(new ThirdMaxElement().getThirdMaxElem(arr));
    }

    int getThirdMaxElem(int[] nums) {
        int max = Integer.MIN_VALUE, secMax = Integer.MIN_VALUE, thrdMax = Integer.MIN_VALUE;
        boolean isThrdMaxUpdated = false;
        for (int i : nums) {
            if (i == max || i == secMax)
                continue;
            if (i >= max) {
                if (max > secMax && secMax > thrdMax) {
                    thrdMax = secMax;
                    isThrdMaxUpdated = true;
                }
                if (max > secMax)
                    secMax = max;
                max = i;
            } else if (i >= secMax) {
                if (i != secMax && secMax > thrdMax) {
                    thrdMax = secMax;
                    isThrdMaxUpdated = true;
                }
                secMax = i;
            } else if (i >= thrdMax && i != secMax && i != max) {
                thrdMax = i;
                isThrdMaxUpdated = true;
            }
        }
        return isThrdMaxUpdated ? thrdMax : max;
    }

}
