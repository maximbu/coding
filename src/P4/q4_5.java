package P4;

import utils.BinTreeNode;

import static P4.q4_2.createMinimalBST;

/**
 * Created by max on 12/23/2016.
 */
public class q4_5 {
    public static  boolean isBST (BinTreeNode<Integer> t) {
        return isBST(t,null,null);
    }

    public static  boolean isBST (BinTreeNode<Integer> t,Integer min,Integer max) {
        if (t == null)
            return true;
        if (min != null && t.getVal() <= min)
            return false;
        if (max != null && t.getVal() > max)
            return false;
        return isBST(t.getLeft(),min,t.getVal()) && isBST(t.getRight(),t.getVal(),max);
    }

    public static void main(String[] st){
        int[] array = new int[27];
        for (int i = 0; i < 27; i++) {
            array[i] = i;
        }
        BinTreeNode<Integer> tree = createMinimalBST(array);
        boolean t = isBST(tree);
        BinTreeNode<Integer> left = new BinTreeNode<>(28);
        tree.setLeft(left);
        left.setLeft(new BinTreeNode<>(29));
        boolean f = isBST(tree);

        BinTreeNode<Integer> n20 = new BinTreeNode<>(20);
        BinTreeNode<Integer> n10 = new BinTreeNode<>(10);
        BinTreeNode<Integer> n30 = new BinTreeNode<>(30);
        BinTreeNode<Integer> n25 = new BinTreeNode<>(25);

        n20.setLeft(n10);
        n20.setRight(n30);
        n10.setRight(n25);
        f = isBST(n20);

    }


}
