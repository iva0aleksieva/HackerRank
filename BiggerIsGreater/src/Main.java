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
     * Complete the 'biggerIsGreater' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING w as parameter.
     */

    public static String biggerIsGreater(String w) {
        // Write your code here
        w = w.toLowerCase();
        char[] chars = w.toCharArray();
        int index = -1;

        //find the first char (right to left) that is smaller than the next
        for (int i = chars.length-1; i >= 0; i--) {
            if (i!=0) {
                if (chars[i] < chars[i - 1]) {
                    index = i;
                    break;
                }
            }else{
                if (chars[0] < chars[i+1]) {
                    index = 0;
                }
            }
        }

        //if no such char exists print no answer
        if (index == -1) {
            return "no answer";
        }

        //find the smallest char to the right of index to switch with
        int switchIndex = -1;
        for (int i = chars.length-1; i > index ; i--) {
            if (chars[i] < chars[i-1]) {
                switchIndex = i;
            }
        }
        if (switchIndex == -1) {
            switchIndex = chars.length-1;
        }

        //switch chars
        char temp = chars[index];
        chars[index] = chars[switchIndex];
        chars[switchIndex] = temp;

        Arrays.sort(chars, index+1, chars.length);

        return String.valueOf(chars);
    }

}

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, T).forEach(TItr -> {
            try {
                String w = bufferedReader.readLine();

                String result = Result.biggerIsGreater(w);

                System.out.println(result);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}
