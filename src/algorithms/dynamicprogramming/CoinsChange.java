package algorithms.dynamicprogramming;
import java.util.*;
public class CoinsChange {
    public static int coinsChange(int target,List<Integer> coins){
        return coinsChange(target,0,coins,new HashMap<>());
    }

    private static int coinsChange(int target,int coinIdx,List<Integer> coins,HashMap<List<Integer>,Integer> map){
        if(target == 0){
            return 1;
        }
        if(coinIdx >= coins.size()){
            return 0;
        }
        List key = List.of(target,coinIdx);
        if(map.containsKey(key)) return map.get(key);
        int totalways = 0;
        int value = coins.get(coinIdx);
        for(int qty=0;qty*value<=target;qty++){
            int subamount = target - (qty*value);
            totalways+= coinsChange(subamount,coinIdx+1,coins,map);
        }
        map.put(key,totalways);
        return totalways;

    }

    public static void main(String[] args) {
        List<TestCase> tests = List.of(
                new TestCase(5, Arrays.asList(1, 2), 3),
                new TestCase(10, Arrays.asList(2, 5, 3, 6), 5),
                new TestCase(0, Arrays.asList(1, 2, 3), 1), // base case: 1 way to make 0
                new TestCase(4, Arrays.asList(3, 5), 0), // no way to make 4 with 3 and 5
                new TestCase(100, Arrays.asList(1, 5, 10, 25, 50), 292), // classic US coins
                new TestCase(300, Arrays.asList(7, 14, 28), -1) // large input to test performance
        );

        for (int i = 0; i < tests.size(); i++) {
            TestCase t = tests.get(i);
            long startTime = System.nanoTime();
            int result = CoinsChange.coinsChange(t.amount, t.coins);
            long endTime = System.nanoTime();
            double durationMs = (endTime - startTime) / 1e6;

            System.out.printf("Test %d: Target=%d, Coins=%s -> Expected=%s, Got=%d [Time: %.2f ms]%n",
                    i + 1,
                    t.amount,
                    t.coins,
                    (t.expected == -1 ? "(ignored)" : t.expected),
                    result,
                    durationMs
            );

            if (t.expected != -1 && result != t.expected) {
                System.out.printf("Test %d failed!%n", i + 1);
            } else if (durationMs > 1000) {
                System.out.printf("Test %d passed but took too long: %.2f ms%n", i + 1, durationMs);
            } else {
                System.out.printf("Test %d passed in %.2f ms%n", i + 1, durationMs);
            }

            System.out.println("----------------------------------------------------");
        }
    }

    static class TestCase {
        int amount;
        List<Integer> coins;
        int expected; // use -1 if expected value is unknown or not asserted

        TestCase(int amount, List<Integer> coins, int expected) {
            this.amount = amount;
            this.coins = coins;
            this.expected = expected;
        }
    }
}
