package interviewbit.Trees;

/**
 * Given a BST node, return the node which has value just greater than the given node.
 *
 * Example:
 *
 * Given the tree
 *
 *                100
 *               /   \
 *             98    102
 *            /  \
 *          96    99
 *           \
 *            97
 * Given 97, you should return the node corresponding to 98 as thats the value just greater than 97 in the tree.
 * If there are no successor in the tree ( the value is the largest in the tree, return NULL).
 *
 * Using recursion is not allowed.
 *
 * Assume that the value is always present in the tree
 */
public class NextGreaterNumberBST {

  public TreeNode getSuccessor(TreeNode a, int b) {
    TreeNode bigger = null;
    while (a.val != b) {
      if (a.val > b) {
        bigger = a;
        a = a.left;
      } else {
        a = a.right;
      }
    }
    if (a.right == null)
      return bigger;
    a = a.right;
    while (a.left != null) {
      a = a.left;
    }
    return a;
  }
}
