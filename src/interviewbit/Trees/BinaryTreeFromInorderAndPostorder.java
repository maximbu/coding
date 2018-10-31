package interviewbit.Trees;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 *
 *  Note: You may assume that duplicates do not exist in the tree.
 * Example :
 *
 * Input :
 *         Inorder : [2, 1, 3]
 *         Postorder : [2, 3, 1]
 *
 * Return :
 *             1
 *            / \
 *           2   3
 */
public class BinaryTreeFromInorderAndPostorder {

  public TreeNode buildTree(int[] A, int[] B) {
    return buildTree(A, 0, A.length - 1, B, 0, B.length - 1);
  }

  private TreeNode buildTree(int[] A, int aStart, int aEnd, int[] B, int bStart, int bEnd) {
    if (aStart > aEnd || bStart > bEnd)
      return null;
    int rootV = B[bEnd];
    TreeNode root = new TreeNode(rootV);
    //int ind = Arrays.binarySearch(A, aStart, aEnd + 1, rootV);
    int ind = findMid(A, aStart, aEnd , rootV);
    int rest = aEnd - ind;
    int bSplit = bEnd - rest;
    root.left = buildTree(A, aStart, ind - 1, B, bStart, bSplit - 1);
    root.right = buildTree(A, ind + 1, aEnd, B, bSplit, bEnd - 1);
    return root;
  }

  private int findMid(int[] arr, int start, int end, int key) {
    return IntStream.rangeClosed(start, end).filter(i -> arr[i] == key).findFirst().getAsInt();
  }

  public static void main(String[] st){
    BinaryTreeFromInorderAndPostorder q =new BinaryTreeFromInorderAndPostorder();
    TreeNode t = q.buildTree(new int[]{2,1,3},new int[]{2,3,1});
    t = q.buildTree(new int[]{7, 5, 6, 2, 3, 1, 4 },new int[]{5, 6, 3, 1, 4, 2, 7});
  }
}
