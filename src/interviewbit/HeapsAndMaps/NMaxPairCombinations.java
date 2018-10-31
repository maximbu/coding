package interviewbit.HeapsAndMaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Objects;
import java.util.PriorityQueue;

/**
 * Given two arrays A & B of size N each.
 * Find the maximum n elements from the sum combinations (Ai + Bj) formed from elements in array A and B.
 *
 * For example if A = [1,2], B = [3,4], then possible pair sums can be 1+3 = 4 , 1+4=5 , 2+3=5 , 2+4=6
 * and maximum 2 elements are 6, 5
 *
 * Example:
 *
 * N = 4
 * a[]={1,4,2,3}
 * b[]={2,5,1,6}
 *
 * Maximum 4 elements of combinations sum are
 * 10   (4+6),
 * 9    (3+6),
 * 9    (4+5),
 * 8    (2+6)
 */
public class NMaxPairCombinations {

  class Res implements Comparable<Res> {

    int a;
    int b;
    int res;

    Res(int a, int b, int res) {
      this.a = a;
      this.b = b;
      this.res = res;
    }

    @Override
    public int hashCode() {
      return Objects.hash(a, b);
    }


    @Override
    public boolean equals(Object o) {
      Res r = (Res) o;
      return a == r.a && b == r.b;
    }

    @Override
    public int compareTo(Res r) {
      return Integer.compare(r.res, res);
    }
  }

  public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
    PriorityQueue<Res> pq = new PriorityQueue<>();
    HashSet<Res> set = new HashSet<>();
    ArrayList<Integer> ans = new ArrayList<>();
    A.sort(Integer::compareTo);
    B.sort(Integer::compareTo);
    Res r = new Res(A.size() - 1, B.size() - 1, A.get(A.size() - 1) + B.get(B.size() - 1));
    pq.add(r);
    int cnt = 0;
    while (cnt < A.size()) {
      Res prev = pq.remove();
      ans.add(prev.res);
      if (prev.a > 0) {
        r = new Res(prev.a - 1, prev.b, A.get(prev.a - 1) + B.get(prev.b));
        if (set.add(r)) {
          pq.add(r);
        }
      }
      if (prev.b > 0) {
        r = new Res(prev.a, prev.b - 1, A.get(prev.a) + B.get(prev.b - 1));
        if (set.add(r)) {
          pq.add(r);
        }
      }
      cnt++;
    }
    return ans;
  }

  public ArrayList<Integer> solve2(ArrayList<Integer> A, ArrayList<Integer> B) {
    PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
    ArrayList<Integer> ans = new ArrayList<>();
    for (int x : A) {
      for (int y : B) {
        pq.add(x + y);
      }
    }
    for (int i = 0; i < A.size(); i++) {
      ans.add(pq.remove());
    }
    return ans;
  }
}
