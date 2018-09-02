package CodingInterviews2018.P4;

import CodingInterviews.utils.BinTreeNode;
import java.util.HashMap;

public class q4_12 {

    private static int pathsWithSum(BinTreeNode<Integer> root, int sum) {
        if (root == null)
            return 0;
        return pathsWithSumFromNode(root, sum)
                + pathsWithSum(root.getLeft(), sum)
                + pathsWithSum(root.getRight(), sum);
    }


    private static int pathsWithSumFromNode(BinTreeNode<Integer> root, int sum) {
        if (root == null)
            return 0;

        int leftSum = sum - root.getVal();
        return (root.getVal() == sum ? 1 : 0)
                + pathsWithSumFromNode(root.getLeft(), leftSum)
                + pathsWithSumFromNode(root.getRight(), leftSum);
    }

    private static int pathsWithSumOpt(BinTreeNode<Integer> root, int sum) {
        return pathsWithSumOpt(root, sum,0,  new HashMap<>());
    }

    private static int pathsWithSumOpt(BinTreeNode<Integer> node, int sum, int sumSoFar,
            HashMap<Integer, Integer> map) {
        if (node == null)
            return 0;

        sumSoFar += node.getVal();

        int paths = map.getOrDefault(sumSoFar - sum, 0);
        if (sumSoFar == sum) {
            paths++;
        }
        map.put(sumSoFar, map.getOrDefault(sumSoFar, 0) + 1);
        paths += pathsWithSumOpt(node.getLeft(), sum, sumSoFar, map);
        paths += pathsWithSumOpt(node.getRight(), sum, sumSoFar, map);
        map.put(sumSoFar, map.getOrDefault(sumSoFar, 0) - 1);
        return paths;
    }


    public static void main(String[] st) {

        BinTreeNode<Integer> n10 = new BinTreeNode<>(10);
        BinTreeNode<Integer> n5 = new BinTreeNode<>(5);
        BinTreeNode<Integer> nm3 = new BinTreeNode<>(-3);
        BinTreeNode<Integer> n3 = new BinTreeNode<>(3);
        BinTreeNode<Integer> n2 = new BinTreeNode<>(2);
        BinTreeNode<Integer> n11 = new BinTreeNode<>(11);
        BinTreeNode<Integer> n3b = new BinTreeNode<>(3);
        BinTreeNode<Integer> nm2 = new BinTreeNode<>(-2);
        BinTreeNode<Integer> n1 = new BinTreeNode<>(1);

        n10.setLeft(n5);
        n10.setRight(nm3);
        n5.setLeft(n3);
        n5.setRight(n2);
        nm3.setRight(n11);
        n3.setLeft(n3b);
        n3.setRight(nm2);
        n2.setRight(n1);

        int cnt = pathsWithSum(n10, 8);
        cnt =  pathsWithSumOpt(n10, 8);

    }

}
