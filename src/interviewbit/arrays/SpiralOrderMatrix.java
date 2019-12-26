package interviewbit.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by max on 6/25/2017.
 * Given a matrix of m * n elements (m rows, n columns),
 * return all elements of the matrix in spiral order.
 */

// in (3 rows) : 3 13 133 241 22 258 187 150 79 207 196 401 366 335 198 401 55 260 363 14 318 178 296 333 296 45 37 10 112 374 79 12 97 39 310 223 139 91 171 95 126
// out : 133 241 22 258 187 150 79 207 196 401 366 335 198 10 126 95 171 91 139 223 310 39 97 12 79 374 112 401 55 260 363 14 318 178 296 333 296 45 37
public class SpiralOrderMatrix {

  private enum TraverseDirection {
    RIGHT,
    BOTTOM,
    LEFT,
    TOP
  }

  public class TraverseState {
    int row = 0;
    int col = 0;
    HashMap<TraverseDirection, Integer> bounds = new HashMap<>(4);
    TraverseDirection direction = TraverseDirection.RIGHT;

    public TraverseState(int n, int m) {
      bounds.put(TraverseDirection.BOTTOM, n - 1);
      bounds.put(TraverseDirection.RIGHT, m - 1);
      bounds.put(TraverseDirection.TOP, 1);
      bounds.put(TraverseDirection.LEFT, 0);
    }

    public boolean tryToMove() {
      switch (direction) {
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
      bounds.replace(direction, bound - 1);
      direction = TraverseDirection.BOTTOM;
      return false;
    }

    private boolean tryGoLeft() {
      int bound = bounds.get(direction);
      if (col - 1 >= bound) {
        col--;
        return true;
      }
      bounds.replace(direction, bound + 1);
      direction = TraverseDirection.TOP;
      return false;
    }

    private boolean tryGoDown() {
      int bound = bounds.get(direction);
      if (row + 1 <= bound) {
        row++;
        return true;
      }
      bounds.replace(direction, bound - 1);
      direction = TraverseDirection.LEFT;
      return false;
    }

    private boolean tryGoUp() {
      int bound = bounds.get(direction);
      if (row - 1 >= bound) {
        row--;
        return true;
      }
      bounds.replace(direction, bound + 1);
      direction = TraverseDirection.RIGHT;
      return false;
    }
  }

  // DO NOT MODIFY THE LIST
  public ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> a) {
    ArrayList<Integer> result = new ArrayList<>();
    int m = a.size();
    int n = a.get(0).size();

    result.add(a.get(0).get(0));
    TraverseState state = new TraverseState(n, m);

    while (result.size() < m * n) {
      if (state.tryToMove()) {
        result.add(a.get(state.row).get(state.col));
      }
    }
    // Populate result;
    return result;
  }

  public static void main(String[] st) {
    SpiralOrderMatrix q = new SpiralOrderMatrix();

    List<ArrayList<Integer>> input = new ArrayList<>(3);
    ArrayList<Integer> row0 = new ArrayList<>();
    row0.add(1);
    row0.add(2);
    ArrayList<Integer> row1 = new ArrayList<>();
    row1.add(3);
    row1.add(4);
    ArrayList<Integer> row2 = new ArrayList<>();
    row2.add(5);
    row2.add(6);
    input.add(row0);
    input.add(row1);
    input.add(row2);
    System.out.println(q.spiralOrder(input));
  }
}
