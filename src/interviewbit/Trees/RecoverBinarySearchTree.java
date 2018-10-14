package interviewbit.Trees;

import java.util.ArrayList;

/**
 * Two elements of a binary search tree (BST) are swapped by mistake.
 * Tell us the 2 values swapping which the tree will be restored.
 *
 *  Note:
 * A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
 * Example :
 *
 *
 * Input :
 *          1
 *         / \
 *        2   3
 *
 * Output :
 *        [1, 2]
 *
 * Explanation : Swapping 1 and 2 will change the BST to be
 *          2
 *         / \
 *        1   3
 * which is a valid BST
 */
public class RecoverBinarySearchTree {

  public ArrayList<Integer> recoverTree(TreeNode A) {
    ArrayList<Integer> ord = new ArrayList<>();
    inorder(A, ord);
    ArrayList<Integer> ans = new ArrayList<>();
    for (int i = 0; i < ord.size() - 1; i++) {
      if (ord.get(i) > ord.get(i + 1)) {
        if (ans.size() == 2) {
          ans.set(0, ord.get(i + 1));
          return ans;
        } else {
          ans.add(ord.get(i + 1));
          ans.add(ord.get(i));
        }
      }
    }
    return ans;
  }

  private void inorder(TreeNode A, ArrayList<Integer> ans) {
    if (A == null)
      return;
    inorder(A.left, ans);
    ans.add(A.val);
    inorder(A.right, ans);
  }

}
