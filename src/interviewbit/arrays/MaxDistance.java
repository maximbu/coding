package interviewbit.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by max on 7/2/2017.
 * Given an array A of integers, find the maximum of j - i subjected to the constraint of A[i] <= A[j].

 If there is no solution possible, return -1.
 */
public class MaxDistance {

  private class IntWithPosition implements Comparable<IntWithPosition> {

    int position;
    int maxPosition;
    int val;

    public IntWithPosition(int position, int val) {
      this.position = position;
      this.val = val;
    }

    @Override
    public int compareTo(IntWithPosition o) {
      return val - o.val;
    }
  }

  // DO NOT MODIFY THE LIST
  public int maximumGap(final List<Integer> a) {
    int ans = -1;
    ArrayList<Integer> min = createMinArray(a);
    ArrayList<Integer> max = createMaxArray(a);

    int i = 0, j = 0;
    while (i < a.size() && j < a.size()) {
      if (min.get(i) <= max.get(j)) {
        ans = Math.max(ans, j - i);
        j++;
      } else {
        i++;
      }
    }
    return ans;
  }

  private ArrayList<Integer> createMinArray(List<Integer> a) {
    ArrayList<Integer> min = new ArrayList<>();
    min.add(a.get(0));
    for (int i = 1; i < a.size(); i++) {
      min.add(Math.min(a.get(i), min.get(i - 1)));
    }
    return min;
  }

  private ArrayList<Integer> createMaxArray(List<Integer> a) {
    ArrayList<Integer> max = new ArrayList<>(a.size());
    for (int i1 = 0; i1 < a.size(); i1++) {
      max.add(-1);
    }
    max.set(a.size() - 1, a.get(a.size() - 1));
    for (int i = a.size() - 2; i >= 0; i--) {
      max.set(i, Math.max(a.get(i), max.get(i + 1)));
    }
    return max;
  }

  private int naiveSolution(List<Integer> a) {
    int maxDist = -1;
    for (int i = 0; i < a.size(); i++) {
      for (int j = i; j < a.size(); j++) {
        if(a.get(j)>=a.get(i)){
          maxDist = Math.max(j-i,maxDist);
        }
      }
    }
    return maxDist;
  }

  public static void main(String[] st){
    MaxDistance q = new MaxDistance();

    ArrayList<Integer> X = new ArrayList<>();
    X.add(3);
    X.add(5);
    X.add(4);
    X.add(2);

    System.out.println(q.maximumGap(X));

    X = new ArrayList<>();
    X.add(1);

    System.out.println(q.maximumGap(X));
  }
}
