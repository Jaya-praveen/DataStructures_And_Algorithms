package algorithms.dynamicprogramming;
import java.util.*;
public class ArrayStepper {

    public static boolean arrayStepper(List<Integer> nums){
        return arrayStepper(nums,0,new HashMap<>());
    }
    public static boolean arrayStepper(List<Integer> nums,int Idx,HashMap<Integer,Boolean> map){
        if(Idx == nums.size()-1){
            return true;
        }
        if(map.containsKey(Idx)) return map.get(Idx);
        int maxstep = nums.get(Idx);
        for(int step=1;step<=maxstep;step++){
        if(Idx + step < nums.size() && arrayStepper(nums,Idx+step,map)){
                map.put(Idx,true);
                return true;
            }
        }
        map.put(Idx,false);
        return false;
    }

    public static void main(String[] args) {
        List<List<Integer>> testCases = new ArrayList<>();
        List<Boolean> expectedResults = new ArrayList<>();

        // Test case 1: Simple positive case
        testCases.add(Arrays.asList(2, 4, 1, 0, 2, 0));
        expectedResults.add(true);

        // Test case 2: Can't reach end
        testCases.add(Arrays.asList(3, 1, 0, 0, 2, 0));
        expectedResults.add(false);

        // Test case 3: Already at the end
        testCases.add(Arrays.asList(0));
        expectedResults.add(true);

        // Test case 4: One jump to the end
        testCases.add(Arrays.asList(1, 0));
        expectedResults.add(true);

        // Test case 5: All elements are 0 (except first)
        testCases.add(Arrays.asList(5, 0, 0, 0, 0, 0));
        expectedResults.add(true);

        // Test case 6: Edge case with large input to test performance
        List<Integer> largeCase = new ArrayList<>(Collections.nCopies(10000, 1));
        testCases.add(largeCase);
        expectedResults.add(true);

        // Running test cases
        for (int i = 0; i < testCases.size(); i++) {
            long startTime = System.nanoTime();
            boolean result = arrayStepper(testCases.get(i));
            long endTime = System.nanoTime();

            System.out.println("Test Case " + (i + 1) + ": " + (result == expectedResults.get(i) ? "PASS" : "FAIL"));
            System.out.println(" - Expected: " + expectedResults.get(i));
            System.out.println(" - Actual  : " + result);
            System.out.printf(" - Runtime : %.2f ms%n", (endTime - startTime) / 1e6);
            System.out.println();
        }
    }
}
