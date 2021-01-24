package practise.search.binarySearch;

public class BitonicArray {
    public static void main(String[] args) {
        int[] numArray = {10, 20, 30, 40, 50, 5, 4, 2, 1};
        System.out.println(findBitonicElement(numArray, 0, numArray.length-1));
    }

    // Bitonic element is max element of the bitonic array
    static int findBitonicElement(int[] arr, int beginIndex, int endIndex) {
        if (beginIndex <= endIndex) {
            int mid = (beginIndex + endIndex) / 2;
            if (arr[mid - 1] < arr[mid] && arr[mid+1] < arr[mid])
                return mid;
            if (arr[mid] < arr[mid+1])
                return findBitonicElement(arr, mid+1, endIndex);
            return findBitonicElement(arr, beginIndex, mid-1);
        }
        return -1;
    }

}
