
class GNUCC1Hash extends HashTableSepChain {

    public GNUCC1Hash(int size) {
        super(size);
    }

    @Override
    public int hash(String item) {

        if (item == null) return 0;
        int bn = item.length();                     // starting value hashcode

        for (int i = 0; i < item.length(); i++) {
            int ci = item.charAt(i);
            bn = 613 * bn + ci;
        }
        // int is 32 bits, so shift L and R by 2
        int left = bn << 2;             // last 30 bits in leftmost position
        int right = left >>> 2;         // last 30 bits in rightmost position
        // use >>> to add 0's in front! >> is for signed ints! (adds 1 in front if negative)
        int compressed = right % this.getCapacity();
        return compressed;
    }

}
