package interviewbit.binarySearch;


import java.util.ArrayList;
import java.util.List;

/**
 * Given a sorted array of integers, find the starting and ending position of a given target value.

 Your algorithm’s runtime complexity must be in the order of O(log n).

 If the target is not found in the array, return [-1, -1].
 *
 *
 */
public class SearchForARange {

  public static void main(String[] st) {
    SearchForARange q = new SearchForARange();

    ArrayList<Integer> A = new ArrayList<>();
    A.add(3);
    A.add(7);
    A.add(7);
    A.add(8);
    A.add(8);
    A.add(10);
    int target = 8;
    System.out.println(q.searchRange(A, target));
  }

  // DO NOT MODIFY THE LIST
  public ArrayList<Integer> searchRange(final List<Integer> a, int b) {
    ArrayList<Integer> ans = new ArrayList<>();
    ans.add(startingPosition(a, b));
    ans.add(endingPosition(a, b));
    return ans;
  }

  private Integer endingPosition(List<Integer> a, int b) {
    int start = 0;
    int end = a.size() - 1;
    int mid;
    while (start <= end) {
      mid = (start + end) / 2;
      if (a.get(mid) == b && (mid == a.size() - 1 || a.get(mid + 1) != b)) {
        return mid;
      }
      if (a.get(mid) > b) {
        end = mid - 1;
      } else {
        start = mid + 1;
      }
    }
    return -1;
  }

  private Integer startingPosition(List<Integer> a, int b) {
    int start = 0;
    int end = a.size() - 1;
    int mid;
    while (start <= end) {
      mid = (start + end) / 2;
      if (a.get(mid) == b && (mid == 0 || a.get(mid - 1) != b)) {
        return mid;
      }
      if (a.get(mid) >= b) {
        end = mid - 1;
      } else {
        start = mid + 1;
      }
    }
    return -1;
  }
}


