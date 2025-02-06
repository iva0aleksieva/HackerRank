import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int arrSize = Integer.parseInt(br.readLine().trim());

        List<Integer> arr = Stream.of(br.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .toList();

        result(arr, arrSize);
        br.close();
    }

    private static void result(List<Integer> arr, int size) {
        double positiveInts = 0, negativeInts = 0, zeros = 0;

        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) > 0) {
                positiveInts += 1;
            }
            else if (arr.get(i) < 0) {
                negativeInts += 1;
            }
            else{
                zeros += 1;
            }
        }

        System.out.printf("%.6f\n%.6f\n%.6f\n", positiveInts/size, negativeInts/size, zeros/size);
    }
}