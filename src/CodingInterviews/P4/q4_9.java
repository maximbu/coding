package CodingInterviews.P4;

import CodingInterviews.utils.BinTreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by max on 12/24/2016.
 */
public class q4_9 {
    public static ArrayList<LinkedList<Integer>> printAllBST(BinTreeNode<Integer> root) {
        ArrayList<LinkedList<Integer>> list = new ArrayList<>();
        if (root == null) {
            list.add(new LinkedList<>());
            return list;
        }
        LinkedList<Integer> prefix = new LinkedList<>();
        prefix.add(root.getVal());
        ArrayList<LinkedList<Integer>> leftSeq = printAllBST(root.getLeft());
        ArrayList<LinkedList<Integer>> rightSeq = printAllBST(root.getRight());
        for (List<Integer> leftList : leftSeq) {
            for (List<Integer> rightList : rightSeq) {
                ArrayList<LinkedList<Integer>> tmpRes = new ArrayList<>();
                combineLists(leftList, rightList, prefix, tmpRes);
                list.addAll(tmpRes);
            }
        }
        return list;
    }

    private static void combineLists(List<Integer> l1, List<Integer> l2, LinkedList<Integer> prefix, ArrayList<LinkedList<Integer>> res) {
        if (l1.isEmpty() || l2.isEmpty()) {
            LinkedList<Integer> newRes = (LinkedList<Integer>) prefix.clone();
            newRes.addAll(l1);
            newRes.addAll(l2);
            res.add(newRes);
            return;
        }
        moveFirstToPrefex(l1, l1, l2, prefix, res);
        moveFirstToPrefex(l2, l1, l2, prefix, res);
    }

    private static void moveFirstToPrefex(List<Integer> removeFrom, List<Integer> l1, List<Integer> l2, LinkedList<Integer> prefix, ArrayList<LinkedList<Integer>> res) {
        Integer h = removeFrom.remove(0);
        prefix.add(h);
        combineLists(l1, l2, prefix, res);
        prefix.removeLast();
        removeFrom.add(0, h);
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

        ArrayList<LinkedList<Integer>> a = printAllBST(n50);
        System.out.println(a.size());
        for (LinkedList<Integer> list : a) {
            System.out.println(list);
        }

    }

}
