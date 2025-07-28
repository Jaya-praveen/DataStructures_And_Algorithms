package algorithms.dynamicprogramming;
import java.util.*;
public class MaxSumPath {
    public static int maxSumPath(List<List<Integer>> grid){
        int r=0,c=0;
        return (int)maxSumPath(r,c,grid,new HashMap<>());
    }
    public static double maxSumPath(int r, int c,List<List<Integer>> grid,HashMap<List<Integer>,Double> map){
        if(r>=grid.size() || c >= grid.get(0).size()) return Double.NEGATIVE_INFINITY;
        if(r==grid.size()-1 && c == grid.get(0).size()-1) return grid.get(r).get(c);
        if(map.containsKey(List.of(r,c))) return map.get(List.of(r,c));
        double value = grid.get(r).get(c)+Math.max(maxSumPath(r+1,c,grid,map),maxSumPath(r,c+1,grid,map));
        map.put(List.of(r,c),value);
        return value;
    }

    public static void main(String[] args) {
        List<TestCase> tests = Arrays.asList(
                new TestCase(
                        Arrays.asList(
                                Arrays.asList(1, 3, 1),
                                Arrays.asList(1, 5, 1),
                                Arrays.asList(4, 2, 1)
                        ),
                        12  // Path: 1 → 3 → 5 → 2 → 1
                ),
                new TestCase(
                        Arrays.asList(
                                Arrays.asList(1, 2, 3),
                                Arrays.asList(4, 5, 6)
                        ),
                        16  // Path: 1 → 4 → 5 → 6
                ),
                new TestCase(
                        Arrays.asList(
                                Arrays.asList(10)
                        ),
                        10
                ),
                new TestCase(
                        Arrays.asList(
                                Arrays.asList(5, 4),
                                Arrays.asList(1, 100)
                        ),
                        109 // Path: 5 → 4 → 100
                )
        );

        for (TestCase test : tests) {
            long start = System.nanoTime();
            int result = maxSumPath(test.grid);
            long end = System.nanoTime();

            long durationMs = (end - start) / 1_000;

            System.out.println("maxSumPath(grid) = " + result +
                    " | Expected = " + test.expected +
                    " | Time = " + durationMs + " ms" +
                    (result == test.expected ? " Success" : " Failed"));

            if (durationMs > 100) {
                System.out.println("Test failed: took too long (" + durationMs + " ms)");
                System.exit(1);
            }
        }

        System.out.println("All tests passed within acceptable time ");
    }

    // Helper class for test cases
    static class TestCase {
        List<List<Integer>> grid;
        int expected;

        TestCase(List<List<Integer>> grid, int expected) {
            this.grid = grid;
            this.expected = expected;
        }
    }

}
