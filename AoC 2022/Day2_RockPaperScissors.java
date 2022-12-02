import java.io.*;
import java.util.Scanner;

public class Day2_RockPaperScissors {

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Total score would be: " + calculateTotalScore());
    }

    public static int calculateTotalScore() throws FileNotFoundException {

        int totalScore = 0;

        // Read txt file containing 2 columns
        File file = new File("C:\\Users\\nadine\\OneDrive\\IdeaProjects\\ADS\\AoC 2022\\rock_paper_scissors.txt");
        Scanner sc = new Scanner(file);
        while (sc.hasNext()) {
            int currScore = getScore(sc.next(), sc.next());
            // Get score for this match and add to total
            totalScore += currScore;
        }
        return totalScore;
    }

    /**
     * @param opponent - choice of opponent
     * @param me - choice of me
     * @return score for single game
     * Opponent --> A = rock (1), B = paper (2), C = scissors (3)
     * Me --> X = rock (1), Y = paper (2), Z = scissors (3)
     * Win: 6
     * Draw: 3
     * Lose: 0
     */
    public static int getScore(String opponent, String me) {

        // For all 3^2 = 9 combinations, return score
        switch(opponent) {
            case "A":  // Opponent plays rock
                if (me.equals("X")) { // I play rock --> draw
                    return 1 + 3;
                } else if (me.equals("Y")) { // I play paper --> win
                    return 2 + 6;
                } else { // I play scissors --> lose
                    return 3 + 0;
                }
            case "B": // Opponent plays paper
                if (me.equals("X")) { // I play rock --> lose
                    return 1 + 0;
                } else if (me.equals("Y")) { // I play paper --> draw
                    return 2 + 3;
                } else { // I play scissors --> win
                    return 3 + 6;
                }
            case "C": // Opponent plays scissors
                if (me.equals("X")) { // I play rock --> win
                    return 1 + 6;
                } else if (me.equals("Y")) { // I play paper --> lose
                    return 2 + 0;
                } else { // I play scissors --> draw
                    return 3 + 3;
                }
            default:
                return Integer.MIN_VALUE;
        }
    }


}
