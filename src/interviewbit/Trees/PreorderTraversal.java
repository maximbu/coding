package interviewbit.Trees;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Given a binary tree, return the preorder traversal of its nodes’ values.
 *
 * Example :
 * Given binary tree
 *
 *    1
 *     \
 *      2
 *     /
 *    3
 * return [1,2,3].
 *
 * Using recursion is not allowed.
 */
public class PreorderTraversal {
    public ArrayList<Integer> preorderTraversal(TreeNode A) {
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(A);
        while (!stack.isEmpty()) {
            TreeNode t = stack.pop();
            ans.add(t.val);
            if (t.right != null)
                stack.push(t.right);
            if (t.left != null)
                stack.push(t.left);
        }
        return ans;
    }
}
