import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'formingMagicSquare' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY s as parameter.
     */

    public static int formingMagicSquare(List<List<Integer>> s) {
        //all possible magic squares for 3x3, 1-9
        int[][] square1 = {{8, 1, 6}, {3, 5, 7}, {4, 9, 2}};
        int[][] square2 = {{6, 1, 8}, {7, 5, 3}, {2, 9, 4}};
        int[][] square3 = {{4, 3, 8}, {9, 5, 1}, {2, 7, 6}};
        int[][] square4 = {{2, 7, 6}, {9, 5, 1}, {4, 3, 8}};
        int[][] square5 = {{2, 9, 4}, {7, 5, 3}, {6, 1, 8}};
        int[][] square6 = {{4, 9, 2}, {3, 5, 7}, {8, 1, 6}};
        int[][] square7 = {{6, 7, 2}, {1, 5, 9}, {8, 3, 4}};
        int[][] square8 = {{8, 3, 4}, {1, 5, 9,}, {6, 7, 2}};

        int sumCost;
        int minCost = Integer.MAX_VALUE;
        int[][][] squares = {square1,square2,square3,square4,square5,square6,square7,square8};
        for (int[][] square : squares) {
            sumCost = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    sumCost += Math.abs(s.get(i).get(j) - square[i][j]);
                }
            }
            if (sumCost < minCost) {minCost = sumCost;}
        }

        return minCost;
    }

}

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<List<Integer>> s = new ArrayList<>();

        IntStream.range(0, 3).forEach(i -> {
            try {
                s.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.formingMagicSquare(s);

        System.out.println(String.valueOf(result));

        bufferedReader.close();
    }
}
