package algorithms.dynamicprogramming;
import java.util.*;
public class SumminSquares {
    public static int summinSquares(int n){
        return summinSquares( n,new HashMap<>());
    }
    private static int summinSquares(int n,HashMap<Integer,Integer> map){
        if(n == 0){
            return 0;
        }
        if(map.containsKey(n)) return map.get(n);
        int minsquares = Integer.MAX_VALUE;
        for(int i=1;i<=Math.sqrt(n);i++){
            int square = i*i;
            int numsquares = 1+summinSquares(n-square,map);
             minsquares = Math.min(minsquares,numsquares);

        }
        map.put(n,minsquares);
        return minsquares;
    }

    public static void main(String[] args) {
        // Define test cases: {input, expectedOutput}
        int[][] testCases = {
                {0, 0},
                {1, 1},      // 1
                {2, 2},      // 1 + 1
                {3, 3},      // 1 + 1 + 1
                {4, 1},      // 4
                {5, 2},      // 4 + 1
                {12, 3},     // 4 + 4 + 4
                {13, 2},     // 9 + 4
                {17, 2},     // 16 + 1
                {23, 4},     // 9 + 9 + 4 + 1
                {100, 1},    // 100
                {99, 3},     // 81 + 9 + 9
                {50, 2}      // 25 + 25
        };

        final long TIME_LIMIT_MICROSECONDS = 100_000; // 100 ms

        System.out.println("Running Test Cases...\n");

        for (int[] testCase : testCases) {
            int input = testCase[0];
            int expected = testCase[1];

            long startTime = System.nanoTime();
            int actual = summinSquares(input);
            long endTime = System.nanoTime();

            long durationMicroseconds = (endTime - startTime) / 1000;

            boolean correct = (actual == expected);
            boolean fastEnough = (durationMicroseconds <= TIME_LIMIT_MICROSECONDS);

            System.out.printf("Test n = %d | Expected: %d, Got: %d | Time: %d µs => %s\n",
                    input, expected, actual, durationMicroseconds,
                    (correct && fastEnough) ? " Succes" :
                            (!correct ? " FAIL (Wrong Answer)" : " FAIL (Slow Execution)")
            );
        }
    }
}
