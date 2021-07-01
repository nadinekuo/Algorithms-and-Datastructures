import java.util.*;

class MultiMap {

    // "this" refers to the Multimap, "map" refers to the Hashmap!!!
    // (search) KEYS NOT UNIQUE.
    // 1 key can map to multiple values! (Thus same hashcode)

    // ALLOWS DUPLICATE (K, V) PAIRS!!
    // no null values

    // Each Key (at an index) holds list of int values
    private Map<Integer, List<Integer>> map; // Key: int
    private int size = 0;

    /**
     * Creates a new MultiMap. (as hashMap)
     *  default initial cap = 16
     *  load factor = 0.75
     */
    public MultiMap() {
        map = new HashMap<>();
    }

    /**
     * @return The number of (key, value) pairs in the MultiMap.
     * ALL Entries in ALL lists of the multi-hashMap!!!
     * For the HashMap, each List IS the Value
     * but for our Multimap, the List CONTAINS the values!!!
     * So add private field size
     */
    public int size() {
        return size;
    }

    /**
     * @return True if the MultiMap is empty, false otherwise.
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Adds the given (key, value) pair to the MultiMap.
     * @param key Key for the new item.
     * @param value New item to add to the MultiMap.
     */
    public void put(int key, int value) {
        if (map.get(key) == null) {                 // no List instantiated yet
            List<Integer> newbucket = new ArrayList<>();
            newbucket.add(value);
            map.put(key, newbucket);                 // adds new List belonging to key + Value
        } else {
            List<Integer> bucket = this.get(key);
            bucket.add(value);                 // else add Value to List
        }
        size++;
    }

    /**
     * Returns all associated values in the MultiMap for the given key. (LIST)
     *
     * @param key Key to return all entries for.
     * @return A list of all entries for the given key.
     *         If the key is not in the map, return an empty list.
     */
    public List<Integer> get(int key) {
        if (map.get(key) == null) {        // no mapping for this key (List is null)
            List<Integer> empty = new ArrayList<>();
            return empty;
        }
        return map.get(key);
    }

    /**
     * Removes the given (key, value) pair from the MultiMap.
     *
     * @param key Key for the value that should be removed.
     * @param value Value to remove.
     * @return True if removal was successful, false otherwise.
     * BOTH KEY and VALUE should exist in the multi-map
     */
    public boolean remove(int key, int value) {
        if (map.get(key) == null || !map.containsKey(key)) {        // no mapping for this key exists
            return false;
        }
        List<Integer> bucket = map.get(key);   // remove value from LIST
        // Check if VALUE is in LIST!
        if (bucket.contains(value)) {
            bucket.remove(Integer.valueOf(value));  // List has 2 remove methods!!!
            size--;
            return true;
        }
        return false;
    }
}

