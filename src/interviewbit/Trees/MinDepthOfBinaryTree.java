package interviewbit.Trees;

/**
 * Given a binary tree, find its minimum depth.
 *
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 *
 *  NOTE : The path has to end on a leaf node.
 * Example :
 *
 *          1
 *         /
 *        2
 * min depth = 2.
 */
public class MinDepthOfBinaryTree {
    public int minDepth(TreeNode A) {
        if (A.left == null && A.right == null)
            return 1;
        if (A.left == null) {
            return minDepth(A.right) + 1;
        }
        if (A.right == null) {
            return minDepth(A.left) + 1;
        }
        return Math.min(minDepth(A.right), minDepth(A.left)) + 1;
    }
}
