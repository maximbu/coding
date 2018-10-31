package interviewbit.Trees;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 *
 *  Note: You may assume that duplicates do not exist in the tree.
 * Example :
 *
 * Input :
 *         Preorder : [1, 2, 3]
 *         Inorder  : [2, 1, 3]
 *
 * Return :
 *             1
 *            / \
 *           2   3
 */
public class ConstructBinaryTreeFromInorderAndPreorder {

  public TreeNode buildTree(int[] A, int[] B) {
    // reusing solved in+post order
    return buildTree(B, 0, B.length - 1, A, 0, A.length - 1);
  }

  private TreeNode buildTree(int[] inOrder, int aStart, int aEnd, int[] preOrder, int bStart, int bEnd) {
    if (aStart > aEnd || bStart > bEnd)
      return null;
    int rootV = preOrder[bStart];
    TreeNode root = new TreeNode(rootV);
    //int ind = Arrays.binarySearch(A, aStart, aEnd + 1, rootV);
    int ind = findMid(inOrder, aStart, aEnd, rootV);

    int bSplit = bStart + ind - aStart;
    root.left = buildTree(inOrder, aStart, ind - 1, preOrder, bStart + 1, bSplit);
    root.right = buildTree(inOrder, ind + 1, aEnd, preOrder, bSplit + 1, bEnd);
    return root;
  }

  private int findMid(int[] arr, int start, int end, int key) {
    return IntStream.rangeClosed(start, end).filter(i -> arr[i] == key).findFirst().getAsInt();
  }

  public static void main(String[] st) {
    ConstructBinaryTreeFromInorderAndPreorder q = new ConstructBinaryTreeFromInorderAndPreorder();
    TreeNode t = q.buildTree(new int[]{1, 2, 3}, new int[]{2, 1, 3});
    t = q.buildTree(new int[]{7, 5, 6, 2, 3, 1, 4}, new int[]{5, 6, 3, 1, 4, 2, 7});
    t = q.buildTree(new int[]{1, 2, 3, 4, 5}, new int[]{3, 2, 4, 1, 5});
  }
}
