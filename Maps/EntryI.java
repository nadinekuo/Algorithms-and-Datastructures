/**
 * Entry objects are used to represent "Key-Value" pairs.
 * An entry can be created by using new Entry(String key, Integer Value)
 * The .equals() method of Entry will compare the keys only.
 */
class EntryI {
    public final String key;
    public final Integer value;

    public EntryI(String s, Integer v) {
        key = s;
        value = v;
    }

    public boolean equals(String s) {
        return s == null && key == null || key.equals(s);
    }

    @Override
    public boolean equals(Object o) {
        return this == o || o != null && getClass() == o.getClass() && this.equals(((EntryI) o).key);
    }

    public String getKey() {
        return key;
    }

    public int getValue() {
        return value;
    }
}