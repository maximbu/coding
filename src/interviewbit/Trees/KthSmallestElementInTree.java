package interviewbit.Trees;

/**
 * Given a binary search tree, write a function to find the kth smallest element in the tree.
 *
 * Example :
 *
 * Input :
 *   2
 *  / \
 * 1   3
 *
 * and k = 2
 *
 * Return : 2
 *
 * As 2 is the second smallest element in the tree.
 *  NOTE : You may assume 1 <= k <= Total number of nodes in BST
 */
public class KthSmallestElementInTree {
  public int kthsmallest(TreeNode A, int B) {
    if (A == null)
      return Integer.MAX_VALUE;
    int x = count(A.left);
    if (x + 1 == B) {
      return A.val;
    }
    if (x >= B) {
      return kthsmallest(A.left, B);
    }
    return kthsmallest(A.right, B - x - 1);
  }

  private int count(TreeNode A) {
    if (A == null)
      return 0;
    return 1 + count(A.left) + count(A.right);
  }

  public static void main(String[] st) {
    KthSmallestElementInTree q = new KthSmallestElementInTree();
    TreeNode root = new TreeNode(1);
    System.out.println(q.kthsmallest(root, 1));
    root = new TreeNode(3);
    root.right = new TreeNode(4);
    System.out.println(q.kthsmallest(root, 2));
    root = new TreeNode(3);
    root.left = new TreeNode(2);
    System.out.println(q.kthsmallest(root, 1));
  }
}
