class ETHHash extends HashTableSepChain {

    // KEY IS A STRING.


    public ETHHash(int size) {
        super(size);
    }

    @Override
    // @return the hashcode of the string, modulo the capacity of the HashTable.
    public int hash(String item) {

        if (item == null) return 0;
        int bn = 1;                     // starting value hashcode

        for (int i = 0; i < item.length(); i++) {
            int ci = item.charAt(i);            // char value
            bn = ci * ((bn % 257) + 1);        // intermediate values hashcode get updated
        }

        int compressed = bn % this.getCapacity();
        return compressed;
    }
}