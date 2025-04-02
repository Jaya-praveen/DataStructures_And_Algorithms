package algorithms;

public class QuickSort {


    public static void main(String[] args){
        int[] array = {10, 7, 8, 9, 1, 5};
        int n = array.length;
        System.out.println("unsorted array: ");
        printarray(array);
        quicksortmethod(array,0,n-1);
        System.out.println("sorted array: ");
        printarray(array);
    }

    public static void quicksortmethod(int[] array,int low,int high){
       if( low < high ) {
            int pivotIndex = partition(array, low, high);
            quicksortmethod(array, low, pivotIndex - 1);
            quicksortmethod(array, pivotIndex + 1, high);
        };

    }
    public static int partition(int[] array,int low,int high){
        int i=low-1,pivot = array[high];
        for(int j = low;j < high;j++) {
            if(array[j] <= pivot) {
                i++;
                int temp = array[i];
                array[i]=array[j];
                array[j]=temp;
            }
        }

        int temp = array[i+1];
        array[i+1] = array [high];
        array[high] = temp;

        return i+1;
    }

    public static void printarray(int[] array) {
        for(int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
