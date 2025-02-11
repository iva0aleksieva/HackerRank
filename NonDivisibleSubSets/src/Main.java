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
     * Complete the 'nonDivisibleSubset' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY s
     */

    public static int nonDivisibleSubset(int k, List<Integer> s) {
        // Write your code here
        int[] remainderCounts = new int[k];
        for (int num : s) {
            remainderCounts[num % k]++;
        }

        //equal to 1 if there are remainders=0 or equal to zero if there are none
        int count = Math.min(remainderCounts[0], 1);

        //we take k/2 because remainders start repeating
        for (int i = 1; i <= k / 2; i++) {
            if (i != k - i) { // Normal case: pick max(count[i], count[k-i])
                count += Math.max(remainderCounts[i], remainderCounts[k - i]);
            } else { // Special case: when k is even, pick at most one from k/2
                count += Math.min(remainderCounts[i], 1);
            }
        }

        return count;
    }

}

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> s = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.nonDivisibleSubset(k, s);

        System.out.println(String.valueOf(result));

        bufferedReader.close();

    }
}
