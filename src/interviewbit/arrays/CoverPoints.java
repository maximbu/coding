package interviewbit.arrays;

import java.util.ArrayList;

/**
 * Created by max on 6/25/2017.
 * You are given a sequence of points and the order in which you need to cover the points.
 * Give the minimum number of steps in which you can achieve it. You start from the first point.
 */
public class CoverPoints {
  // X and Y co-ordinates of the points in order.
  // Each point is represented by (X.get(i), Y.get(i))
  public int coverPoints(ArrayList<Integer> X, ArrayList<Integer> Y) {
    int steps = 0;
    for (int i = 1; i < X.size(); i++) {
      steps += distance(X.get(i), Y.get(i), X.get(i - 1), Y.get(i - 1));
    }
    return steps;
  }

  private int distance(int x1, int y1, int x2, int y2) {
    return Math.max(Math.abs(x1 - x2), Math.abs(y1 - y2));
  }

  public static void main(String[] st) {
    CoverPoints q = new CoverPoints();

    ArrayList<Integer> X = new ArrayList<>();
    X.add(0);
    X.add(1);
    X.add(2);
    ArrayList<Integer> Y = new ArrayList<>();
    Y.add(0);
    Y.add(1);
    Y.add(2);
    System.out.println(q.coverPoints(X, Y));
  }

}
