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
     * Complete the 'organizingContainers' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts 2D_INTEGER_ARRAY container as parameter.
     */

    public static String organizingContainers(List<List<Integer>> container) {
        // Write your code here
        String result[] = {"Possible", "Impossible"};
        int[] capacity = new int[container.size()];
        int[] ballCount = new int[container.size()];

        for (int i = 0; i < container.size(); i++) {

            for (int j = 0; j < container.get(i).size(); j++) {
                capacity[i] += container.get(i).get(j);
                ballCount[i] += container.get(j).get(i);
            }
        }
        capacity = Arrays.stream(capacity).sorted().toArray();
        ballCount = Arrays.stream(ballCount).sorted().toArray();

        boolean areEqual = true;
        for (int i = 0; i < capacity.length; i++) {
            for (int j = 0; j < ballCount.length; j++) {
                if (capacity[i] == ballCount[j]) {
                    areEqual = true;
                }else{
                    areEqual = false;
                    break;
                }
            }
        }
        if (areEqual) {
            return result[0];
        }
        else {
            return result[1];
        }

    }

}

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<List<Integer>> container = new ArrayList<>();

                IntStream.range(0, n).forEach(i -> {
                    try {
                        container.add(
                                Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                        .map(Integer::parseInt)
                                        .collect(toList())
                        );
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                String result = Result.organizingContainers(container);

                System.out.println(result);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}
