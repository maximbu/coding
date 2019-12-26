package interviewbit.arrays;

import java.util.ArrayList;

/**
 * Created by max on 6/30/2017.
 * Given an index k, return the kth row of the Pascal’s triangle.

 * Pascal’s triangle : To generate A[C] in row R, sum up A’[C] and A’[C-1] from previous row R - 1.
 */
public class KthRowofPascalsTriangle {
  public static void main(String[] st) {
    KthRowofPascalsTriangle q = new KthRowofPascalsTriangle();
    System.out.println(q.getRow(3));
  }

  public ArrayList<Integer> getRow(int a) {
    ArrayList<Integer> prevRow = new ArrayList<>();
    prevRow.add(1);
    for (int i = 1; i <= a; i++) {
      ArrayList<Integer> row = new ArrayList<>();
      row.add(1);
      for (int j = 1; j < i; j++) {
        row.add(prevRow.get(j) + prevRow.get(j - 1));
      }
      row.add(1);
      prevRow = row;
    }
    return prevRow;
  }
}
