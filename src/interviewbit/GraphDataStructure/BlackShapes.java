package interviewbit.GraphDataStructure;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;

/**
 * Given N * M field of O's and X's, where O=white, X=black
 * Return the number of black shapes. A black shape consists of one or more adjacent X's (diagonals not included)
 *
 * Example:
 *
 * OOOXOOO
 * OOXXOXO
 * OXOOOXO
 *
 * answer is 3 shapes are  :
 * (i)    X
 *      X X
 * (ii)
 *       X
 *  (iii)
 *       X
 *       X
 * Note that we are looking for connected shapes here.
 *
 * For example,
 *
 * XXX
 * XXX
 * XXX
 * is just one single connected black shape.
 */
public class BlackShapes {

    private static class Point {

        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Point point = (Point) o;
            return x == point.x &&
                    y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public int black(ArrayList<String> A) {
        HashSet<Point> seen = new HashSet<>();
        int cnt = 0;
        for (int i = 0; i < A.size(); i++) {
            for (int j = 0; j < A.get(i).length(); j++) {
                if (A.get(i).charAt(j) == 'X') {
                    Point p = new Point(i, j);
                    if (seen.add(p)) {
                        cnt++;
                        markSeen(A, p, seen);
                    }
                }
            }
        }
        return cnt;
    }

    private void markSeen(ArrayList<String> A, Point p, HashSet<Point> seen) {
        if (p.x > 0 && A.get(p.x - 1).charAt(p.y) == 'X' && seen.add(new Point(p.x - 1, p.y))) {
            markSeen(A, new Point(p.x - 1, p.y), seen);
        }
        if (p.y > 0 && A.get(p.x).charAt(p.y - 1) == 'X' && seen.add(new Point(p.x, p.y - 1))) {
            markSeen(A, new Point(p.x, p.y - 1), seen);
        }
        if (p.x < A.size() - 1 && A.get(p.x + 1).charAt(p.y) == 'X' && seen.add(new Point(p.x + 1, p.y))) {
            markSeen(A, new Point(p.x + 1, p.y), seen);
        }
        if (p.y < A.get(p.x).length() - 1 && A.get(p.x).charAt(p.y + 1) == 'X' && seen.add(new Point(p.x, p.y + 1))) {
            markSeen(A, new Point(p.x, p.y + 1), seen);
        }
    }
}
