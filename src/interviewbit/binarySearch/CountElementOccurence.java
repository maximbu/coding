package interviewbit.binarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given a sorted array of integers, find the number of occurrences of a given target value.
 Your algorithm’s runtime complexity must be in the order of O(log n).
 If the target is not found in the array, return 0
 */
public class CountElementOccurence {

  public static void main(String[] st) {
    CountElementOccurence q = new CountElementOccurence();

    ArrayList<Integer> X = new ArrayList<>();
    X.add(5);
    X.add(7);
    X.add(7);
    X.add(8);
    X.add(8);
    X.add(10);

    System.out.println(q.findCount(X, 8));

    X = new ArrayList<>(Arrays.asList(1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 4, 4, 5, 5, 5, 5, 5, 6, 6, 6, 7, 7, 8, 8, 8, 8, 9, 9, 10, 10, 10));
    System.out.println(q.findCount(X, 1));

    X = new ArrayList<>(Collections.singletonList(1));
    System.out.println(q.findCount(X, 1));

    X = new ArrayList<>(Arrays.asList(1, 2, 6, 9, 9));
    System.out.println(q.findCount(X, 2));

    X = new ArrayList<>(Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10));
    System.out.println(q.findCount(X, 3));
  }

  // DO NOT MODIFY THE LIST
  public int findCount(final List<Integer> a, int b) {
    int lower = findOccurence(a, b, true);
    int upper = findOccurence(a, b, false);

    return lower == -1 ? 0 : upper - lower + 1;

  }


  private int findOccurence(List<Integer> a, int b, boolean firstOcc) {
    int left = 0;
    int right = a.size() - 1;
    int mid;
    int result = -1;
    while (left <= right) {
      mid = left + (right - left) / 2;
      if (a.get(mid) == b) {
        result = mid;
        if (firstOcc) {
          right = mid - 1;
        } else {
          left = mid + 1;
        }
      } else if (a.get(mid) < b) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return result;
  }

  private int naiveSolution(List<Integer> a, int b) {
    int left = 0;
    int right = a.size() - 1;
    int mid;
    while (left <= right) {
      mid = left + (right - left) / 2;
      if (a.get(mid) == b) {
        int cnt = 1;
        int ind = mid - 1;
        while (ind >= 0 && a.get(ind) == b) {
          cnt++;
          ind--;
        }
        while (mid + 1 < a.size() && a.get(mid + 1) == b) {
          cnt++;
          mid++;
        }
        return cnt;
      }
      if (a.get(mid) < b) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return 0;
  }

}
