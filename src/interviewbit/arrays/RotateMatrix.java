package interviewbit.arrays;

import java.util.ArrayList;

/**
 * Created by max on 7/14/2017.
 * You are given an n x n 2D matrix representing an image.

 Rotate the image by 90 degrees (clockwise).

 You need to do this in place.

 Note that if you end up using an additional array, you will only receive partial score.
 */
public class RotateMatrix {
  public static void main(String[] st){
    RotateMatrix q = new RotateMatrix();

    ArrayList<ArrayList<Integer>> input = new ArrayList<>(3);
    ArrayList<Integer> row0 = new ArrayList<>();
    row0.add(1);
    row0.add(2);
    row0.add(3);
    ArrayList<Integer> row1 = new ArrayList<>();
    row1.add(4);
    row1.add(5);
    row1.add(6);
    ArrayList<Integer> row2 = new ArrayList<>();
    row2.add(7);
    row2.add(8);
    row2.add(9);
    input.add(row0);
    input.add(row1);
    input.add(row2);
    q.rotate(input);
    System.out.println(input);
}

  public void rotate(ArrayList<ArrayList<Integer>> a) {
    int n = a.size();
    for (int i = 0; i < n/2; i++) {
      for (int j = i; j < n-i-1 ; j++) {
        int tmp = a.get(i).get(j);
        a.get(i).set(j, a.get(n-j-1).get(i));
        a.get(n-j-1).set(i, a.get(n-i-1).get(n-j-1));
        a.get(n-i-1).set(n-j-1, a.get(j).get(n-i-1));
        a.get(j).set(n-i-1, tmp);
      }
    }
  }
}
