package interviewbit.arrays;

import java.util.ArrayList;

/**
 * Created by max on 6/30/2017.
 * Given numRows, generate the first numRows of Pascal’s triangle.

 * Pascal’s triangle : To generate A[C] in row R, sum up A’[C] and A’[C-1] from previous row R - 1.
 */
public class PascalTriangleRows {
  public static void main(String[] st){
    PascalTriangleRows q = new PascalTriangleRows();
    System.out.println(q.generate(5));
  }

  public ArrayList<ArrayList<Integer>> generate(int a) {
    ArrayList ans = new ArrayList();
    if(a == 0) return ans;
    ArrayList<Integer> prevRow = new ArrayList<>();
    prevRow.add(1);
    ans.add(prevRow);
    for (int i = 1; i < a; i++) {
      ArrayList<Integer> row = new ArrayList<>();
      ans.add(row);
      row.add(1);
      for (int j = 1; j < i; j++) {
        row.add(prevRow.get(j)+prevRow.get(j-1));
      }
      row.add(1);
      prevRow = row;
    }
    return ans;
  }
}
