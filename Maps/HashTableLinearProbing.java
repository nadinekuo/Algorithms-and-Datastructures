import java.util.*;

public class HashTableLinearProbing {

    public EntryS[] table;
    public int capacity;

    /**
     * Constructs a new HashTable. --> LINEAR PROBING! (NULL KEYS NOT ALLOWED.)
     * Capacity of the hash table can not be 0 or negative.
     * @param capacity
     *     to be used as capacity of the table.
     * @throws IllegalArgumentException
     *     if the input capacity is invalid.
     */
    public HashTableLinearProbing(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be at least 1!");
        }
        this.capacity = capacity;
        table = new EntryS[capacity];
    }


    /**
     * Is available? Is the cell either EMPTY or marked by DEFUNCT. (Entry with K/V null)
     * @param hash - index calculated by hash function
     * @return the boolean - true/false
     */
    public boolean isAvailable(int hash) {
        return (table[hash] == null || table[hash].getKey() == null);
    }



    /**
     * Is the hash table full? All cells occupied!! (rehash? --> resize?)
     * @return the boolean - true/false
     */
    public boolean isFull() {
        for (int i = 0; i < table.length; i++) {
            if (table[i] == null || table[i].getKey() == null) {
                return false;                                       // If 1 empty cell/DEFUNCT found
            }
        }
        return true;
    }


    /**
     * FINDS SLOT. ---> used for get(), put(), remove()
     *         GET(): probe from h(k) until NULL/empty cell, continue at DEFUNCT.
     *         PUT(): inserted at 1st available cell (avail)
     *         REMOVE(): probe from h(k) until key matches; to remove.
     * @param hashidx - index calculated by hash function
     * @return int - which is either negative (< 0) or positive (>= 0).
     *      1.  current           <-- idx where matching key found (returned by get()/removed by remove())
     *      2. -(avail + 1)   <--- search failed, but avail is FIRST available idx (empty/DEFUNCT) (insertion put())
     *      Add - in front, so we know search failed!
     *      Add 1, bc otherwise 0 would be positive!!
     */
    public int linearProbing(int hashidx, String key) {

        int avail = -1;             // initial value
        int currentidx = hashidx;

        do {
            if (isAvailable(currentidx)) {             // Empty or DEFUNCT (must be reached at a point, else the table is full!)
                if (avail == -1) avail = currentidx;   // <--- assigned 1x only! So avail holds the FIRST free cell.
                if (table[currentidx] == null) break;   // STOP searching at NULL (but continue at DEFUNCT)
            } else if (table[currentidx].getKey().equals(key)) return currentidx;     // KEY MATCH FOUND (idx returned)!
            currentidx = (currentidx+1) % capacity;                 // continue probing, try (h(k)+1) % N, (h(k)+2) % N,...
        } while (currentidx != hashidx);               // until we arrive at starting idx again.
        return -(avail+1);              // avail is FIRST free cell for put().

    }

    /**
     * Add a new Entry to the hash table,
     * uses linear probing to deal with collisions.
     * Returns false, if the key is null or the TABLE IS FULL.
     * @param key
     *     String representing the key of the entry.
     * @param value
     *     String representing the value of the entry.
     * @return true iff entry has been added successfully, else false.
     *  1. if KEY EXISTS, replace value.
     *  2. If NEW KET: Insert at FIRST available; if occupied by ANOTHER KEY, try (h(k)+1) % N, (h(k)+2) % N,... --> until empty cell or DEFUNCT
     */
    public boolean put(String key, String value) {
        if (key == null || isFull()) return false;
        int index = linearProbing(hash(key), key);
        EntryS newEntry = new EntryS(key, value);

        // if KEY EXISTS, replace value.
        if (index >= 0) {
            table[index] = newEntry;            // replace old Entry (existing key)
        } else {                // If NEW KEY: insert at FIRST available: empty/DEFUNCT
            table[-(index+1)] = newEntry;       // convert to proper index! (make positive again)
        }
        return true;
    }

    /**
     * Retrieve the value of the entry associated with this key.
     * Returns null, if the key is null.
     * @param key
     *     String representing the key of the entry to look for.
     * @return value of the entry as String iff the entry with this key is found in the hash table, else null.
     * STOP PROBING AT EMPTY CELL, CONTINUE AT DEFUNCT.
     */
    public String get(String key) {
        if (key == null) return null;
        int index = linearProbing(hash(key), key);
        if (index < 0) return null;     // entry not found
        return table[index].getValue(); // index where matching key was found
    }

    /**
     * Remove the entry associated with this key from the hash table.
     * Returns false, if the key is null.
     * @param key
     *     String representing the key of the entry to remove.
     * @return true iff the entry has been successfully removed, else false.
     * linearProbing() returns currentIndex (POSITIVE) if key match found <-- entry to remove
     *                  returns NEGATIVE idx if key not found.
     */
    public boolean remove(String key) {
        if (key == null) return false;
        int index = linearProbing(hash(key), key);
        if (index < 0) return false;                  // key not found
        setDefunct(index);                          // SET DEFUNCT. (thus removed)
        return true;
    }

    /**
     * Takes as input an index and sets the entry in that location as defunct.
     * @param index
     *     The index of the spot that is defunct.
     */
    public void setDefunct(int index) {
        this.table[index] = new EntryS(null, null);
    }

    /**
     * Hashes a string representing a key.
     *
     * @param key
     *     String that needs to be hashed.
     * @return the hashcode of the string, modulo the capacity of the HashTable.
     */
    public int hash(String key) {
        return Math.abs(key.hashCode()) % capacity;
    }

}
