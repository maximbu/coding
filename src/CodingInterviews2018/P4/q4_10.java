package CodingInterviews2018.P4;

import CodingInterviews.utils.BinTreeNode;

public class q4_10 {

    private static <T> boolean isSubTree(BinTreeNode<T> t1, BinTreeNode<T> t2) {
        if (t1 == null)
            return t2 == null;
        if (areSame(t1, t2)) {
            return true;
        }
        return isSubTree(t1.getLeft(), t2) || isSubTree(t1.getRight(), t2);
    }

    private static <T> boolean areSame(BinTreeNode<T> t1, BinTreeNode<T> t2) {
        if (t1 == null)
            return t2 == null;
        if (t2 == null)
            return false;
        return t1.getVal().equals(t2.getVal()) && areSame(t1.getRight(), t2.getRight()) && areSame(
                t1.getLeft(), t2.getLeft());
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

        t = isSubTree(n20, n10);
        f = isSubTree(n20, n70);
        t = isSubTree(n60, n70);
        t = isSubTree(n50, n70);
        f = isSubTree(n10, n20);
        t = isSubTree(n20, n20);
    }

}
