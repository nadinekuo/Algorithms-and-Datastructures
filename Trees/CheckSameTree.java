

public class CheckSameTree {


    public boolean isSameTree(TreeNode p, TreeNode q) {

        // p and q are both null
        if (p == null && q == null) return true;
        // one of p and q is null
        if (q == null || p == null) return false;
        if (p.getKey() != q.getKey()) return false;

        return isSameTree(p.getRight(), q.getRight()) &&
                isSameTree(p.getLeft(), q.getLeft());
    }


    public boolean isSameTree2(TreeNode p, TreeNode q) {

        // base cases
        if (p == null && q == null) return true;
        if (p == null && q != null || q == null && p != null) return false;

        if (p.getKey() == q.getKey()
                && isSameTree(p.getLeft(), q.getLeft()) && (isSameTree(p.getRight(), q.getRight()))) return true;

        return false;

    }

}
