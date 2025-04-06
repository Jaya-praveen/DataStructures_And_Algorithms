package algorithms;

import java.util.ArrayList;

public class SelectionSort {


    public static void main(String[] args){
        System.out.println("unsorted Array :");
        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr.add(250);
        arr.add(10);
        arr.add(8);
        arr.add(3);
        arr.add(1);
        printArray(arr);

        //region general_selection_sort
//        selectionSortMethod(arr);
        //endregion

        //region bidirectional_selection_sort
        bidirectSelectionSort(arr);

        System.out.println("sorted Array :");
        printArray(arr);
    }

    private static void bidirectSelectionSort(ArrayList<Integer> arr) {
        int n= arr.size();
        int left=0;
        int right=n-1;
        int minIndex;
        int maxIndex;
        int count=0;
        while(left<right){
            count+=1;
            minIndex=left;
            maxIndex=right;
            for(int i=left;i<=right;i++){
                if (arr.get(i) < arr.get(minIndex)){
                    minIndex=i;
                }
                if (arr.get(i) > arr.get(maxIndex)){
                    maxIndex=i;
                }
            }
            int temp = arr.get(left);
            arr.set(left,arr.get(minIndex)) ;
            arr.set(minIndex,temp);

            if (maxIndex == left){
                maxIndex = minIndex;
            }
             temp = arr.get(right);
            arr.set(right,arr.get(maxIndex)) ;
            arr.set(maxIndex,temp);
            left++;
            right--;
        }

System.out.println("rounds:"+count);

    }

    public static void  selectionSortMethod(ArrayList<Integer> arr){
        int n =arr.size()-1;
        int count=0;
        for(int i=0;i< n; i++)
        {
            count+=1;
            int min_idx = i;
            for( int j = i+1; j <= n; j++) {
                if(arr.get(j) < arr.get(min_idx)) {
                    min_idx = j ;
                }
            }
            if(min_idx!=i) {
                int temp = arr.get(i);
                arr.set(i,arr.get(min_idx)) ;
                arr.set(min_idx,temp);
            }
          }
        System.out.println("rounds:"+count);
      }



    public static <T> void  printArray(ArrayList<T> arr){
        for(T val : arr){
            System.out.print(val+ " ");
        }
        System.out.println();
    }




}
