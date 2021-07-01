
class GNUCPPHash extends HashTableSepChain {

    public GNUCPPHash(int size) {
        super(size);
    }

    // bn & bitmask (AND) will filter out

    @Override
    public int hash(String item) {

        if (item == null) return 0;
        int bn = 0;                     // starting value hashcode

        for (int i = 0; i < item.length(); i++) {
            int ci = item.charAt(i);
            bn = 4 * bn + ci;
        }
        // int is 32 bits, so shift L and R by 1
        int left = bn << 1;             // last 31 bits in leftmost position
        int right = left >>> 1;         // last 31 bits in rightmost position
        // use >>> to add 0's in front! >> is for signed ints! (adds 1 in front if < 0)
        int compressed = right % this.getCapacity();
        return compressed;
    }
}