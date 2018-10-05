package interviewbit.GraphDataStructure;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;

/**
 * Knight movement on a chess board
 *
 * Given any source point and destination point on a chess board, we need to find whether Knight can move to the destination or not.
 *
 * Knight's movements on a chess board
 *
 * The above figure details the movements for a knight ( 8 possibilities ). Note that a knight cannot go out of the board.
 *
 * If yes, then what would be the minimum number of steps for the knight to move to the said point.
 * If knight can not move from the source point to the destination point, then return -1
 *
 * Input:
 *
 * N, M, x1, y1, x2, y2
 * where N and M are size of chess board
 * x1, y1  coordinates of source point
 * x2, y2  coordinates of destination point
 * Output:
 *
 * return Minimum moves or -1
 * Example
 *
 * Input : 8 8 1 1 8 8
 * Output :  6
 */
public class KnightOnChessBoard {

    private class Point {

        int x;
        int y;
        int dist;

        public Point(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
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

    public int knight(int A, int B, int C, int D, int E, int F) {
        int[] xDiff = {1, 1, -1, -1, 2, 2, -2, -2};
        int[] yDiff = {2, -2, 2, -2, 1, -1, 1, -1};
        HashSet<Point> seen = new HashSet<>();
        Point start = new Point(C, D, 0);
        Point end = new Point(E, F, 0);
        LinkedList<Point> m = new LinkedList<>();
        seen.add(start);
        m.add(start);
        while (!m.isEmpty()) {
            Point p = m.removeFirst();
            if (p.equals(end)) {
                return p.dist;
            }
            for (int i = 0; i < 8; i++) {
                Point newP = new Point(p.x + xDiff[i], p.y + yDiff[i], p.dist + 1);
                if (newP.x >= 1 && newP.y >= 1 && newP.x <= A && newP.y <= B && seen.add(newP)) {
                    m.add(newP);

                }
            }
        }
        return -1;
    }
}
