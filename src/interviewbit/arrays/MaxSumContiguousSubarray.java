package interviewbit.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by max on 6/26/2017.
 * Find the contiguous subarray within
 * an array (containing at least one number) which has the largest sum.
 */
public class MaxSumContiguousSubarray {
  public int maxSubArray(final List<Integer> a) {
    int[] arr = new int[a.size()];
    arr[0] = a.get(0);
    int max = arr[0];
    for (int i = 1; i < a.size(); i++) {
      arr[i] = Math.max(a.get(i), arr[i - 1] + a.get(i));
      max = Math.max(arr[i], max);
    }

    return max;
  }

  public static void main(String[] st) {
    MaxSumContiguousSubarray q = new MaxSumContiguousSubarray();

    ArrayList<Integer> X = new ArrayList<>();
    X.add(-2);
    X.add(1);
    X.add(-3);
    X.add(4);
    X.add(-1);
    X.add(2);
    X.add(1);
    X.add(-5);
    X.add(4);


    System.out.println(q.maxSubArray(X));
  }
}
