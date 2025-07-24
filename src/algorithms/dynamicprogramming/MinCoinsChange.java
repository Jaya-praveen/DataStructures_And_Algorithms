package algorithms.dynamicprogramming;
import java.util.*;
public class MinCoinsChange {


    public static int minCoinsChange(int amount,List<Integer> coins){
        return minCoinsChange(amount, coins,new HashMap<>());
    }

    private static





    int minCoinsChange(int amount,List<Integer> coins,HashMap<Integer,Integer> map){
        if (amount==0) return 0;
        if (amount<0) return -1;

        if(map.containsKey(amount)) return map.get(amount);
        int min = -1;
        for(int coin:coins){
            int subamount = amount -coin;
            int subcoins =  minCoinsChange(subamount,coins,map);
            if(subcoins != -1) {
                subcoins = subcoins + 1;

                if (subcoins < min || min == -1) {
                    min = subcoins;
                }
            }

        }
        map.put(amount,min);
        return min;
    }
    public static void main(String[] args) {
        // Test cases: amount, coin list, expected result
        List<TestCase> tests = Arrays.asList(
                new TestCase(7, Arrays.asList(1, 2, 5), 2),    // 5 + 2
                new TestCase(11, Arrays.asList(1, 2, 5), 3),   // 5 + 5 + 1
                new TestCase(3, Arrays.asList(2), -1),         // Not possible
                new TestCase(0, Arrays.asList(1, 2, 5), 0),    // 0 amount
                new TestCase(100, Arrays.asList(1, 5, 10, 25), 4) // 25 + 25 + 25 + 25
        );

        for (TestCase test : tests) {
            long start = System.nanoTime();
            int result = minCoinsChange(test.amount, test.coins);
            long end = System.nanoTime();

            long durationMs = (end - start) / 1_000_000;

            System.out.println("minCoinsChange(" + test.amount + ", " + test.coins + ") = " + result +
                    " | Expected = " + test.expected +
                    " | Time = " + durationMs + " ms" +
                    (result == test.expected ? " Succes" : " Failed"));

            if (durationMs > 100) {
                System.out.println("Test failed: took too long (" + durationMs + " ms)");
                System.exit(1);
            }
        }

        System.out.println("All tests passed within acceptable time ");
    }

    // Test case helper class
    static class TestCase {
        int amount;
        List<Integer> coins;
        int expected;

        TestCase(int amount, List<Integer> coins, int expected) {
            this.amount = amount;
            this.coins = coins;
            this.expected = expected;
        }
    }
}
