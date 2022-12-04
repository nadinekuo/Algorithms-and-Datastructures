import java.io.*;
import java.net.URL;
import java.util.Scanner;

public class Day3_RucksackOrganization {

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Sum of priorities for all duplicate items is: " + getSumOfPriorities());
    }

    public static int getSumOfPriorities() throws FileNotFoundException {

        int sumOfPriorities = 0;
        // Lowercase item types a through z have priorities 1 through 26
        // Uppercase item types A through Z have priorities 27 through 52
        final String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

        URL path = Day3_RucksackOrganization.class.getResource("items_in_backpacks.txt");
        File file = new File(path.getFile());
        Scanner sc = new Scanner(file);
        while (sc.hasNext()) {
            // Read input file, split each line in half (assuming all lines have even no. of chars)
            String itemsInTwoBackpacks = sc.nextLine();
            int n = itemsInTwoBackpacks.length();
            String left = itemsInTwoBackpacks.substring(0, n/2); // beginIdx is inclusive, endIdx is exclusive
            String right = itemsInTwoBackpacks.substring(n/2, n);

            // Check if there is any char that appears in both halves -> O(n^2)
            for (int i = 0; i < left.length(); i++) {
                char charToCheck = left.charAt(i);
                if (right.indexOf(String.valueOf(charToCheck)) != -1) {
                    // Duplicate char (item type) found --> get priority of charToCheck and add to sum
                    int currPrior = alphabet.indexOf(String.valueOf(charToCheck)) + 1;
                    System.out.println("Priority of " + charToCheck + " = " + currPrior);
                    sumOfPriorities += currPrior;
                    break;
                }
            }
        }
        return sumOfPriorities;
    }
}
