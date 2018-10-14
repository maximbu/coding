package interviewbit.Backtracking;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Given a string s, partition s such that every string of the partition is a palindrome.
 *
 * Return all possible palindrome partitioning of s.
 *
 * For example, given s = "aab",
 * Return
 *
 *   [
 *     ["a","a","b"]
 *     ["aa","b"],
 *   ]
 *  Ordering the results in the answer : Entry i will come before Entry j if :
 * len(Entryi[0]) < len(Entryj[0]) OR
 * (len(Entryi[0]) == len(Entryj[0]) AND len(Entryi[1]) < len(Entryj[1])) OR
 * *
 * *
 * *
 * (len(Entryi[0]) == len(Entryj[0]) AND … len(Entryi[k] < len(Entryj[k]))
 * In the given example,
 * ["a", "a", "b"] comes before ["aa", "b"] because len("a") < len("aa")
 */
public class PalindromePartitioning {

  public ArrayList<ArrayList<String>> partition(String a) {
    ArrayList<ArrayList<String>> ans = new ArrayList<>();
    partition(a, new LinkedList<>(), ans);
    ans.sort(PalindromePartitioning::compareLists);
    return ans;
  }

  private void partition(String a, LinkedList<String> curr, ArrayList<ArrayList<String>> ans) {
    if (a.length() == 0) {
      ans.add(new ArrayList<>(curr));
      return;
    }
    for (int i = 0; i < a.length(); i++) {
      String n = a.substring(0, i + 1);
      if (isPalindrom(n)) {
        curr.addLast(n);
        partition(a.substring(i + 1), curr, ans);
        curr.removeLast();
      }
    }
  }

  private boolean isPalindrom(String s) {
    if (s.length() < 2)
      return true;
    int start = 0;
    int end = s.length() - 1;
    while (end > start) {
      if (s.charAt(start++) != s.charAt(end--)) {
        return false;
      }
    }
    return true;
  }

  private static int compareLists(ArrayList<String> o1, ArrayList<String> o2) {
    for (int i = 0; i < Math.min(o1.size(), o2.size()); i++) {
      int cmp = o1.get(i).compareTo(o2.get(i));
      if (cmp != 0) {
        return cmp;
      }
    }
    return Integer.compare(o1.size(), o2.size());
  }
}
