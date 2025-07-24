package algorithms.dynamicprogramming;
import java.util.*;
//find the number of paths in a grid if you can only right or down to reach last grid i.e (n,n)
public class CountPaths {

    public static int countPaths(List<List<String>> grid){
        int r=0,c=0;
        return countPaths(r,c,grid,new HashMap<List<Integer>,Integer>());
    }
    private static int countPaths(int r,int c,List<List<String>> grid,HashMap<List<Integer>,Integer> map){
        if(r==grid.size() || c==grid.get(0).size()) return 0;
        if(grid.get(r).get(c)=="X") return 0;
        if(r==grid.size()-1 || c==grid.get(0).size()-1) return 1;
        if(map.containsKey(List.of(r,c))) return map.get(List.of(r,c));
        int value = countPaths(r+1,c,grid,map)+countPaths(r,c+1,grid,map);
                map.put(List.of(r,c),value);
                return value;
    }
    public static void main(String[] args) {
        List<TestCase> tests = Arrays.asList(
                new TestCase(
                        Arrays.asList(
                                Arrays.asList("", "", ""),
                                Arrays.asList("", "X", ""),
                                Arrays.asList("", "", "")
                        ),
                        2
                ),
                new TestCase(
                        Arrays.asList(
                                Arrays.asList("0", "0")
                        ),
                        1
                ),
                new TestCase(
                        Arrays.asList(
                                Arrays.asList("X", "0")
                        ),
                        0
                ),
                new TestCase(
                        Arrays.asList(
                                Arrays.asList("", "", ""),
                                Arrays.asList("", "", ""),
                                Arrays.asList("", "", "")
                        ),
                        6
                ),
                new TestCase(
                        Arrays.asList(
                                Arrays.asList("O", "O", "X", "O", "O", "O"),
                                Arrays.asList("O", "O", "X", "O", "O", "O"),
                                Arrays.asList("X", "O", "0", "O", "O", "O"),
                                Arrays.asList("X", "X", "X", "O", "O", "O"),
                                Arrays.asList("O", "O", "O", "O", "O", "O")
                        ),12

                )
        );

        for (TestCase test : tests) {
            long start = System.nanoTime();
            int result = countPaths(test.grid);
            long end = System.nanoTime();

            long durationMs = (end - start) / 1_000;

            System.out.println("countPaths(grid) = " + result +
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

    static class TestCase {
        List<List<String>> grid;
        int expected;

        TestCase(List<List<String>> grid, int expected) {
            this.grid = grid;
            this.expected = expected;
        }
    }
}
