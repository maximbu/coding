package interviewbit.Backtracking;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Given a set of distinct integers, S, return all possible subsets.
 *
 *  Note:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * Also, the subsets should be sorted in ascending ( lexicographic ) order.
 * The list is not necessarily sorted.
 * Example :
 *
 * If S = [1,2,3], a solution is:
 *
 * [
 *   [],
 *   [1],
 *   [1, 2],
 *   [1, 2, 3],
 *   [1, 3],
 *   [2],
 *   [2, 3],
 *   [3],
 * ]
 */
public class Subset {

  public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
    A.sort(Integer::compareTo);
    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    subsets(A, 0, new LinkedList<>(), ans);
    ans.sort(this::compareLists);
    return ans;
  }

  private int compareLists(ArrayList<Integer> o1, ArrayList<Integer> o2) {
    for (int i = 0; i < Math.min(o1.size(), o2.size()); i++) {
      int cmp = o1.get(i).compareTo(o2.get(i));
      if (cmp != 0) {
        return cmp;
      }
    }
    return Integer.compare(o1.size(), o2.size());
  }

  private void subsets(ArrayList<Integer> A, int ind, LinkedList<Integer> curr, ArrayList<ArrayList<Integer>> ans) {
    if (ind == A.size()) {
      ans.add(new ArrayList<>(curr));
      return;
    }
    subsets(A, ind + 1, curr, ans);
    curr.addLast(A.get(ind));
    subsets(A, ind + 1, curr, ans);
    curr.removeLast();
  }
}
