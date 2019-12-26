package interviewbit.arrays;

import java.util.ArrayList;

/**
 * Created by max on 7/15/2017.
 * Given an m x n matrix of 0s and 1s, if an element is 0, set its entire row and column to 0.

 Do it in place
 */
public class SetMatrixZeros {
  public static void main(String[] st) {
    SetMatrixZeros q = new SetMatrixZeros();

    ArrayList<ArrayList<Integer>> input = new ArrayList<>(3);
    ArrayList<Integer> row0 = new ArrayList<>();
    row0.add(1);
    row0.add(0);
    row0.add(1);
    ArrayList<Integer> row1 = new ArrayList<>();
    row1.add(1);
    row1.add(1);
    row1.add(1);
    ArrayList<Integer> row2 = new ArrayList<>();
    row2.add(1);
    row2.add(1);
    row2.add(1);
    input.add(row0);
    input.add(row1);
    input.add(row2);
    q.setZeroes(input);
    System.out.println(input);
  }

  public void setZeroes(ArrayList<ArrayList<Integer>> a) {
    boolean firstRowZero = false;
    boolean firstColumnZero = false;

    for (ArrayList<Integer> anA : a) {
      if (anA.get(0) == 0) {
        firstColumnZero = true;
        break;
      }
    }

    ArrayList<Integer> firstRow = a.get(0);
    for (Integer aFirstRow : firstRow) {
      if (aFirstRow == 0) {
        firstRowZero = true;
        break;
      }
    }

    for (int i = 1; i < a.size(); i++) {
      for (int j = 1; j < firstRow.size(); j++) {
        if (a.get(i).get(j) == 0) {
          a.get(i).set(0, 0);
          firstRow.set(j, 0);
        }
      }
    }

    for (int i = 1; i < a.size(); i++) {
      for (int j = 1; j < firstRow.size(); j++) {
        if (a.get(i).get(0) == 0 || firstRow.get(j) == 0) {
          a.get(i).set(j, 0);
        }
      }
    }

    if (firstColumnZero) {
      for (ArrayList<Integer> anA : a) {
        anA.set(0, 0);
      }
    }

    if (firstRowZero) {
      for (int i = 0; i < firstRow.size(); i++) {
        firstRow.set(i, 0);
      }
    }

  }
}
