import java.io.*;
import java.util.Scanner;

public class CountingCalories {

    public static void main(String[] args) throws FileNotFoundException {
        int mostCalories = findMostCalories();
        int top3MostCalories = findTop3MostCalories();
        System.out.println("\n Most calories found: " + mostCalories);
        System.out.println("\n Top 3 most calories found: " + top3MostCalories);
    }

    public static int findMostCalories() throws FileNotFoundException {

        File file = new File("C:\\Users\\nadine\\OneDrive\\IdeaProjects\\ADS\\AoC 2022\\elves_food.txt");
        Scanner sc = new Scanner(file);
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;

        // Read text input
        // Food carried by 1 elf is separated by white line
        while (sc.hasNextLine()) {
            String next = sc.nextLine();
            if (!next.isEmpty()) {
                int amount = Integer.parseInt(next);
                System.out.println("Adding " + amount + " to curr sum: " + currSum);
                currSum += amount;
            } else {
                System.out.println("-----------------------");
                // Update the max no. of calories
                maxSum = Integer.max(maxSum, currSum);
                // Start counting again for next elf
                currSum = 0;
            }
        }
        sc.close();
        return maxSum;
    }

    // Note: alternative solution using streams found on Reddit

//    List<Integer> elfs = Arrays.stream(
//            Files.readAllLines(Path.of("src/main/resources/input.txt"))
//                    .stream()
//                    .collect(Collectors.joining(","))
//                    .split(",,"))
//            .map(e -> Arrays.stream(e.split(","))
//                    .mapToInt(Integer::parseInt).sum())
//            .sorted(Comparator.reverseOrder())
//            .collect(Collectors.toList());
//
//    //Part 1:
//    System.out.println(elfs.get(0));
//    //Part 2:
//    System.out.println(elfs.get(0) + elfs.get(1) + elfs.get(2));

    // NOTE: alternative solution using streams found on Reddit:

//    List<Integer> elfs = Arrays.stream(Files.readString(Path.of("day1.txt")).split("\\n\\n"))
//            .map(s -> Arrays.stream(s.split("\\n")).mapToInt(Integer::parseInt).sum())
//            .sorted(Comparator.reverseOrder())
//            .collect(Collectors.toList());
//    System.out.println("Part 1:" + elfs.get(0));
//    System.out.println("Part 2:" + (elfs.get(0) + elfs.get(1) + elfs.get(2)));
//


    public static int findTop3MostCalories() throws FileNotFoundException {

        File file = new File("C:\\Users\\nadine\\OneDrive\\IdeaProjects\\ADS\\AoC 2022\\elves_food.txt");
        Scanner sc = new Scanner(file);
        int maxSumOne = Integer.MIN_VALUE;
        int maxSumTwo = Integer.MIN_VALUE;
        int maxSumThree = Integer.MIN_VALUE;
        int currSum = 0;

        // Read text input
        // Food carried by 1 elf is separated by white line
        while (sc.hasNextLine()) {
            String next = sc.nextLine();
            if (!next.isEmpty()) {
                int amount = Integer.parseInt(next);
                System.out.println("Adding " + amount + " to curr sum: " + currSum);
                currSum += amount;
            } else {
                System.out.println("-----------------------");
                // Update the max no. of calories
                maxSumOne = Integer.max(maxSumOne, currSum);
                if (currSum > maxSumTwo && currSum < maxSumOne) {
                    maxSumTwo = currSum;
                } else if (currSum > maxSumThree && currSum < maxSumTwo) {
                    maxSumThree = currSum;
                }
                // Start counting again for next elf
                currSum = 0;
            }
        }
        sc.close();
        return maxSumOne + maxSumTwo + maxSumThree;
    }

}
