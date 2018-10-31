package interviewbit.binarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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

  public static void main(String[] st) {
    MedianOfArray q = new MedianOfArray();

    ArrayList<Integer> A = new ArrayList<>();
    A.add(1);
    A.add(4);
    A.add(5);

    ArrayList<Integer> B = new ArrayList<>();
    B.add(2);
    B.add(3);

    System.out.println(q.findMedianSortedArrays(A, B));

    A = new ArrayList<>(Arrays.asList(-43, -25, -18, -15, -10, 9, 39, 40));
    B = new ArrayList<>(Collections.singletonList(-2));

    System.out.println(q.findMedianSortedArrays(A, B));

    A = new ArrayList<>(Arrays.asList(-35, 5, 11, 34, 35));
    B = new ArrayList<>();

    System.out.println(q.findMedianSortedArrays(A, B));

    A = new ArrayList<>(Arrays.asList(0, 23));
    B = new ArrayList<>();

    System.out.println(q.findMedianSortedArrays(A, B));

    A = new ArrayList<>(Arrays.asList(-3, -2, 1, 15));
    B = new ArrayList<>(Arrays.asList(-31, -11));

    System.out.println(q.findMedianSortedArrays(A, B));
  }

  // DO NOT MODIFY BOTH THE LISTS
  public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
    int n = a.size() + b.size();

    if (n % 2 == 0) {
      return (findKth(a, 0, b, 0, n / 2) + findKth(a, 0, b, 0, n / 2 + 1)) / 2;
    }
    return findKth(a, 0, b, 0, n / 2 + 1);
  }

  private double findKth(List<Integer> a, int startA, List<Integer> b, int startB, int k) {
    if (startA >= a.size()) return b.get(startB + k - 1);
    if (startB >= b.size()) return a.get(startA + k - 1);

    if (k == 1) return Math.min(a.get(startA), b.get(startB));

    int halfKthOfA = startA + k / 2 - 1 < a.size() ? a.get(startA + k / 2 - 1) : Integer.MAX_VALUE;
    int halfKthOfB = startB + k / 2 - 1 < b.size() ? b.get(startB + k / 2 - 1) : Integer.MAX_VALUE;
    if (halfKthOfA < halfKthOfB) {
      return findKth(a, startA + k / 2, b, startB, k - k / 2);
    }
    return findKth(a, startA, b, startB + k / 2, k - k / 2);
  }
}
