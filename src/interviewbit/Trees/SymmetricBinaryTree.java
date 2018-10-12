package interviewbit.Trees;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 *
 * Example :
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * The above binary tree is symmetric.
 * But the following is not:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 * Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 */
public class SymmetricBinaryTree {

    public int isSymmetric(TreeNode A) {
        if (A == null)
            return 1;
        return isSymmetric(A.left, A.right);
    }

    private int isSymmetric(TreeNode A, TreeNode B) {
        if (A == null)
            return B == null ? 1 : 0;
        if (B == null)
            return 0;
        if (A.val != B.val)
            return 0;
        return isSymmetric(A.left, B.right) * isSymmetric(A.right, B.left);
    }
}
