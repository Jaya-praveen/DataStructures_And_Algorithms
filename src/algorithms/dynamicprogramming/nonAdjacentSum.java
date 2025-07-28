package algorithms.dynamicprogramming;
import java.util.*;
public class nonAdjacentSum {
    public static int nonAdjacentSum(List<Integer> nums){
        return nonAdjacentSum(nums,0,new HashMap<>());
    }
    public static int nonAdjacentSum(List<Integer> nums,int i,HashMap<Integer,Integer> map){
        if(i>=nums.size()){
            return 0;
        }
        if (map.containsKey(i)) {
            return map.get(i);
        }
        int value = Math.max(nums.get(i)+nonAdjacentSum(nums,i+3,map),nonAdjacentSum(nums,i+1,map));
        map.put(i,value);
        return value;
    }

    public static void main(String[] args) {
        List<Integer> testList = Arrays.asList(3, 2, 5, 10, 7);

        long startTime = System.nanoTime(); // Start runtime measurement

        int result = nonAdjacentSum(testList);

        long endTime = System.nanoTime(); // End runtime measurement
        long durationInMicroseconds = (endTime - startTime) / 1000;

        System.out.println("Maximum non-adjacent sum: " + result);
        System.out.println("Runtime: " + durationInMicroseconds + " microseconds");
    }
}
