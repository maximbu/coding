package CodingInterviews2018.P4;

import static CodingInterviews2018.P4.q4_2.minimalTree;

import CodingInterviews.utils.BinTreeNode;
import java.util.stream.IntStream;

public class q4_5 {
    private static boolean validateBST(BinTreeNode<Integer> t) {
        if (t == null)
            return true;
        if (t.getLeft() != null && t.getVal() < t.getLeft().getVal()
                || t.getRight() != null && t.getVal() > t.getRight().getVal()) {
            return false;
        }
        return validateBST(t.getLeft()) && validateBST(t.getRight());
    }

    public static void main(String[] st){
        int[] array = IntStream.range(0, 27).toArray();
        BinTreeNode<Integer> tree = minimalTree(array);
        boolean t = validateBST(tree);
        BinTreeNode<Integer> left = new BinTreeNode<>(28);
        tree.setLeft(left);
        left.setLeft(new BinTreeNode<>(29));
        boolean f = validateBST(tree);

        BinTreeNode<Integer> n20 = new BinTreeNode<>(20);
        BinTreeNode<Integer> n10 = new BinTreeNode<>(10);
        BinTreeNode<Integer> n30 = new BinTreeNode<>(30);
        BinTreeNode<Integer> n25 = new BinTreeNode<>(25);

        n20.setLeft(n10);
        n20.setRight(n30);
        n10.setRight(n25);
        f = validateBST(n20);

    }


}
