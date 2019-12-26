package interviewbit.arrays;

import java.util.ArrayList;

/**
 * Created by max on 6/28/2017.
 * Find out the maximum sub-array of non negative numbers from an array.
 The sub-array should be continuous. That is, a sub-array created by choosing the second and fourth element and skipping the third element is invalid.

 Maximum sub-array is defined in terms of the sum of the elements in the sub-array. Sub-array A is greater than sub-array B if sum(A) > sum(B).
 NOTE: If there is a tie, then compare with segment's length and return segment which has maximum length
 NOTE 2: If there is still a tie, then return the segment with minimum starting index
 */
public class MaxNonNegativeSubArray {
  public static void main(String[] st) {
    MaxNonNegativeSubArray q = new MaxNonNegativeSubArray();

    ArrayList<Integer> a = new ArrayList<>();
    a.add(1);
    a.add(2);
    a.add(5);
    a.add(-7);
    a.add(2);
    a.add(3);

    System.out.println(q.maxset(a));

    a = new ArrayList<>();
    a.add(1967513926);
    a.add(1540383426);
    a.add(-1303455736);
    a.add(-521595368);

    System.out.println(q.maxset(a));

    a = new ArrayList<>();
    a.add(-1);
    a.add(-1);
    a.add(-1);
    a.add(-1);

    System.out.println(q.maxset(a));

    a = new ArrayList<>();
    a.add(0);
    a.add(0);
    a.add(-1);
    a.add(0);

    System.out.println(q.maxset(a));

    a = new ArrayList<>();
    a.add(1);
    a.add(2);
    a.add(5);
    a.add(-7);
    a.add(2);
    a.add(5);

    System.out.println(q.maxset(a));

    a = new ArrayList<>();
    a.add(336465782);
    a.add(-278722862);
    a.add(-2145174067);
    a.add(1101513929);
    a.add(1315634022);
    a.add(-1369133069);
    a.add(1059961393);
    a.add(628175011);
    a.add(-1131176229);
    a.add(-859484421); // 1101513929 1315634022

    System.out.println(q.maxset(a));

  }


  public ArrayList<Integer> maxset(ArrayList<Integer> a) {
    ArrayList<Integer> ans = new ArrayList<>();
    int tempI;
    int bestI = 0;
    int tempJ;
    int bestJ = 0;
    long max = Long.MIN_VALUE;
    long tempMax;

    for (int i = 0; i < a.size(); i++) {
      if (a.get(i) >= 0) {
        tempI = i;
        tempMax = 0;
        while (i < a.size() && a.get(i) >= 0) {
          tempMax += a.get(i++);
        }
        tempJ = i - 1;
        if ((tempMax > max) || (tempMax == max && tempJ - tempI + 1 > bestJ - bestI + 1)) {
          bestI = tempI;
          bestJ = tempJ;
          max = tempMax;
        }
      }
    }

    if (max >= 0) {
      for (int i = bestI; i <= bestJ; i++) {
        ans.add(a.get(i));
      }
    }
    return ans;
  }
}
