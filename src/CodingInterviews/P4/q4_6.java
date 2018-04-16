package CodingInterviews.P4;

import CodingInterviews.utils.ParentBinTreeNode;

/**
 * Created by max on 12/23/2016.
 */
public class q4_6 {
    public static <T> ParentBinTreeNode<T> successor (ParentBinTreeNode<T> t) {
        if (t == null)
            return null;
        if (t.getRight() != null) {
            return getLeftMostNode(t.getRight());
        }
        ParentBinTreeNode<T> p = t.getParent();
        while (p != null && t == p.getRight()) {
            t = p;
            p = p.getParent();
        }
        return p;
    }

    private static <T> ParentBinTreeNode<T> getLeftMostNode(ParentBinTreeNode<T> currNode) {
        if(currNode == null)
            return null;
        while (currNode.getLeft() != null) {
            currNode = currNode.getLeft();
        }
        return currNode;
    }

    public static void main(String[] st){
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
