package interviewbit.binarySearch;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * There are two sorted arrays A and B of size m and n respectively.

 Find the median of the two sorted arrays ( The median of the array formed by merging both the arrays ).

 The overall run time complexity should be O(log (m+n)).

 NOTE: IF the number of elements in the merged array is even, then the median is the average of n / 2 th and n/2 + 1th element.
 For example, if the array is [1 2 3 4], the median is (2 + 3) / 2.0 = 2.5
 *
 */
public class MedianOfArray {
  public static void main(String[] st){
    MedianOfArray q = new MedianOfArray();

    ArrayList<Integer> A = new ArrayList<>();
    A.add(1);
    A.add(4);
    A.add(5);

    ArrayList<Integer> B = new ArrayList<>();
    B.add(2);
    B.add(3);

    System.out.println(q.findMedianSortedArrays(A,B));
  }

  // DO NOT MODIFY BOTH THE LISTS
  public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
    return 0;

  }
}
