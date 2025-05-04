package algorithms.searchalgo;

public class binarySearch {
    public static void main(String[] args) {
        System.out.println(" Array :");
        int[] arr = {3, 8, 15, 23, 42, 56, 72, 88, 91};
        int n = arr.length;
        //region binarysearchiterative
        System.out.println(binarySearchiterative(arr, n, 3));
        //endregion

        //region bilinearsearch
        System.out.println(binarySearchRecursive(arr,0,n-1,91));
        //endregion
    }

    public static int binarySearchiterative(int[] arr, int n, int target) {

        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                low = mid + 1;

            } else {
                high = mid - 1;
            }
        }
        return -1;

    }

    public static int binarySearchRecursive(int[] arr, int low, int high, int target) {
        if (high >= low) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target)
                return mid;
            if (arr[mid] > target)
                return binarySearchRecursive(arr, low, mid + 1, target);

            return binarySearchRecursive(arr, mid + 1, high, target);



        }
        return -1;

    }
}
