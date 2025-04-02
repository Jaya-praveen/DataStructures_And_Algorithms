package algorithms;

public class BubbleSort {
    public static void main(String[] args){
        System.out.println("unsorted Array :");
        int[] arr = {10,7, 8, 1,9, 5};
        printArray(arr);
        int n = arr.length;
        //region genral_bubblesort
//        bubbleSortMethod(arr,n);
        //endregion


        //region bubblesort_using_recursion
    //    int[] result=recBubbleSort(arr,n,n-1);
        //endregion


        //region bubble_sort_using_birection
        bidirecBubbleSort(arr,n);
        //endregion


        System.out.println("sorted Array :");
        printArray(arr);
    }

    private static void bidirecBubbleSort(int[] arr, int n) {
        boolean swapped;
        int count=0;
        int start=0;
        int end=n-1;
        do  {
             swapped = false;
            count+=1;
            for (int j = start; j <end; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped)
                break;
            end--;
            swapped = false;
            for (int j = end; j > start; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    swapped = true;
                }
            }
            start++;

        }while (swapped);
        System.out.println(count);
    }
    public static void  printArray(int[] arr){
        for(int val : arr){
            System.out.print(val+ " ");
        }
        System.out.println();
    }

    public static int[] recBubbleSort(int[] arr,int n,int lastswap) {
        System.out.println("pass+1");
        boolean swapped = false;
        int newswap=0;
        if (lastswap <= 0) {
            return arr;
        }
        for (int j = 0; j < lastswap; j++) {
            if (arr[j] > arr[j + 1]) {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
                swapped = true;
                newswap = j;
            }
        }
            if (!swapped) {
                return arr;
            }
        return recBubbleSort(arr,n,newswap);
    }

    public static void bubbleSortMethod(int[] arr, int n){

        boolean swapped;
        for(int i=0; i < n-1; i++){
            swapped = false;
            for(int j=0; j < n - i-1;j++ ){
                if(arr[j] > arr[j+1]){
                   int  temp =arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped = true;
                }
            }
            if(!swapped)
                break;
        }
    }
}
