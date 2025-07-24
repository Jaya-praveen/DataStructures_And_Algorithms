package algorithms.dynamicprogramming;
import java.util.HashMap;
public class Fib {
    public static  int fib(int n){
        HashMap<Integer,Integer> map =new HashMap<>();
        return fib(n,map);
    }
    private static int fib(int n,HashMap<Integer,Integer> map){
        if(n==0||n==1){
            return n;
        }
        if(map.containsKey(n)){
            return map.get(n);
        }
        int value = fib(n-1,map)+fib(n-2,map);
        map.put(n,value);
        return value;
    }

    public static void main(String[] args){
        int[] testValues = {0, 1, 2, 5, 10, 20, 30, 40};
        long[] expectedResults = {
                0, 1, 1, 5, 55,
                6765, 832040, 102334155
        };

        for (int i = 0; i < testValues.length; i++) {
            int n = testValues[i];

            long startTime = System.nanoTime();
            int result = fib(n);
            long endTime = System.nanoTime();

            long durationMs = (endTime - startTime) / 1_000;

            System.out.println("Fib(" + n + ") = " + result +
                    " | Expected = " + expectedResults[i] +
                    " | Time = " + durationMs + " ms" +
                    (result == expectedResults[i] ? " yes" : " NO"));
        }
    }
}
