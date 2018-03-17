package interviewbit.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by max on 7/13/2017.
 * Given an unsorted array, find the maximum difference between the successive elements in its sorted form.

 Try to solve it in linear time/space.
 Return 0 if the array contains less than 2 elements.

 You may assume that all the elements in the array are non-negative integers and fit in the 32-bit signed integer range.
 You may also assume that the difference will not overflow.
 */
public class MaximumConsecutiveGap {
  public static void main(String[] st){
    MaximumConsecutiveGap q = new MaximumConsecutiveGap();

    ArrayList<Integer> X = new ArrayList<>();
    X.add(1);
    X.add(10);
    X.add(5);
    System.out.println(q.maximumGap(X));


  }

  // DO NOT MODIFY THE LIST
  public int maximumGap(final List<Integer> a) {
    if(a.size() < 2) return 0;
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;

    for (Integer anA : a) {
      max = Math.max(max, anA);
      min = Math.min(min, anA);
    }
    if( min == max) return 0;
    int gap = (int)Math.ceil((double)(max - min)/(a.size() - 1));

    int[] bucketsMIN = new int[a.size()];
    int[] bucketsMAX = new int[a.size()];
    Arrays.fill(bucketsMIN, Integer.MAX_VALUE);
    Arrays.fill(bucketsMAX, Integer.MIN_VALUE);

    for (int i:a) {
      int idx = (i - min) / gap;
      bucketsMIN[idx] = Math.min(i, bucketsMIN[idx]);
      bucketsMAX[idx] = Math.max(i, bucketsMAX[idx]);
    }

    int maxGap = 0;
    int previous = bucketsMIN[0];
    for (int i = 0; i < a.size(); i++) {
      if (bucketsMIN[i] == Integer.MAX_VALUE)
        continue;
      maxGap = Math.max(maxGap, bucketsMIN[i] - previous);
      previous = bucketsMAX[i];
    }
    return maxGap;
  }
}
