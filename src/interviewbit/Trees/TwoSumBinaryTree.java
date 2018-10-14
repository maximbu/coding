package interviewbit.Trees;

import java.util.HashSet;

/**
 * Given a binary search tree T, where each node contains a positive integer, and an integer K, you have to find whether or not there exist two different nodes A and B such that A.value + B.value = K.
 *
 * Return 1 to denote that two such nodes exist. Return 0, otherwise.
 *
 * Notes
 *
 * Your solution should run in linear time and not take memory more than O(height of T).
 * Assume all values in BST are distinct.
 * Example :
 *
 * Input 1:
 *
 * T :       10
 *          / \
 *         9   20
 *
 * K = 19
 *
 * Return: 1
 *
 * Input 2:
 *
 * T:        10
 *          / \
 *         9   20
 *
 * K = 40
 *
 * Return: 0
 */
public class TwoSumBinaryTree {

  public int t2Sum(TreeNode A, int B) {
    return t2Sum(A, B, new HashSet<>());
  }

  public int t2Sum(TreeNode A, int B, HashSet<Integer> seen) {
    if (A == null)
      return 0;
    int left = t2Sum(A.left, B, seen);
    if (left == 1 || seen.contains(B - A.val)) {
      return 1;
    }
    seen.add(A.val);
    return t2Sum(A.right, B, seen);
  }
}
