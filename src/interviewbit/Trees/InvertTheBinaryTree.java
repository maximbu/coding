package interviewbit.Trees;

/**
 * Given a binary tree, invert the binary tree and return it.
 * Look at the example for more details.
 *
 * Example :
 * Given binary tree
 *
 *      1
 *    /   \
 *   2     3
 *  / \   / \
 * 4   5 6   7
 * invert and return
 *
 *      1
 *    /   \
 *   3     2
 *  / \   / \
 * 7   6 5   4
 */
public class InvertTheBinaryTree {
    public TreeNode invertTree(TreeNode A) {
        if(A == null) return null;
        TreeNode tmp = invertTree(A.left);
        A.left = invertTree(A.right);
        A.right = tmp;
        return A;
    }
}