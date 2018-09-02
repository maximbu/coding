package CodingInterviews2018.P4;

import static CodingInterviews2018.P4.q4_2.minimalTree;

import CodingInterviews.utils.BinTreeNode;

public class q4_4 {
    private static <T> boolean checkBalanced(BinTreeNode<T> t)
    {
        return checkBalancedRec(t) != -1;
    }

    private static <T> int checkBalancedRec(BinTreeNode<T> t){
        if(t == null) return 0;
        int left = checkBalancedRec(t.getLeft());
        int right = checkBalancedRec(t.getRight());
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        }
        return 1+Math.max(left,right);
    }



    public static void main(String[] st) {

        int[] array = new int[27];
        for (int i = 0; i < 27; i++) {
            array[i] = i;
        }
        var tree = minimalTree(array);
        boolean b = checkBalanced(tree);
        var left = new BinTreeNode<>(28);
        tree.setLeft(left);
        left.setLeft(new BinTreeNode<>(29));
        b = checkBalanced(tree);

        var root = new BinTreeNode<>(1);
        left = new BinTreeNode<>(2);
        root.setLeft(left);
         b = checkBalanced(root);

        var leftLeft = new BinTreeNode<>(3);
        left.setLeft(leftLeft);
        b = checkBalanced(root);

        var right = new BinTreeNode<>(4);
        root.setRight(right);
        b = checkBalanced(root);

        var leftLeftLeft = new BinTreeNode<>(5);
        leftLeft.setLeft(leftLeftLeft);
        b = checkBalanced(root);
    }
}
