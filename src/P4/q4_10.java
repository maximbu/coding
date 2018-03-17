package P4;

import utils.BinTreeNode;

/**
 * Created by max on 12/24/2016.
 */
public class q4_10 {
    public static <T> boolean isSubTree1(BinTreeNode<T> bigger, BinTreeNode<T> smaller) {
        if (smaller == null) return true;
        if (bigger == null) return false;

        StringBuilder b = new StringBuilder();
        preOrderString(bigger, b);
        StringBuilder s = new StringBuilder();
        preOrderString(smaller, s);

        return b.toString().contains(s.toString());
    }


    public static <T> void preOrderString(BinTreeNode<T> root, StringBuilder st) {
        if (root == null) {
            st.append("NULL");
            return;
        }
        st.append(root.getVal());
        preOrderString(root.getLeft(), st);
        preOrderString(root.getRight(), st);
    }

    public static <T> boolean isSubTree2(BinTreeNode<T> bigger, BinTreeNode<T> smaller) {
        if (smaller == null) return true;
        if (bigger == null) return false;

        if (bigger == smaller && compareTrees(bigger, smaller)) {
            return true;
        }

        return isSubTree2(bigger.getLeft(), smaller) || isSubTree2(bigger.getRight(), smaller);
    }


    public static <T> boolean compareTrees(BinTreeNode<T> t1, BinTreeNode<T> t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;

        return (t1.getVal() == t2.getVal()) && compareTrees(t1.getLeft(), t2.getLeft()) && compareTrees(t1.getRight(), t2.getRight());
    }


    public static void main(String[] st) {

        BinTreeNode<Integer> n50 = new BinTreeNode<>(50);
        BinTreeNode<Integer> n20 = new BinTreeNode<>(20);
        BinTreeNode<Integer> n60 = new BinTreeNode<>(60);
        BinTreeNode<Integer> n10 = new BinTreeNode<>(10);
        BinTreeNode<Integer> n25 = new BinTreeNode<>(25);
        BinTreeNode<Integer> n70 = new BinTreeNode<>(70);
        BinTreeNode<Integer> n5 = new BinTreeNode<>(5);
        BinTreeNode<Integer> n15 = new BinTreeNode<>(15);
        BinTreeNode<Integer> n65 = new BinTreeNode<>(65);
        BinTreeNode<Integer> n80 = new BinTreeNode<>(80);

        n50.setLeft(n20);
        n50.setRight(n60);
        n20.setLeft(n10);
        n20.setRight(n25);
        n10.setLeft(n5);
        n10.setRight(n15);
        n60.setRight(n70);
        n70.setLeft(n65);
        n70.setRight(n80);

        boolean t;
        boolean f;

        t = isSubTree1(n20, n10);
        f = isSubTree1(n20, n70);
        t = isSubTree1(n60, n70);
        t = isSubTree1(n50, n70);
        f = isSubTree1(n10, n20);
        t = isSubTree1(n20, n20);

        t = isSubTree2(n20, n10);
        f = isSubTree2(n20, n70);
        t = isSubTree2(n60, n70);
        t = isSubTree2(n50, n70);
        f = isSubTree2(n10, n20);
        t = isSubTree2(n20, n20);

    }

}
