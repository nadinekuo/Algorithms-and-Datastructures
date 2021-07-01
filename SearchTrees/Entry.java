

class Entry {
    public final int key;
    public final int value;

    public Entry(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public String toString() {
        return "< Entry: KEY " + key + ", VALUE " + value;
    }
}