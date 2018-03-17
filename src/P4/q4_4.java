package P4;

import utils.BinTreeNode;

import static P4.q4_2.createMinimalBST;

/**
 * Created by max on 12/23/2016.
 */
public class q4_4 {
    public static <T> boolean isBalanced(BinTreeNode<T> t) {
        if (t == null)
            return true;
        int len = 1;
        BinTreeNode<T> l = t;
        while (l != null) {
            l = l.getLeft();
            len++;
        }
        return isBalanced(t, len);
    }


    private static <T> boolean isBalanced(BinTreeNode<T> t, int n) {
        if (t == null) {
            return n <= 1;
        }
        if (n == -1) {
            return t.getLeft() == null && t.getRight() == null;
        }
        return isBalanced(t.getLeft(), n - 1) && isBalanced(t.getRight(), n - 1);

    }

    public static void main(String[] st) {
        int[] array = new int[27];
        for (int i = 0; i < 27; i++) {
            array[i] = i;
        }
        BinTreeNode<Integer> tree = createMinimalBST(array);
        BinTreeNode<Integer> left = new BinTreeNode<Integer>(28);
        tree.setLeft(left);
        left.setLeft(new BinTreeNode<Integer>(29));
        boolean b = isBalanced(tree);
    }


}
