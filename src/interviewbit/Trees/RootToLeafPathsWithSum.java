package interviewbit.Trees;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path’s sum equals the given sum.
 *
 * For example:
 * Given the below binary tree and sum = 22,
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * return
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 */
public class RootToLeafPathsWithSum {

    public ArrayList<ArrayList<Integer>> pathSum(TreeNode A, int B) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        pathSum(A, B, new LinkedList<>(), ans);
        return ans;
    }

    private void pathSum(TreeNode A, int B, LinkedList<Integer> curr, ArrayList<ArrayList<Integer>> ans) {
        if (A == null)
            return;
        if (A.val == B && A.left == null && A.right == null) {
            curr.addLast(A.val);
            ans.add(new ArrayList<>(curr));
            curr.removeLast();
            return;
        }
        curr.addLast(A.val);
        pathSum(A.left, B - A.val, curr, ans);
        pathSum(A.right, B - A.val, curr, ans);
        curr.removeLast();
    }
}
