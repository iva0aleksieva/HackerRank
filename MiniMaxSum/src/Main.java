import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(br.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .toList();

        result(arr);
        br.close();
    }

    private static void result(List<Integer> arr) {
        ArrayList<Integer> sorted = new ArrayList<>(arr);
        long miniSum = 0;
        long maxSum = 0;
        //sort the list
        for (int i = 0; i < sorted.size(); i++) {
            for (int j = i+1; j < sorted.size(); j++) {
                int temp = sorted.get(i);
                if (sorted.get(i) > sorted.get(j)) {
                    sorted.set(i, sorted.get(j));
                    sorted.set(j, temp);
                }
            }
        }
        //calculate mini sum
        for (int i = 0; i < sorted.size()-1; i++) {
            miniSum += sorted.get(i);
        }
        //calculate max sum
        for (int i = 1; i < sorted.size(); i++) {
            maxSum += sorted.get(i);
        }
        System.out.printf(miniSum + " " + maxSum);
    }
}