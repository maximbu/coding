package specificCompPrep;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ZigZagLevelPrint {

    public static void printAsZigZag(TreeNode<Integer> head) {
        boolean forward = true;
        TreeNode<Integer> EMPTY = new TreeNode<>(-1);
        Queue<TreeNode<Integer>> q = new LinkedList<>();
        Stack<TreeNode<Integer>> s = new Stack<>();
        q.add(head);
        q.add(EMPTY);
        while (!q.isEmpty()) {
            TreeNode<Integer> g = q.remove();
            if (g != EMPTY) {
                if (g.getLeft() != null) {
                    q.add(g.getLeft());
                }
                if (g.getRight() != null) {
                    q.add(g.getRight());
                }
                if (forward) {
                    System.out.print(g.getData() + " ");
                } else {
                    s.push(g);
                }
            } else {
                forward = !forward;
                while (!s.isEmpty()) {
                    System.out.print(s.pop().getData() + " ");
                }
                System.out.println();
                if (!q.isEmpty()) {
                    q.add(EMPTY);
                }
            }
        }
    }

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(8);
        TreeNode<Integer> left = new TreeNode<>(4);
        TreeNode<Integer> right = new TreeNode<>(14);
        TreeNode<Integer> leftLeft = new TreeNode<>(3);
        TreeNode<Integer> leftRight = new TreeNode<>(5);
        TreeNode<Integer> leftRightRight = new TreeNode<>(6);
        TreeNode<Integer> rightRight = new TreeNode<>(18);
        TreeNode<Integer> rightRightLeft = new TreeNode<>(17);
        root.setLeft(left);
        root.setRight(right);
        left.setLeft(leftLeft);
        left.setRight(leftRight);
        leftRight.setRight(leftRightRight);
        right.setRight(rightRight);
        rightRight.setLeft(rightRightLeft);
        System.out.println(root);
        printAsZigZag(root);
    }


}
