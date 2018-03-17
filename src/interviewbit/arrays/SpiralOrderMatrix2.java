package interviewbit.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Created by max on 6/25/2017.
 * Given an integer n,
 * generate a square matrix filled with elements from 1 to n2 in spiral order.
 */

public class SpiralOrderMatrix2 {

  private enum TraverseDirection{
    RIGHT,
    BOTTOM,
    LEFT,
    TOP
  }

  private class TraverseState {
    int row = 0;
    int col = 0;
    HashMap<TraverseDirection,Integer> bounds = new HashMap<>(4);
    TraverseDirection direction = TraverseDirection.RIGHT;

    public TraverseState(int n, int m) {
      bounds.put(TraverseDirection.BOTTOM, n - 1);
      bounds.put(TraverseDirection.RIGHT, m - 1);
      bounds.put(TraverseDirection.TOP, 1);
      bounds.put(TraverseDirection.LEFT, 0);
    }

    public boolean tryToPut(){
      switch (direction){
        case RIGHT:
          return tryGoRight();
        case BOTTOM:
          return tryGoDown();
        case LEFT:
          return tryGoLeft();
        case TOP:
          return tryGoUp();
      }
      return false;
    }

    private boolean tryGoRight() {
      int bound = bounds.get(direction);
      if (col + 1 <= bound) {
        col++;
        return true;
      }
      bounds.replace(direction,bound-1);
      direction = TraverseDirection.BOTTOM;
      return false;
    }

    private boolean tryGoLeft() {
      int bound = bounds.get(direction);
      if (col - 1 >= bound) {
        col--;
        return true;
      }
      bounds.replace(direction,bound+1);
      direction = TraverseDirection.TOP;
      return false;
    }

    private boolean tryGoDown() {
      int bound = bounds.get(direction);
      if (row + 1 <= bound) {
        row++;
        return true;
      }
      bounds.replace(direction,bound-1);
      direction = TraverseDirection.LEFT;
      return false;
    }

    private boolean tryGoUp() {
      int bound = bounds.get(direction);
      if (row - 1 >= bound) {
        row--;
        return true;
      }
      bounds.replace(direction,bound+1);
      direction = TraverseDirection.RIGHT;
      return false;
    }
  }

  public ArrayList<ArrayList<Integer>> generateMatrix(int a) {
    ArrayList<ArrayList<Integer>> ans = new ArrayList<>(a);
    for (int i = 0; i < a; i++) {
      ans.add(new ArrayList<>(Collections.nCopies(a, 0)));
    }
    ans.get(0).set(0,1);
    TraverseState st =new TraverseState(a,a);
    for (int i = 2; i < a*a+1;) {
      if(st.tryToPut()){
        ans.get(st.row).set(st.col,i);
        i++;
      }
    }
    return ans;
  }

  public static void main(String[] st){
    SpiralOrderMatrix2 q = new SpiralOrderMatrix2();

    
    System.out.println(q.generateMatrix(3));
  }
}
