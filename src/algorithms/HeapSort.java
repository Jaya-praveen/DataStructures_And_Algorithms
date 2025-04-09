package algorithms;

import java.util.ArrayList;

import static algorithms.SelectionSort.printArray;

public class HeapSort {




    public static void main(String[] args){
        System.out.println("unsorted Array :");
        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr.add(250);
        arr.add(10);
        arr.add(8);
        arr.add(3);
        arr.add(1);
        printArray(arr);

        //region general_heap_sort
        heapsort(arr);
        //endregion

        //region bidirectional_selection_sort

        System.out.println("sorted Array :");
        printArray(arr);
    }

    private static void heapsort(ArrayList<Integer> arr) {
        int n=arr.size();

        for(int i=n/2-1;i>=0;i--){
            heapify(arr,n,i);
        }
        for(int i=n-1;i>0;i--){
            int temp=arr.get(0);
            arr.set(0,arr.get(i));
            arr.set(i,temp);
            heapify(arr,i,0);
        }

    }

    private static void heapify(ArrayList<Integer> arr, int n, int i) {
        int largest =i;
        int left = 2*i+1;
        int right = 2*i+2;

        if(left<n && arr.get(left)>arr.get(largest)){
            largest = left;
        }
        if(right < n&&arr.get(right)>arr.get(largest)){
            largest = right;
        }
        if(largest!=i){
            int swap = arr.get(i);
            arr.set(i,arr.get(largest));
            arr.set(largest,swap);

            heapify(arr,n,largest);
        }
    }
}
