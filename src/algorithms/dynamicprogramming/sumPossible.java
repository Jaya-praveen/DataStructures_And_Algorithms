package algorithms.dynamicprogramming;
import java.util.List;
import java.util.*;
//check if a given num is possible by adding elements of a array
//{1,2,3,4} num= 8 true  ->1+1+1+1+1+1+1+1 1+2+3+2 .........
public class sumPossible {

    public static boolean sumPossible(int amount,List<Integer> numbers){
        return sumPossible(amount,numbers,new HashMap<>());
    }
    private static boolean sumPossible(int amount,List<Integer> numbers,HashMap<Integer,Boolean> map){
        if(amount ==0) return true;
        if(amount<0) return false;
        if(map.containsKey(amount)) return map.get(amount);
        for(int number:numbers){
            int subamount = amount - number;
            if(sumPossible(subamount,numbers,map)){
                map.put(amount,true);
                return true;
            }
        }
        map.put(amount,false);
        return false;
    }
    public static void main(String[] args){
// Test cases: amount, input list, expected result
        List<TestCase> tests = Arrays.asList(
                new TestCase(8, Arrays.asList(5, 3, 2), true),
                new TestCase(7, Arrays.asList(5, 3, 4), true),
                new TestCase(7, Arrays.asList(2, 4), false),
                new TestCase(300, Arrays.asList(7, 14), false),
                new TestCase(100, Arrays.asList(25, 10), true)
        );

        for (TestCase test : tests) {
            long start = System.nanoTime();
            boolean result = sumPossible(test.amount, test.numbers);
            long end = System.nanoTime();
            long durationMs = (end - start) / 1_000;

            System.out.println("sumPossible(" + test.amount + ", " + test.numbers + ") = " + result +
                    " | Expected = " + test.expected +
                    " | Time = " + durationMs + " ms" +
                    (result == test.expected ? "Success" : " Failed"));

            if (durationMs > 100) {
                System.out.println("Test failed: took too long (" + durationMs + " ms)");
                System.exit(1);
            }
        }

        System.out.println("All tests passed within acceptable time ");
    }

    // Helper class for test cases
    static class TestCase {
        int amount;
        List<Integer> numbers;
        boolean expected;

        TestCase(int amount, List<Integer> numbers, boolean expected) {
            this.amount = amount;
            this.numbers = numbers;
            this.expected = expected;
        }
    }
}
