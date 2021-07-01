import java.util.List;
import java.util.*;

public class MaxSRDifferenceL1 {

    public static void main(String[] args) {

        List<Integer> hockeyPlayers = List.of(44, 22, 12, 88, 54, 33, 23, 1, 2, 35, 3, 4, 5, 6, 58, 84, 99, 97);


        long startTime = System.nanoTime();
        System.out.println(maxSRDifference1(hockeyPlayers));
        long endTime = System.nanoTime();
        long elapsedTime = endTime-startTime;
        System.out.println(elapsedTime);

        long startTime2 = System.nanoTime();
        System.out.println(maxSRDifference2(hockeyPlayers));
        long endTime2 = System.nanoTime();
        long elapsedTime2 = endTime-startTime;
        System.out.println(elapsedTime2);

        long startTime3 = System.nanoTime();
        System.out.println(maxSRDifference3(hockeyPlayers));
        long endTime3 = System.nanoTime();
        long elapsedTime3 = endTime-startTime;
        System.out.println(elapsedTime3);
    }



// Slowest; you check similar pairs 2x!
    public static int maxSRDifference1 (List<Integer> SR) {

        int currentMax = 0;                                            // 1
        for (int i=0; i < SR.size(); i++) {                            // 1 + (n+1) + 2n
            for (int j=0; j < SR.size(); j++) {                        // (1 + (n+1) + 2n) * n
                int SRDifference = Math.abs(SR.get(i)-SR.get(j));      // 3n^2
                if (SRDifference > currentMax) {                       // n^2
                    currentMax = SRDifference;                         // n^2
                }
            }
        }
       return currentMax;                                               // 1
    }                                                                   // total: 8n^2 + 5n + 4  --> O(n^2)




// Avoids checking similar pairs
    public static int maxSRDifference2 (List<Integer> SR) {

        int currentMax = 0;                                           // 1
        for (int i=0; i < SR.size(); i++) {                           // 1 + (n+1) + 2n
            for (int j=i+1; j < SR.size(); j++) {                     // 2n + (n(n+1)/2) + 2(n(n-1)/2)
                int SRDifference = Math.abs(SR.get(i)-SR.get(j));     // 3(n(n-1)/2)
                if (SRDifference > currentMax) {                      // (n(n-1)/2)
                    currentMax = SRDifference;                        // (n(n-1)/2)
                }
            }
        }
        return currentMax;                                             // 1
    }                                                                  // Total: 4n^2 + 2n + 4




    public static int maxSRDifference3 (List<Integer> SR) {
        int currentMax = 0;                                             // 1
        for (int i = 0; i < SR.size(); i++) {                           // 1 + (n+1) + 2n
                int thisSR = SR.get(i);                                 // n
                if (thisSR > currentMax) {                              // n
                    currentMax = thisSR;                                // n
                }
        }
        int currentMin = Integer.MAX_VALUE;                             // 1
        for (int i = 0; i < SR.size(); i++) {                           // 1 + (n+1) + 2n
            int thisSR = SR.get(i);                                     // n
            if (thisSR < currentMin) {                                  // n
                currentMin = thisSR;                                    // n
            }
        }
        return currentMax - currentMin;                                  // 2
    }                                                                    // Total: 12n + 8


}
