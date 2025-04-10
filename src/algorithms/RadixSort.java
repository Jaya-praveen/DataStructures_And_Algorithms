package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static algorithms.SelectionSort.printArray;

public class RadixSort {

    public static void main(String[] args){
        System.out.println("unsorted Array :");
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(250);
        arr.add(10);
        arr.add(8);
        arr.add(3);
        arr.add(1);
        printArray(arr);
        radixSortMethod(arr);
        System.out.println("sorted array: ");
        printArray(arr);
    }

    private static void radixSortMethod(ArrayList<Integer> arr) {
        int n=arr.size();
        int max =  arr.stream()
                .mapToInt(Integer::intValue) // Convert to IntStream
                .max()
                .getAsInt();
        for(int exp=1;max/exp>0;exp*=10){
            countingSort(arr,n,exp);
        }
    }

    private static void countingSort(ArrayList<Integer> arr, int n, int exp) {

        int count[] = new int[10];
        ArrayList<Integer> output = new ArrayList<>(Collections.nCopies(n, 0));

        for(int i=0;i<n;i++){
            int digit = (arr.get(i)/exp)%10;
            count[digit]++;
        }
        for(int i=1;i<10;i++){
count[i]+=count[i-1];
        }

        for(int i=n-1;i>=0;i--){
            int digit = (arr.get(i)/exp)%10;
            output.set(count[digit]-1,arr.get(i));
            count[digit]--;
        }
        for (int i = 0; i < n; i++) {
            arr.set(i, output.get(i));
        }
    }
}
