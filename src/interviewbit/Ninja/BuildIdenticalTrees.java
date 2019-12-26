package interviewbit.Ninja;

import interviewbit.Trees.TreeNode;

/**
 * Given two binary trees T1 and T2, you have to find minimum number of insertions to be done in T1 to make it structurally identical to T2. Return -1 if not possible.
 *
 * Notes
 *
 * Assume insertions are done in a normal fashion in the BSTs.
 * Assume while inserting, if the value of a node v is equal to value being inserted, we insert it in left subtree of node v.
 * You can insert any positive or negative integer.
 * Example :
 *
 * Input 1:
 *
 * T1:       10
 *          / \
 *         9   20
 *
 * T2:       5
 *          / \
 *         2   7
 *        /
 *       1
 *
 * If you insert 8 into T1, it will be structurally identical to T2. Hence answer is 1.
 *
 *
 * Input 2:
 *
 * T1:       10
 *          / \
 *         9   20
 *
 * T2:       5
 *            \
 *             7
 *
 * You cannot make T1 and T2 structurally identical. Hence answer is -1.
 */
public class BuildIdenticalTrees {

  public int cntMatrix(TreeNode A, TreeNode B) {
    if (A == null && B == null)
      return 0;
    if (A == null)
      return countNodes(B);
    if (B == null)
      return -1;
    int left = cntMatrix(A.left, B.left);
    int right = cntMatrix(A.right, B.right);
    if (left == -1 || right == -1)
      return -1;
    return left + right;
  }

  private int countNodes(TreeNode b) {
    if (b == null)
      return 0;
    return 1 + countNodes(b.left) + countNodes(b.right);
  }

  class Data {
    int num;
    int cnt;

    public Data(int n, int c) {
      num = n;
      cnt = c;
    }
  }

  public static void main(String[] st) {
    BuildIdenticalTrees q = new BuildIdenticalTrees();
    TreeNode A = new TreeNode(3);
    A.left = new TreeNode(999);

    TreeNode B = new TreeNode(9);
    B.left = new TreeNode(7);
    B.right = new TreeNode(6);
    B.left.left = new TreeNode(8);
    B.left.right = new TreeNode(9);
  }
}
