

//* USED IN ARITHMETIC TREE.

abstract public class AbstractNode<T> {

    protected T val;

    public T getVal() {
        return val;
    }
    public void setVal(T v) {
        val = v;
    }
    public abstract boolean isLeaf();

}
