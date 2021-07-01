import java.util.ArrayList;
import java.util.List;

public class BinarySearchL2 {


    public static void main(String[] args) {

        List<Integer> hockeyPlayers = List.of(44, 22, 12, 88, 54, 33, 23, 1, 2, 35, 3, 4, 5, 6, 58, 84, 99, 97);
        List<Integer> sortedPlayers = List.of(12, 23, 44, 56, 67, 89, 99);


        long startTime = System.nanoTime();
        Split1(hockeyPlayers, 50);
        long endTime = System.nanoTime();
        long elapsedTime = endTime-startTime;
        System.out.println(elapsedTime);

        long startTime2 = System.nanoTime();
        Split2(hockeyPlayers, 50);
        long endTime2 = System.nanoTime();
        long elapsedTime2 = endTime-startTime;
        System.out.println(elapsedTime2);

        long startTime3 = System.nanoTime();
        Split3(hockeyPlayers, 50);
        long endTime3 = System.nanoTime();
        long elapsedTime3 = endTime-startTime;
        System.out.println(elapsedTime3);

    }


// Not sorted, so it's impossible to do it faster than O(n) cause you need to look at EACH element.
    public static void Split1(List<Integer> SR, int splitValue) {
        List<Integer> lower = new ArrayList<>();                       // 1
        List<Integer> higher = new ArrayList<>();                      // 1

        for (int i = 0; i < SR.size(); i++) {                          // 1 + (n+1) + 2n
            int thisSR = SR.get(i);                                    // n (1 read from array, 1 creation, 1 assignment)
            if (thisSR < splitValue) {                                 // n
                lower.add(thisSR);                                     // n
            }
        }

        for (int i = 0; i < SR.size(); i++) {                           // 1 + (n+1) + 2n
            int thisSR = SR.get(i);                                     // n
            if (thisSR >= splitValue) {                                 // n
                higher.add(thisSR);                                     // n
            }                                                           // Total: 12n + 6  --> O(n)
        }
    }




    public static void Split2(List<Integer> SR, int splitValue) {
        List<Integer> lower = new ArrayList<>();                        // 1
        List<Integer> higher = new ArrayList<>();                       // 1

        for (int i = 0; i < SR.size(); i++) {                           // 1 + (n+1) + 2n
            int thisSR = SR.get(i);                                     // n
            if (thisSR < splitValue) {                                  // n
                lower.add(thisSR);                                      // n
            } else {
                higher.add(thisSR);                                     // n
            }                                                           // Total: 7n + 4  --> O(n)
        }

    }




    // Given that SR is sorted, you can get O(log(n))! Binary search!
    // We have to find the first int that is at least splitValue; returned by binarySearch()
    public static void Split3(List<Integer> SR, int splitValue) {

        int splitIndex = binarySearch(SR, splitValue, 0, SR.size()-1);

            List<Integer> lower = SR.subList(0, splitIndex-1);              // c  (List.subList runs in O(1) time)
            List<Integer> higher = SR.subList(splitIndex, SR.size());       // c
        } //Total combined with call to binarySearch(): O(log(n))



    // returns splitIndex for Split3
    public static int binarySearch(List<Integer> SR, int splitValue, int low, int high) {

        if (low == high) {                                              // c
            return low;                                                 // c
        }
        int mid = (low + high)/2;                                       // c
        if (splitValue > SR.get(mid)) {                                 // c
            return binarySearch(SR, splitValue,mid+1, high);        //T(n/2)    cause you split the list in half
        } else {
            return binarySearch(SR, splitValue, low, mid);              //T(n/2)
        }                                                               // Total: O(log(n))! (after unfolding)


    }



}
