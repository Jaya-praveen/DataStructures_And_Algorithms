package datastructures.primitives;

import java.util.Arrays;

public class parray {




    public static void main(String[] args) {


        //array
        int[] arr1 = { 1, 2, 3, 4, 5 };

        //this line creates reference in stack for the array
        int[] arr2;

        //this line allocates memory for the array in heap
        arr2 = new int[5];

        for(int i:arr2){
            System.out.print(i+" ");
        }
        System.out.println("above shows that every element has a default value of 0 for int");
        arr2[0] = 10;
        arr2[1] = 30;
        arr2[2] = 20;
        arr2[3] = 50;
        arr2[4] = 40;

        for(int i:arr2){
            System.out.print(i+" ");
        }

        System.out.println(arr2.length);

        try{
            //producing indexoutofbondexception
            int val = arr2[5];
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("exception caught " + e);
        }

        //create a clone as array implements cloneable
        int arr3[] = arr2.clone();
        System.out.println(arr2.equals(arr3));


        for(int i:arr3){
            System.out.print(i+" ");
        }

        //java util methods

        Arrays.sort(arr2);
        int[] arr5 = Arrays.copyOf(arr2,3);
        System.out.println(Arrays.toString(arr5));
        arr5 = Arrays.copyOfRange(arr2,2,5);
        System.out.println(Arrays.toString(arr5));
        System.out.println("key found at index "+Arrays.binarySearch(arr2,20));
        Arrays.fill(arr5,2);
        System.out.println(Arrays.toString(arr5));
        Arrays.hashCode(arr5);
        System.out.println(Arrays.toString(arr5));
        System.out.println(Arrays.stream(arr2).max().getAsInt());
        Arrays.setAll(arr2,i->arr2[i]*2);
        System.out.println(Arrays.toString(arr2));
        System.out.println(arr2.getClass());




    }
}
