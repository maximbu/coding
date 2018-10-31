package interviewbit.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Given an array A of integers, find the index of values that satisfy A + B = C + D, where A,B,C & D are integers values in the array
 *
 * Note:
 *
 * 1) Return the indices `A1 B1 C1 D1`, so that
 *   A[A1] + A[B1] = A[C1] + A[D1]
 *   A1 < B1, C1 < D1
 *   A1 < C1, B1 != D1, B1 != C1
 *
 * 2) If there are more than one solutions,
 *    then return the tuple of values which are lexicographical smallest.
 *
 * Assume we have two solutions
 * S1 : A1 B1 C1 D1 ( these are values of indices int the array )
 * S2 : A2 B2 C2 D2
 *
 * S1 is lexicographically smaller than S2 iff
 *   A1 < A2 OR
 *   A1 = A2 AND B1 < B2 OR
 *   A1 = A2 AND B1 = B2 AND C1 < C2 OR
 *   A1 = A2 AND B1 = B2 AND C1 = C2 AND D1 < D2
 * Example:
 *
 * Input: [3, 4, 7, 1, 2, 9, 8]
 * Output: [0, 2, 3, 5] (O index)
 * If no solution is possible, return an empty list.
 */
public class Equal {

  public ArrayList<Integer> equal(ArrayList<Integer> A) {
    HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
    ArrayList<Integer> ans = new ArrayList<>();
    for (int i = 0; i < A.size(); i++) {
      for (int j = i + 1; j < A.size(); j++) {
        int key = A.get(i) + A.get(j);
        if (!map.containsKey(key)) {
          ArrayList<Integer> l = new ArrayList<>();
          l.add(i);
          l.add(j);
          map.put(key, l);
          continue;
        }
        ArrayList<Integer> l = map.get(key);
        if (l.size() == 4 || l.contains(i) || l.contains(j))
          continue;
        l.add(i);
        l.add(j);
        if (ans.isEmpty() || compareLists(ans, l) > 0) {
          ans = l;
        }
      }
    }
    return ans;
  }

  private int compareLists(ArrayList<Integer> a, ArrayList<Integer> b) {
    for (int i = 0; i < 4; i++) {
      int c = a.get(i).compareTo(b.get(i));
      if (c != 0)
        return c;
    }
    return 0;
  }

  public static void main(String[] st){
    Equal q = new Equal();
    System.out.println(q.equal(new ArrayList<>(Arrays.asList(3, 4, 7, 1, 2, 9, 8))));
    System.out.println(q.equal(new ArrayList<>(Arrays.asList(1, 1, 1, 1, 1 ))));
  }
}
