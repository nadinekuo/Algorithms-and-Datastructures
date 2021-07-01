import java.util.Comparator;

public class EntryLetter implements Comparable<EntryLetter> {

    private int key;
    private char element;

    public EntryLetter(int key, char element) {
        this.key = key;
        this.element = element;
    }

    public int getKey() {
        return this.key;
    }

    public char getElement() {
        return this.element;
    }

    @Override
    public int compareTo(EntryLetter other) {
        // Used to sort the entries in descending order
        return other.getKey() - this.getKey();
    }

}
