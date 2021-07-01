import java.util.LinkedList;

abstract class HashTableSepChain {

    protected LinkedList<EntryI>[] myTable;      // array of LinkedLists

    // Collision scheme: SEPARATE CHAINING
    // THIS IS NOT A MULTIMAP, as 1 key maps to 1 value.
    // 1 LinkedLists holds entries with same hashCode, but different keys!


    /**
     * Constructs a new HashTable.
     * SHOULD ALLOW keys that are NULL to be added to the table
     * @param capacity
     *     to be used as capacity of the table.
     * @throws IllegalArgumentException
     *     if the input capacity is invalid.
     */
    @SuppressWarnings("unchecked")
    public HashTableSepChain(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException();
        }
        myTable = new LinkedList[capacity];
    }

    /**
     * Add a key value pair to the HashTable.
     * @param key
     *     to identify the value.
     * @param value
     *     that is identified by the key.
     *     CASE 1: NEW KEY ADDED. -> INITIALIZE BUCKET (LinkedList)
     *     CASE 2: REPLACE EXISTING KEY.  <---- same key (thus same hashcode)!
     *     CASE 3: SEPARATE CHAINING. (collision)  <--- same hashcode (but not same key)!
     */
    public void put(String key, Integer value) {
        EntryI newentry = new EntryI(key, value);
        LinkedList<EntryI> bucket = myTable[hash(key)];       // where new entry should be added
       // IF KEY IS NEWLY ADDED
        if (bucket == null) {                                // buckets are initially null
            bucket = myTable[hash(key)] = new LinkedList<EntryI>();     // 2 assignments in 1
//            myTable[hash(key)] = new LinkedList<>();
//            bucket = myTable[hash(key)];
        }
        // IF KEY ALREADY EXISTS
        if (bucket.contains(newentry)) {        // ONLY KEY IS COMPARED (see Equals method)!
            bucket.remove(newentry);              // remove existing entry and add new one, so value replaced essentially
        }
        bucket.add(newentry);                   // in all 3 cases: add to bucket!
    }

    /**
     * @param key
     *     to look for in the HashTable.
     * @return true iff the key is in the HashTable.
     */
    public boolean containsKey(String key) {
        LinkedList<EntryI> bucket = myTable[hash(key)];
        if (bucket == null) {
            return false;
        }
        EntryI e = new EntryI(key, null);
        return bucket.contains(e);              // only key is compared! So it doesn't matter what V is.
    }

    /**
     * Get a value from the HashTable.
     * @param key
     *     that identifies the value.
     * @return the value associated with the key or `null` if the key is not in the HashTable.
     */
    public Integer get(String key) {
        if (!containsKey(key)) return null;
        LinkedList<EntryI> bucket = myTable[hash(key)];     // bucket for this hashcode, containing entries with diff keys
        for (EntryI e : bucket) {
            if (e.getKey() == null && key == null || e.getKey().equals(key)) {  // null keys allowed!
                return e.getValue();
            }
        }
        return null;
    }

    /**
     * @return the capacity of the HashTable.
     */
    public int getCapacity() {
        return myTable.length;
    }

    /**
     * Hashes a string/key.
     * TO DETERMINE WHERE AN ENTRY SHOULD BE PUT. (doesn't have to be implemented)
     * @param item
     *     to hash.
     * @return the hashcode of the string, modulo the capacity of the HashTable.
     */
    public abstract int hash(String item);

}
