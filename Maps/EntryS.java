public class EntryS {

    private String key;
    private String value;

    public EntryS(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public String toString() {
        return "Entry: Key: <" + key + ", Value: " + value + ">";
    }

}
