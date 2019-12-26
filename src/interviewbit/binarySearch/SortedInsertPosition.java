package interviewbit.binarySearch;

import java.util.ArrayList;

/**
 *
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

 You may assume no duplicates in the array.
 *
 */
public class SortedInsertPosition {
  public static void main(String[] st) {
    SortedInsertPosition q = new SortedInsertPosition();

    ArrayList<Integer> A = new ArrayList<>();
    A.add(1);
    A.add(3);
    A.add(5);
    A.add(6);
    int target = 5;
    System.out.println(target + "->" + q.searchInsert(A, target));
    target = 2;
    System.out.println(target + "->" + q.searchInsert(A, target));
    target = 7;
    System.out.println(target + "->" + q.searchInsert(A, target));
    target = 0;
    System.out.println(target + "->" + q.searchInsert(A, target));
  }

  public int searchInsert(ArrayList<Integer> a, int b) {
    int start = 0;
    int end = a.size() - 1;
    int mid;
    while (start <= end) {
      mid = (start + end) / 2;
      if (a.get(mid) == b || mid == 0 || (a.get(mid - 1) < b && a.get(mid) > b)) {
        return mid;
      }
      if (mid == a.size() - 1) {
        return mid + 1;
      }
      if (a.get(mid) > b) {
        end = mid - 1;
      } else {
        start = mid + 1;
      }
    }
    return -1;
  }
}
