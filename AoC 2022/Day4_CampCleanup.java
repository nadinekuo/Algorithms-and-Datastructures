import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.net.URL;

public class Day4_CampCleanup {

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Total no. of pairs for which one range fully contains the other: " + getNumberOfPairsFullOverlap());
        System.out.println("Total no. of pairs for which one range (partially) contains the other: " + getNumberOfPairsPartialOverlap());
    }

    public static int getNumberOfPairsFullOverlap() throws FileNotFoundException {

        int totalCount = 0;

        URL path = Day4_CampCleanup.class.getResource("cleaning_section_pairs.txt");
        File file = new File(path.getFile());
        Scanner sc = new Scanner(file).useDelimiter("[,\r\n]+"); // use "," and "\n" as delimiters

        while (sc.hasNext()) {
            // Each line represents ranges for 1 pair (2 elves), separated by comma
            String[] sectionsElf1 = sc.next().split("-");
            String[] sectionsElf2 = sc.next().split("-");
//            System.out.println(Arrays.toString(sectionsElf1));
//            System.out.println(Arrays.toString(sectionsElf2));

            // Check if one (the smallest) range is fully contained in the other
            int start1 = Integer.parseInt(sectionsElf1[0]);
            int end1 = Integer.parseInt(sectionsElf1[1]);
            int start2 = Integer.parseInt(sectionsElf2[0]);
            int end2 = Integer.parseInt(sectionsElf2[1]);
            // Find smallest range --> check if that range is fully contained in the other
            if ((end1 - start1) <= (end2 - start2)) {
                if (start1 >= start2 && end1 <= end2) {
                    totalCount++;
                }
            } else {
                if (start2 >= start1 && end2 <= end1) {
                    totalCount++;
                }
            }
        }
        return totalCount;
    }

    public static int getNumberOfPairsPartialOverlap() throws FileNotFoundException {

        int totalCount = 0;

        URL path = Day4_CampCleanup.class.getResource("cleaning_section_pairs.txt");
        File file = new File(path.getFile());
        Scanner sc = new Scanner(file).useDelimiter("[,\r\n]+"); // use "," and "\n" as delimiters

        while (sc.hasNext()) {
            // Each line represents ranges for 1 pair (2 elves), separated by comma
            String[] sectionsElf1 = sc.next().split("-");
            String[] sectionsElf2 = sc.next().split("-");
//            System.out.println(Arrays.toString(sectionsElf1));
//            System.out.println(Arrays.toString(sectionsElf2));

            int start1 = Integer.parseInt(sectionsElf1[0]);
            int end1 = Integer.parseInt(sectionsElf1[1]);
            int start2 = Integer.parseInt(sectionsElf2[0]);
            int end2 = Integer.parseInt(sectionsElf2[1]);

            // Check if ranges overlap
            if (start1 <= end2 && end1 >= start2) {
                totalCount++;
            }
        }
        return totalCount;
    }


}
