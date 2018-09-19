package interviewbit.DynamicProgramming;

import interviewbit.Trees.TreeNode;
import java.util.HashMap;

public class MaxSumPathInBinaryTree {
    public int maxPathSum(TreeNode A) {
        if (A == null) return 0;
        HashMap<TreeNode , Integer> map = new HashMap<>();
        int calcPathWithA = A.val + highestSumToChild(A.left,map) + highestSumToChild(A.right,map);
        int ans =  Math.max(calcPathWithA,Math.max(maxPathSum(A.right),maxPathSum(A.left)));
        return ans == 0 ? maxValue(A) : ans;
    }

    private int maxValue(TreeNode A) {
        if(A == null) return Integer.MIN_VALUE;
        return Math.max(A.val,Math.max(maxValue(A.left),maxValue(A.right)));
    }

    private int highestSumToChild(TreeNode A , HashMap<TreeNode , Integer> map) {
        if (A == null)
            return 0;
        if (map.containsKey(A)) {
            return map.get(A);
        }
        int ans = A.val + Math.max(highestSumToChild(A.left, map), highestSumToChild(A.right, map));
        map.put(A, ans);
        return ans;
    }

    public static void main(String[] st) {
        MaxSumPathInBinaryTree q = new MaxSumPathInBinaryTree();
        TreeNode root = new TreeNode(-100);
        TreeNode left = new TreeNode(-200);
        TreeNode leftLeft = new TreeNode(-300);
        TreeNode leftRight = new TreeNode(-400);
        root.left = left;
        left.left = leftLeft;
        left.right = leftRight;
        System.out.println(q.maxPathSum(root));
    }
}
