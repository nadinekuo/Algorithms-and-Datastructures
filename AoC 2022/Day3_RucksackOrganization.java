import java.io.*;
import java.net.URL;
import java.util.Scanner;

public class Day3_RucksackOrganization {

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Sum of priorities for all duplicate items is: " + getSumOfPriorities());
    }

    public static int getSumOfPriorities() throws FileNotFoundException {

        int sumOfPriorities = 0;

        // Read input file, split each line in half
        URL path = Day3_RucksackOrganization.class.getResource("items_in_backpacks.txt");
        File file = new File(path.getFile());
        Scanner sc = new Scanner(file);
        while (sc.hasNext()) {
            System.out.println(sc.nextLine());
        }

        // Check if there is any char that appears in both halves

        // Get priority for the char (type) that is duplicate


        // Add to sum of priorities

        return sumOfPriorities;
    }
}
