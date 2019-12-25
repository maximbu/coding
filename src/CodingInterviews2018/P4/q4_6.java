package CodingInterviews2018.P4;

import CodingInterviews.utils.ParentBinTreeNode;

public class q4_6 {
    private static ParentBinTreeNode<Integer> successor(ParentBinTreeNode<Integer> node) {
        if (node.getRight() == null) {
            var parent = node.getParent();
            while (parent != null) {
                if (parent.getLeft() == node) {
                    break;
                }
                node = parent;
                parent = parent.getParent();
            }
            return parent;
        }
        node = node.getRight();
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        return node;
    }


    public static void main(String[] st) {
        ParentBinTreeNode<Integer> n20 = new ParentBinTreeNode<>(20);
        ParentBinTreeNode<Integer> n8 = new ParentBinTreeNode<>(8);
        ParentBinTreeNode<Integer> n22 = new ParentBinTreeNode<>(22);
        ParentBinTreeNode<Integer> n4 = new ParentBinTreeNode<>(4);
        ParentBinTreeNode<Integer> n12 = new ParentBinTreeNode<>(12);
        ParentBinTreeNode<Integer> n10 = new ParentBinTreeNode<>(10);
        ParentBinTreeNode<Integer> n14 = new ParentBinTreeNode<>(14);
        n20.setLeft(n8);
        n20.setRight(n22);
        n8.setLeft(n4);
        n8.setRight(n12);
        n12.setLeft(n10);
        n12.setRight(n14);
        ParentBinTreeNode<Integer> e20 = successor(n14);
        ParentBinTreeNode<Integer> e22 = successor(n20);
        ParentBinTreeNode<Integer> e12 = successor(n10);
        ParentBinTreeNode<Integer> e10 = successor(n8);

    }

}
