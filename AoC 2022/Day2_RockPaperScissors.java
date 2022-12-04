import java.io.*;
import java.net.URL;
import java.util.Scanner;

public class Day2_RockPaperScissors {

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Total score could be: " + calculatePotentialTotalScore());
        System.out.println("Real total score is: " + calculateRealTotalScore());
    }

    /**
     *
     * @return Potential final score assuming that:
     *          - Col 1 is what opponent plays
     *          - Col 2 is what you play
     * @throws FileNotFoundException
     */
    public static int calculatePotentialTotalScore() throws FileNotFoundException {

        int totalScore = 0;

        // Read txt file containing 2 columns
        URL path = Day2_RockPaperScissors.class.getResource("rock_paper_scissors.txt");
        File file = new File(path.getFile());
        Scanner sc = new Scanner(file);
        while (sc.hasNext()) {
            int currScore = getScore(sc.next(), sc.next());
            // Get score for this match and add to total
            totalScore += currScore;
        }
        return totalScore;
    }

    /**
     *
     * @return total score, assuming that:
     *          - Col 1 is what opponent plays
     *          - Col 2 is what the outcome should be
     * @throws FileNotFoundException
     */
    public static int calculateRealTotalScore() throws FileNotFoundException {

        int totalScore = 0;

        // Read txt file containing 2 columns
        File file = new File("C:\\Users\\nadine\\OneDrive\\IdeaProjects\\ADS\\AoC 2022\\rock_paper_scissors.txt");
        Scanner sc = new Scanner(file);
        while (sc.hasNext()) {
            // Find out what you need to play, given what the opponent plays
            String opponentMove = sc.next();
            String outcome = sc.next();
            // Get score for this match and add to total
            int currScore = getRealScore(opponentMove, outcome);
            totalScore += currScore;
        }
        return totalScore;
    }

    /**
     * @param opponent
     * @param outcome
     * @return which move I should play to get the outcome desired
     *              X = lose, Y = draw, Z = win
     */
    public static int getRealScore(String opponent, String outcome) {

        // For all 3^2 = 9 combinations, return score
        switch(opponent) {
            case "A":                               // Opponent plays rock
                if (outcome.equals("X")) {          // Lose: play scissors (3)
                    return 3 + 0;
                } else if (outcome.equals("Y")) {   // Draw: play rock (1)
                    return 1 + 3;
                } else {                            // Win: play paper (2)
                    return 2 + 6;
                }
            case "B":                               // Opponent plays paper
                if (outcome.equals("X")) {          // Lose: play rock (1)
                    return 1 + 0;
                } else if (outcome.equals("Y")) {   // Draw: play paper (2)
                    return 2 + 3;
                } else {                            // Win: play scissors (3)
                    return 3 + 6;
                }
            case "C":                               // Opponent plays scissors
                if (outcome.equals("X")) {          // Lose: play paper (2)
                    return 2 + 0;
                } else if (outcome.equals("Y")) {   // Draw: play scissors (3)
                    return 3 + 3;
                } else {                            // Win: play rock (1)
                    return 1 + 6;
                }
            default:
                return Integer.MIN_VALUE;
        }
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
            case "A":                               // Opponent plays rock
                if (me.equals("X")) {               // I play rock --> draw
                    return 1 + 3;
                } else if (me.equals("Y")) {        // I play paper --> win
                    return 2 + 6;
                } else {                            // I play scissors --> lose
                    return 3 + 0;
                }
            case "B":                               // Opponent plays paper
                if (me.equals("X")) {               // I play rock --> lose
                    return 1 + 0;
                } else if (me.equals("Y")) {        // I play paper --> draw
                    return 2 + 3;
                } else {                            // I play scissors --> win
                    return 3 + 6;
                }
            case "C":                               // Opponent plays scissors
                if (me.equals("X")) {               // I play rock --> win
                    return 1 + 6;
                } else if (me.equals("Y")) {        // I play paper --> lose
                    return 2 + 0;
                } else {                            // I play scissors --> draw
                    return 3 + 3;
                }
            default:
                return Integer.MIN_VALUE;
        }
    }


}
