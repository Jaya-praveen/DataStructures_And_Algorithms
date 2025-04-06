package algorithms;

public class MergeSort {

    public static void main(String[] args){
        int[] arr = { 10, 7, 8, 1, 9, 5 };
        int n=arr.length;
        System.out.println("Given array is");
        printArray(arr);

//        region mergessort
//        sort(arr, 0, arr.length - 1);
//        endregion

//        region inplacemergesort
        inplacemergesort(arr,0,n-1);
//        endregion




        System.out.println("\nSorted array is");
        printArray(arr);


    }
    public static void  printArray(int[] arr){
        for(int val : arr){
            System.out.print(val+ " ");
        }
        System.out.println();
    }
    public static void merge(int[] arr, int l , int m, int r){
        int n1 = m-l+1;
        int n2 =  r-m;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for( int i = 0;i < n1; ++i)
            L[i] = arr[l + i];
        for(int j = 0; j < n2 ; ++j)
            R[j] = arr[m+ 1 + j];


        int i=0,j=0;
        int k = l;
        while( i <n1 && j < n2) {
            if( L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] =R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while(j < n2){
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public static void inplacemergesort(int[] arr, int l, int r) {
        if(l<r){
            int m = l+(r-l)/2;
            inplacemergesort(arr,l,m);
            inplacemergesort(arr,m+1,r);
            if(arr[m] <= arr[m +1]){
                return;
            }
            inplacemerge(arr,l,m,r);
        }
    }

    private static void inplacemerge(int[] arr, int l, int m, int r) {
        int start1 = l;
        int start2 = m+1;
        while(start1 <=m && start2 <=r){
            if (arr[start1] <= arr[start2]){
                    start1++;
            }
            else{
                int temp = arr[start2];
                int i =start2;
                while(i>start1){
                    arr[i] =arr[i-1];
                    i=i-1;
                }
                arr[start1]= temp;
                start1++;
                m++;
                start2++;
            }
        }
    }

    public static void sort(int[] arr, int l, int r){
        if(l < r){
            
            int m = l+(r-l)/2;
            sort(arr,l,m);
            sort(arr,m+1,r);
            merge(arr,l,m,r);
        }
    }


}
