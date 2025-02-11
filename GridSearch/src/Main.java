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
     * Complete the 'gridSearch' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING_ARRAY G
     *  2. STRING_ARRAY P
     */

    public static String gridSearch(List<String> G, List<String> P) {
        //take first string from pattern
        //try to find it in grid and locate beginning index
        String firstString = P.get(0);
        int startIndex = -1;
        int rowIndex =0;
        int firstStrCount = 0;
        boolean found = false;

        //how many times does the pattern begin
        for (int i = 0; i < G.size(); i++) {
            for (int j = 0; j < G.get(i).length()-1; j++) {
                if (G.get(i).substring(j).contains(firstString)) {
                    j = G.get(i).indexOf(firstString,j);
                    startIndex = j;
                    rowIndex = i+1;

                    int patternSize = P.get(0).length();

                    for (int k = 1; k < P.size(); k++) {
                        if(rowIndex == G.size()) {
                            return "NO";
                        }
                        String searchString = G.get(rowIndex);
                        searchString = searchString.substring(startIndex, startIndex + patternSize);

                        if (!searchString.equals(P.get(k))) {
                            found = false;
                            break;
                        }else{
                            found = true;
                        }
                        rowIndex++;
                    }
                }
                if (found){
                    break;
                }
            }
            if (found){
                break;
            }
        }

        if (found){
            return "YES";
        } else return "NO";
    }

}

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int R = Integer.parseInt(firstMultipleInput[0]);

                int C = Integer.parseInt(firstMultipleInput[1]);

                List<String> G = IntStream.range(0, R).mapToObj(i -> {
                            try {
                                return bufferedReader.readLine();
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                        })
                        .collect(toList());

                String[] secondMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int r = Integer.parseInt(secondMultipleInput[0]);

                int c = Integer.parseInt(secondMultipleInput[1]);

                List<String> P = IntStream.range(0, r).mapToObj(i -> {
                            try {
                                return bufferedReader.readLine();
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                        })
                        .collect(toList());

                String result = Result.gridSearch(G, P);

                System.out.println(result);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}

