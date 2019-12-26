package interviewbit.arrays;

import java.util.ArrayList;

/**
 * Created by max on 6/30/2017.
 * Give a N*N square matrix, return an array of its anti-diagonals.
 * Input:

 1 2 3
 4 5 6
 7 8 9

 Return the following :

 [
 [1],
 [2, 4],
 [3, 5, 7],
 [6, 8],
 [9]
 ]
 */
public class AntiDiagonals {
  public static void main(String[] st) {
    AntiDiagonals q = new AntiDiagonals();

    ArrayList<ArrayList<Integer>> X = new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> row0 = new ArrayList<Integer>();
    ArrayList<Integer> row1 = new ArrayList<Integer>();
    ArrayList<Integer> row2 = new ArrayList<Integer>();
    X.add(row0);
    X.add(row1);
    X.add(row2);
    row0.add(1);
    row0.add(2);
    row0.add(3);
    row1.add(4);
    row1.add(5);
    row1.add(6);
    row2.add(7);
    row2.add(8);
    row2.add(9);

    System.out.println(q.diagonal(X));
  }

  public ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> a) {
    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    for (int i = 0; i < a.size() * 2 - 1; i++) {
      ArrayList<Integer> diag = new ArrayList<>();
      ans.add(diag);
      int startJ = Math.min(i, a.size() - 1);
      int startI = i - startJ;
      for (int j = 0; j <= i; j++) {
        if (startI + j < a.size() && startJ - j >= 0) {
          diag.add(a.get(startI + j).get(startJ - j));
        }
      }
    }
    return ans;
  }
}
