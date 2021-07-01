import java.util.ArrayList;
import java.util.List;

public class CardShuffle {

    /**
     * Shuffles a deck of cards. This is done by splitting the existing deck into two halves, L1 and L2.
     * The two halves will be merged back together by taking alternating elements from L1 and L2.
     * Where the order is as follows:
     * first element of L1, first element of L2, second element of L1, second element of L2, and so forth.
     * 2n elements so ALWAYS EVEN NUMBER :)
     * @param deck
     * @return
     */
    public static List<Card> cardShuffle(List<Card> deck) {
        List<Card> half1 = new ArrayList<>();
        List<Card> half2 = new ArrayList<>();

        int n = deck.size();

        for (int i = 0; i < n/2; i++) {
            half1.add(deck.get(i));
            half2.add(deck.get(n/2+i));
        }
        List<Card> result = new ArrayList<>();
        for (int i = 0; i < n/2; i++) {
            result.add(half1.get(i));
            result.add(half2.get(i));
        }
        return result;
    }

}
