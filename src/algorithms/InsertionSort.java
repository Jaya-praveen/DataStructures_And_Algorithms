package algorithms;

import java.util.ArrayList;

import static algorithms.SelectionSort.printArray;

public class InsertionSort {

    public static void main(String[] args){
        System.out.println("unsorted Array :");
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(250);
        arr.add(10);
        arr.add(8);
        arr.add(3);
        arr.add(1);
        printArray(arr);

        //region general_Insertion_sort
//        System.out.println("using general_Insertion_sort");
//         insertionSort(arr);
        //endregion

        //region binary_insertion_sort
        System.out.println("using binary_insertion_sort");

        binaryInsertion(arr);
        //endregion

        //region shell_insertion_sort
//        System.out.println("using shell_insertion_sort");

//        shellsort(arr);
        //endregion


        System.out.println("sorted Array :");
        printArray(arr);
    }

    private static void shellsort(ArrayList<Integer> arr) {
        int n= arr.size();
        int pass=0;
        for(int gap=n/2;gap>0;gap/=2){
            pass+=1;
            for(int i=gap;i<n;i++){
                int key = arr.get(i);
                int j=i;
                while(j>=gap && arr.get(j-gap) > key){
                    arr.set(j,arr.get(j-gap));
                    j-=gap;
                }
                arr.set(j,key);
            }
        }
            System.out.println("passes"+pass);

    }

    private static void binaryInsertion(ArrayList<Integer> arr) {
        int n = arr.size();
        int pass=0;
        for(int i=0;i<n;i++){
            pass+=1;
            int key = arr.get(i);
            int low = 0;
            int high = i-1;
            ;
            while(low<=high) {
                int mid = low + (high - low) / 2;
                if (arr.get(mid) > key) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

                int j = i;
                while(j > low) {
                    arr.set(j,arr.get(j-1));
                    j--;
                }
                arr.set(low,key);
        }
        System.out.println("passes"+pass);
    }

    private static void insertionSort(ArrayList<Integer> arr) {
        int n =arr.size();
        int pass=0;
        for(int i=1;i<n;i++){
            pass+=0;
            int key = arr.get(i);
            int j=i-1;
            while(j>=0 && arr.get(j) > key){
                arr.set(j+1,arr.get(j));
                j--;
            }
            arr.set(j+1,key);

        }
        System.out.println("passes"+pass);
    }


}
