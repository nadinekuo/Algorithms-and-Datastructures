import java.util.*;

class HashTableSepChain2 {

// Your implementation of these methods should NOT ALLOW NULL to be used as a key.

    public LinkedList<EntryS>[] table;         // SEPARATE CHAINING: LinkedLists as buckets
    public int capacity;

    /**
     * Constructs a new HashTable.
     * Capacity of the hash table can not be 0 or negative.
     * @param capacity
     *     to be used as capacity of the table.
     * @throws IllegalArgumentException
     *     if the input capacity is invalid.
     */
    @SuppressWarnings("unchecked")
    public HashTableSepChain2(int capacity) {
        this.capacity = capacity;
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be 1 or larger!");
        }
        table = new LinkedList[capacity];           // BUCKETS (LinkedLists) NOT INITIALIZED YET!
        System.out.println("New HashTable initialized with capacity " + capacity);
    }



    /**
     * Add a new Entry to the hash table,
     * uses separate chaining to deal with collisions.
     * Returns false, if the key is null.
     * @param key
     *     String representing the key of the entry.
     * @param value
     *     String representing the value of the entry.
     * @return true iff entry has been added successfully, else false.
     *      *     CASE 1: NEW KEY ADDED. -> INITIALIZE BUCKET (LinkedList)
     *      *     CASE 2: REPLACE EXISTING KEY.  <---- same key (thus same hashcode)!
     *      *     CASE 3: SEPARATE CHAINING. (collision)  <--- same hashcode (but not same key)!
     */
    public boolean put(String key, String value) {

        if (key == null || value == null) return false;

        EntryS newEntry = new EntryS(key, value);
        LinkedList<EntryS> bucket = table[hash(key)];       // where new entry should be added
        System.out.println("Index: " + hash(key));

        // IF KEY IS NEWLY ADDED
        if (bucket == null) {                                // buckets are initially null
            bucket = table[hash(key)] = new LinkedList<EntryS>();   // 2 assignments in 1
//            table[hash(key)] = new LinkedList<>();
//            bucket = table[hash(key)];
            System.out.println("New bucket initialized with new " + newEntry);
        }
        // CHECK IF KEY ALREADY EXISTS, ELSE JUST ADD TO BUCKET. (collision)
        Iterator<EntryS> iterator = bucket.iterator();      // YOU CAN'T REMOVE STUFF USING "for Entry e : bucket"

        while (iterator.hasNext()) {
            EntryS entry = iterator.next();
            if (entry.getKey().equals(key)) {
                iterator.remove();                      // YOU MUST use ITERATORS remove() method! If it's SNAPSHOT, its COPY has to be changed!
                System.out.println("Entry with existing key " + key + " replaced by " + newEntry);
                return true;
            }
        }
        bucket.add(newEntry);       // In all 3 cases, Entry has to be added to bucket.
       return true;
    }

    /**
     * Retrieve the VALUE of the entry associated with this key.
     * Returns null, if the key is null.
     * @param key
     *     String representing the key of the entry to look for.
     * @return value of the entry as String iff the entry with this key is found in the hash table, else null.
     */
    public String get(String key) {
        // if entry not found, return null
        if (key == null) return null;           // null keys NOT allowed!

        LinkedList<EntryS> bucket = table[hash(key)];     // bucket for this hashcode, containing entries with diff keys
        if (bucket == null) return null;                // bucket never initialized, thus empty.

        for (EntryS e : bucket) {
            if (e.getKey().equals(key)) {
                System.out.println("Get: Value " + e.getValue() + " of " + e);
                return e.getValue();
            }
        }
        System.out.println("Get(): Entry (key) not found.");
        return null;
    }

    /**
     * Remove the entry associated with this key from the hash table.
     * Returns false, if the key is null.
     * @param key
     *     String representing the key of the entry to remove.
     * @return true iff the entry has been successfully removed, else false.
     * CASE 1: BUCKET NEVER INITIALIZED.
     * CASE 2: KEY NOT IN BUCKET.
     * CASE 3: KEY IS IN BUCKET --> remove Entry
     */
    public boolean remove(String key) {

        if (key == null) return false;            // null keys NOT allowed!

        LinkedList<EntryS> bucket = table[hash(key)];
        if (bucket == null) return false;            // if bucket never initialized, thus empty

        Iterator<EntryS> iterator = bucket.iterator();      // YOU CAN'T REMOVE STUFF USING "for Entry e : bucket"

        while (iterator.hasNext()) {
            EntryS entry = iterator.next();
            if (entry.getKey().equals(key)) {
                iterator.remove();                          // YOU MUST use ITERATORS remove() method! If it's SNAPSHOT, its COPY has to be changed!
                System.out.println("Removed: " + entry);
                return true;
            }
        }

        System.out.println("Entry could not be removed (key not found)");
        return false;       // Entry with this key not found
    }

    /**
     * Hashes a string representing a key
     * @param key
     *     String that needs to be hashed.
     * @return the hashcode of the string, modulo the capacity of the HashTable.
     */
    public int hash(String key) {
        return Math.abs(key.hashCode()) % capacity;
    }
}