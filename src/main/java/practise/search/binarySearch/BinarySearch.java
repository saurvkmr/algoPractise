package practise.search.binarySearch;

public class BinarySearch {

    public static void main(String[] args) {
        int[] nums = {1,2,4,5,6,8,9};
        System.out.println(recursiveSearch(nums, 5, 0, nums.length-1));
    }

    static int recursiveSearch(int[] arr, int numToSearch, int beginIndex, int endIndex) {
        if (endIndex < beginIndex)
            return -1;
        int mid = (beginIndex + endIndex) / 2;
        if (arr[mid] == numToSearch)
            return mid;
        if (arr[mid] > numToSearch)
            return recursiveSearch(arr, numToSearch, beginIndex, mid -1);
        if (arr[mid] < numToSearch)
            return recursiveSearch(arr, numToSearch, mid + 1, endIndex);
        return -1;
    }
}
