package CodingInterviews2018.P4;

import CodingInterviews.utils.BinTreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class q4_9 {
    private static List<List<Integer>> printAllBST(BinTreeNode<Integer> root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            list.add(new LinkedList<>());
            return list;
        }
        var left = printAllBST(root.getLeft());
        var right = printAllBST(root.getRight());
        for (List<Integer> leftList : left) {
            for (List<Integer> rightList : right) {
                var prefix = new ArrayList<Integer>();
                prefix.add(root.getVal());
                var tmpRes = combineLists(leftList, rightList, prefix);
                list.addAll(tmpRes);
            }
        }
        return list;
    }

    private static List<List<Integer>> combineLists(List<Integer> l1, List<Integer> l2, List<Integer> prefix) {
        if (l1.isEmpty() || l2.isEmpty()) {
            return handleEmptyList(l1, l2, prefix);
        }

        List<List<Integer>> ans = new ArrayList<>();

        ans.addAll(moveFirstToPrefix(l1, l1, l2, prefix));
        ans.addAll(moveFirstToPrefix(l2, l1, l2, prefix));
        return ans;
    }

    private static List<List<Integer>> handleEmptyList(List<Integer> l1, List<Integer> l2, List<Integer> prefix) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> newRes = new LinkedList<>(prefix);
        newRes.addAll(l1);
        newRes.addAll(l2);
        ans.add(newRes);
        return ans;
    }

    private static List<List<Integer>> moveFirstToPrefix(List<Integer> removeFrom, List<Integer> l1, List<Integer> l2, List<Integer> prefix) {
        Integer h = removeFrom.remove(0);
        prefix.add(h);
        var ans = combineLists(l1, l2, prefix);
        prefix.remove(prefix.size() - 1);
        removeFrom.add(0, h);
        return ans;
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

        var a = printAllBST(n50);
        System.out.println(a.size());
        for (var list : a) {
            System.out.println(list);
        }

    }
}
