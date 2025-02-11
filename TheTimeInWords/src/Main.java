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
     * Complete the 'timeInWords' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER h
     *  2. INTEGER m
     */

    public static String timeInWords(int h, int m) {
        // Write your code here
        TreeMap<Integer,String> numberToWord =new TreeMap<>();
        numberToWord.put(1, "one");
        numberToWord.put(2, "two");
        numberToWord.put(3, "three");
        numberToWord.put(4, "four");
        numberToWord.put(5, "five");
        numberToWord.put(6, "six");
        numberToWord.put(7, "seven");
        numberToWord.put(8, "eight");
        numberToWord.put(9, "nine");
        numberToWord.put(10, "ten");

        // Numbers 11-20
        numberToWord.put(11, "eleven");
        numberToWord.put(12, "twelve");
        numberToWord.put(13, "thirteen");
        numberToWord.put(14, "fourteen");
        numberToWord.put(15, "fifteen");
        numberToWord.put(16, "sixteen");
        numberToWord.put(17, "seventeen");
        numberToWord.put(18, "eighteen");
        numberToWord.put(19, "nineteen");
        numberToWord.put(20, "twenty");

        // Numbers 21-30
        numberToWord.put(21, "twenty-one");
        numberToWord.put(22, "twenty-two");
        numberToWord.put(23, "twenty-three");
        numberToWord.put(24, "twenty-four");
        numberToWord.put(25, "twenty-five");
        numberToWord.put(26, "twenty-six");
        numberToWord.put(27, "twenty-seven");
        numberToWord.put(28, "twenty-eight");
        numberToWord.put(29, "twenty-nine");
        numberToWord.put(30, "thirty");
        int hour;
        if(h!=24){
            hour = h;
        }else{
            hour = 0;
        }

        String anwser = "";
        if(m == 0){
            anwser = numberToWord.get(h) + " " + "o' clock";
        }
        else if(m==15){
            anwser = "quarter past " + numberToWord.get(h);
        }
        else if(m==45){
            anwser = "quarter to " + numberToWord.get(hour+1);
        }
        else if(m==30){
            anwser = "half past " + numberToWord.get(h);
        }
        else if(m<30){
            anwser = numberToWord.get(m) + " minutes past " + numberToWord.get(h);
        }
        else if(m>30){
            anwser = numberToWord.get(60 - m) + " minutes to " + numberToWord.get(hour+1);
        }

        return anwser;
    }

}

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int h = Integer.parseInt(bufferedReader.readLine().trim());

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.timeInWords(h, m);

        System.out.println(result);

        bufferedReader.close();
    }
}
