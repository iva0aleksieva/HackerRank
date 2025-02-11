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
     * Complete the 'climbingLeaderboard' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY ranked
     *  2. INTEGER_ARRAY player
     */

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        // Write your code here
        List<Integer> playerRanks = new ArrayList<>();
        //Stack with scores
        Stack<Integer> rankStack = new Stack<>();

        for (int i = 0; i < ranked.size(); i++) {
            if (!rankStack.contains(ranked.get(i))){
                rankStack.push(ranked.get(i));
            }
        }

        for (int i = 0; i < player.size(); i++) {
            int currentRank = 0;
            for (int j = 0; j < rankStack.size(); j++) {
                if (player.get(i) >= rankStack.get(j)){
                    if (rankStack.indexOf(rankStack.get(j))==0){
                        currentRank = 1;
                        break;
                    }
                    currentRank = rankStack.indexOf(rankStack.get(j))+1;
                    break;
                } else if (player.get(i) < rankStack.get(j)) {
                    currentRank = rankStack.indexOf(rankStack.get(j)) + 2;
                }
            }
            playerRanks.add(currentRank);
        }

        return playerRanks;
    }

}

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int rankedCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ranked = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int playerCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> player = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result.climbingLeaderboard(ranked, player);

        System.out.println(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();

    }
}

/*
List<Integer> ranks = new ArrayList<>();
int maxScore = Integer.MAX_VALUE;
int rank = 0;

//find the ranks of the leaderboard scores
        for (Integer i : ranked) {
        if(i < maxScore){
maxScore = i;
rank +=1;
        ranks.add(rank);
            }
                    else if(i == maxScore){
        ranks.add(rank);
            }
                    }

                    //find the player ranks
                    for (Integer playerScore : player) {

int highestRank = 0;
int lowestRank = 0;
boolean equalFound = false;

            for (int i = 0; i < ranked.size(); i++) {

        //if score is equal to an existing rank
        if(playerScore==ranked.get(i)){
        playerRanks.add(ranks.get(i));
equalFound = true;
        break;
        }
        //if score is less than current rank
        else if(playerScore < ranked.get(i)){
lowestRank = ranks.get(i) + 1;
        }
        //if score is more than current rank
        else if(playerScore > ranked.get(i)){
        if(ranked.get(i) == 1){
highestRank = 1;
        }else{
highestRank = ranks.get(i);
                        break;
                                }
                                }
                                }

                                if(highestRank != 0){
        playerRanks.add(highestRank);
            } else if (!equalFound) {playerRanks.add(lowestRank);}

        }*/
