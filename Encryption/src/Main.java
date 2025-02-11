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
     * Complete the 'encryption' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String encryption(String s) {
        // Write your code here

        s= s.replaceAll("\\s+","");
        int strSize = s.length();
        int rows = (int)Math.floor(Math.sqrt(strSize));
        int cols = (int)Math.ceil(Math.sqrt(strSize));

        if (rows*cols < strSize) {
            rows = (int)Math.ceil((double)strSize/cols);
        }

        StringBuilder result = new StringBuilder();

        //Anything that is a space character
        for (int p = 0; p< cols; p++) {
            int position = p;
            for (int i = 0; i < rows; i++) {
                try {
                    result.append(s.charAt(position));
                    position += cols;
                }
                catch (Exception e) {
                    break;
                }
            }
            result.append(" ");
        }


        return result.toString();
    }

}

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));


        String s = bufferedReader.readLine();

        String result = Result.encryption(s);

        System.out.println(result);

        bufferedReader.close();
    }
}
