package interviewbit.Trees;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 *
 * Assume a BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node’s key.
 * The right subtree of a node contains only nodes with keys greater than the node’s key.
 * Both the left and right subtrees must also be binary search trees.
 * Example :
 *
 * Input :
 *    1
 *   /  \
 *  2    3
 *
 * Output : 0 or False
 *
 *
 * Input :
 *   2
 *  / \
 * 1   3
 *
 * Output : 1 or True
 * Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 */
public class ValidBinarySearchTree {

  public int isValidBST(TreeNode A) {
    return isValidBST(A, Integer.MIN_VALUE, Integer.MAX_VALUE)?1:0;
  }

  private boolean isValidBST(TreeNode A, int min, int max) {
    return A == null
            ||
            A.val >= min && A.val < max
                    && (isValidBST(A.left, min, A.val))
                    && isValidBST(A.right, A.val, max);
  }
}
