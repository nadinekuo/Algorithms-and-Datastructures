import java.util.Arrays;

class MultiwaySearchTree1 {

    int[] keys;                         // each node is an array of keys

    MultiwaySearchTree1[] children;      // each node stores an array of sub-MultiwaySearchTree children

    public MultiwaySearchTree1(int[] keys, MultiwaySearchTree1[] children) {
        this.keys = keys;
        this.children = children;
    }

    public int[] getKeys() {
        return keys;
    }

    public MultiwaySearchTree1[] getChildren() {
        return children;
    }

    @Override
    public String toString() {
        return "MultiwaySearchTree{" + "keys=" + Arrays.toString(keys) + '}';
    }

}