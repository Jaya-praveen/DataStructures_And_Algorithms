package algorithms.searchalgo;

public class ternarySearch {
    public static void main(String[] args){
        System.out.println(" Array :");
        int[] arr = {3, 8, 15, 23, 42, 56, 72, 88, 91};
        int n = arr.length;
        //region ternarysearch
        System.out.println(ternarySearch(arr,n,91));
        //endregion

    }

    public static int ternarySearch(int[] arr,int n,int target){
        int low=0,high=n-1;

        while(low<=high){
            int mid1=low+(high-low)/3;
            int mid2=high-(high-low)/3;

            if(arr[mid1]==target)
                return mid1;
            if(arr[mid2]==target)
                return mid2;
            if(target<arr[mid1])
                high =mid1-1;
            else if(target>arr[mid2])
                low=mid2+1;
            else {
                low=mid1+1;
                high=mid2-1;
            }
        }
        return -1;

    }
}
