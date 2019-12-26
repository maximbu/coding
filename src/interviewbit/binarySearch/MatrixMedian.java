package interviewbit.binarySearch;

import java.util.ArrayList;

/**
 * Given a N cross M matrix in which each row is sorted, find the overall median of the matrix.
 * Assume N*M is odd.
 * Note: No extra memory is allowed.
 */
public class MatrixMedian {
  public static void main(String[] st) {
    MatrixMedian q = new MatrixMedian();

    ArrayList<Integer> row0 = new ArrayList<>();
    row0.add(1);
    row0.add(3);
    row0.add(5);
    ArrayList<Integer> row1 = new ArrayList<>();
    row1.add(2);
    row1.add(6);
    row1.add(9);
    ArrayList<Integer> row2 = new ArrayList<>();
    row2.add(3);
    row2.add(6);
    row2.add(9);
    ArrayList<ArrayList<Integer>> X = new ArrayList<>();
    X.add(row0);
    X.add(row1);
    X.add(row2);

    System.out.println(q.findMedian(X));

    row0 = new ArrayList<>();
    row0.add(2);
    row1 = new ArrayList<>();
    row1.add(1);
    row2 = new ArrayList<>();
    row2.add(4);
    ArrayList<Integer> row3 = new ArrayList<>();
    row3.add(1);
    ArrayList<Integer> row4 = new ArrayList<>();
    row4.add(2);
    ArrayList<Integer> row5 = new ArrayList<>();
    row5.add(2);
    ArrayList<Integer> row6 = new ArrayList<>();
    row6.add(5);

    X = new ArrayList<>();
    X.add(row0);
    X.add(row1);
    X.add(row2);
    X.add(row3);
    X.add(row4);
    X.add(row5);
    X.add(row6);

    System.out.println(q.findMedian(X));
  }


  public int findMedian(ArrayList<ArrayList<Integer>> A) {
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    int m = A.size();
    int n = A.get(0).size();
    int halfElements = (m * n + 1) / 2;

    for (ArrayList<Integer> aA : A) {
      min = Math.min(aA.get(0), min);
      max = Math.max(aA.get(n - 1), max);
    }

    int mid;
    while (min < max) {
      mid = min + (max - min) / 2;
      int cnt = countElementsSmallerOrEqualThen(mid, A);
      if (cnt < halfElements) {
        min = mid + 1;
      } else {
        max = mid;
      }
    }
    return min;
  }

  private int countElementsSmallerOrEqualThen(int elem, ArrayList<ArrayList<Integer>> a) {
    return a.stream().mapToInt(anA -> countElementsSmallerOrEqualInRow(elem, anA)).sum();
  }

  private int countElementsSmallerOrEqualInRow(int elem, ArrayList<Integer> a) {
    int min = 0;
    int max = a.size() - 1;
    int mid;
    while (min <= max) {
      mid = min + (max - min) / 2;
      if (a.get(mid) <= elem) {
        min = mid + 1;
      } else {
        max = mid - 1;
      }
    }
    return min;
  }
}
