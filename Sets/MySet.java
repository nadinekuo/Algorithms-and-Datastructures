import java.util.HashSet;
import java.util.Iterator;

class MySet extends HashSet<String> {

    private static final long serialVersionUID = 1L;

    public MySet() {
        super();
    }

    /**
     * @return the union of the elements of this and that
     */
    public MySet union(MySet that) {
        MySet result = new MySet();
        if (that == null) {

        }
        result.addAll(this);        // automatically ignores duplicates
        result.addAll(that);
        return result;
    }

    /**
     * @return the intersection of the elements of this and that
     */
    public MySet intersection(MySet that) {
        MySet result = new MySet();
        if (that == null) return result;
        this.retainAll(that);
        result.addAll(this);
        return result;
    }

    /**
     * @return the difference of the elements of this and that
     */
    public MySet difference(MySet that) {
        if (that == null) return this;
        MySet result = new MySet();
        this.removeAll(that);
        result.addAll(this);
        return result;
    }

    /**
     * @return the exclusive or (XOR) of the elements of this and that
     * all elements in this and that, excl. elements which are in both
     */
    public MySet exclusiveOr(MySet that) {
        if (that == null) return this;
        MySet result = new MySet();
        for (String s : this) {
            if (!that.contains(s)) {
                result.add(s);
            }
        }
        for (String s : that) {
            if (!this.contains(s)) {
                result.add(s);
            }
        }
        return result;
    }


    /**
     * @return a String representation of a MySet object
     * You cANT retrieve elements in a Set, so use iterator!!
     */
    public String toString() {
        Iterator<String> scanner = this.iterator();
        String res = "<MySet{";
        while (scanner.hasNext()) {
            res += scanner.next();
            if (scanner.hasNext()) res += ",";
        }
        res += "}>";
        return res;
    }
}