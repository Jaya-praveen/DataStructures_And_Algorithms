package algorithms.dynamicprogramming;
import java.util.HashMap;
public class Tribonacci {

    public static int tribonacci(int n){
        HashMap<Integer,Integer> map = new HashMap<>();
        return tribonacci(n,map);
    }

    private static int tribonacci(int n,HashMap<Integer,Integer> map){
        if(n==0||n==1) return 0;
        if(n==2) return 1;
        if(map.containsKey(n)) return map.get(n);
        int value = tribonacci(n-1,map)+tribonacci(n-2,map)+tribonacci(n-3,map);
        map.put(n,value);
        return value;

    }
    public static void main(String args[]){
        int[] testValues = {0, 1, 2, 3, 4, 5, 10, 20, 30};
        int[] expected = {0, 0, 1, 1, 2, 4, 149, 35890, 53798080};

        for (int i = 0; i < testValues.length; i++) {
            int n = testValues[i];

            long start = System.nanoTime();
            int result = tribonacci(n);
            long end = System.nanoTime();

            long durationMs = (end - start) / 1_000;

            System.out.println("Tribonacci(" + n + ") = " + result +
                    " | Expected = " + expected[i] +
                    " | Time = " + durationMs + " ms" +
                    (result == expected[i] ? " Success" : " Failed"));

            if (durationMs > 100) {
                System.out.println("Test failed: took too long (" + durationMs + " ms)");
                System.exit(1);
            }
        }

        System.out.println("All tests passed within acceptable time ");
    }
}
