package interviewbit.Trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Given a binary tree, print a vertical order traversal of it.
 *
 * Example :
 * Given binary tree:
 *
 *       6
 *     /   \
 *    3     7
 *   / \     \
 *  2   5     9
 * returns
 *
 * [
 *     [2],
 *     [3],
 *     [6 5],
 *     [7],
 *     [9]
 * ]
 *
 *
 * Note : If 2 Tree Nodes shares the same vertical level then the one with lesser depth will come first.
 */
public class VerticalOrderTraversalOfBinaryTree {

  static class LevelNode {

    int level;
    TreeNode node;

    LevelNode(int l, TreeNode n) {
      level = l;
      node = n;
    }
  }

  public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    if (A == null)
      return ans;
    HashMap<Integer, ArrayList<Integer>> map = fillMap(new LevelNode(0, A));
    ArrayList<Integer> a = new ArrayList<>(map.keySet());
    a.sort(Integer::compareTo);
    for (int x : a) {
      ans.add(map.get(x));
    }
    return ans;
  }

  private HashMap<Integer, ArrayList<Integer>> fillMap(LevelNode A) {
    HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
    LinkedList<LevelNode> next;
    LinkedList<LevelNode> curr = new LinkedList<>();
    curr.add(A);
    while (!curr.isEmpty()) {
      next = new LinkedList<>();
      for (LevelNode n : curr) {
        map.putIfAbsent(n.level, new ArrayList<>());
        map.get(n.level).add(n.node.val);
        if (n.node.left != null) {
          next.add(new LevelNode(n.level - 1, n.node.left));
        }
        if (n.node.right != null) {
          next.add(new LevelNode(n.level + 1, n.node.right));
        }
      }
      curr = next;
    }
    return map;
  }
}
