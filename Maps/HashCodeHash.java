class HashCodeHash extends HashTableSepChain {

    public HashCodeHash(int size) {
        super(size);
    }

    @Override
    public int hash(String item) {
        if (item == null) return 0;
        int hash = item.hashCode();
        if (hash < 0) {
            hash = Math.abs(hash);  // make positive, if negative
        }
        int compressed = hash % this.getCapacity(); // compress to put in right range
        return compressed;
    }
}