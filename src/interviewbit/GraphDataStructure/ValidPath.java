package interviewbit.GraphDataStructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Stack;

/**
 * There is a rectangle with left bottom as  (0, 0) and right up as (x, y). There are N circles such that their centers are inside the rectangle.
 * Radius of each circle is R. Now we need to find out if it is possible that we can move from (0, 0) to (x, y) without touching any circle.
 *
 * Note : We can move from any cell to any of its 8 adjecent neighbours and we cannot move outside the boundary of the rectangle at any point of time.
 *
 *
 * Input Format
 *
 * 1st argument given is an Integer x.
 * 2nd argument given is an Integer y.
 * 3rd argument given is an Integer N, number of circles.
 * 4th argument given is an Integer R, radius of each circle.
 * 5th argument given is an Array A of size N, where A[i] = x cordinate of ith circle
 * 6th argument given is an Array B of size N, where B[i] = y cordinate of ith circle
 * Output Format
 *
 * Return YES or NO depending on weather it is possible to reach cell (x,y) or not starting from (0,0).
 * Constraints
 *
 * 0 <= x, y, R <= 100
 * 1 <= N <= 1000
 * Center of each circle would lie within the grid
 * For Example
 *
 * Input:
 *     x = 2
 *     y = 3
 *     N = 1
 *     R = 1
 *     A = [2]
 *     B = [3]
 * Output:
 *     NO
 *
 * Explanation:
 *     There is NO valid path in this case
 */
public class ValidPath {

    private static class Point {

        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int sqrDist(Point p) {
            int dist = (x - p.x) * (x - p.x)
                    + (y - p.y) * (y - p.y);
            return dist;
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

    public String solve(int A, int B, int C, int D, ArrayList<Integer> E, ArrayList<Integer> F) {
        return canFindPath(A, B, D, E, F, new HashSet<>()) ? "YES" : "NO";
    }

    private boolean canFindPath(int X, int Y, int R, ArrayList<Integer> cX, ArrayList<Integer> cY, HashSet<Point> seen) {
        Stack<Point> st = new Stack<>();
        st.add(new Point(0, 0));
        while (!st.isEmpty()) {
            Point point = st.pop();
            if (point.x == X && point.y == Y)
                return true;
            for (int i = 1; i >= -1; i--) {
                for (int j = 1; j >= -1; j--) {
                    Point newPoint = new Point(point.x + i, point.y + j);
                    if (valid(newPoint, X, Y, R, cX, cY, seen)) {
                        st.push(newPoint);
                    }
                }
            }
        }
        return false;
    }

    private boolean valid(Point point, int x, int y, int r, ArrayList<Integer> cX, ArrayList<Integer> cY, HashSet<Point> seen) {
        if (!seen.add(point)) {
            return false;
        }
        if (point.x < 0 || point.x > x || point.y < 0 || point.y > y) {
            return false;
        }
        for (int i = 0; i < cX.size(); i++) {
            if (r > 0 && point.sqrDist(new Point(cX.get(i), cY.get(i))) <= r * r) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] st) {
        ValidPath q = new ValidPath();
        String ans = q.solve(2, 3, 1, 1, new ArrayList<>(Arrays.asList(2)), new ArrayList<>(Arrays.asList(3)));
        System.out.println(ans);
        String ans2 = q.solve(82, 85, 9, 6, new ArrayList<>(Arrays.asList(65, 19, 38, 56, 19, 79, 74, 8, 56)), new ArrayList<>(Arrays.asList(25, 46, 54, 11, 63, 80, 37, 45, 52)));
        System.out.println(ans2);
        String ans3 = q.solve(41, 67, 5, 0, new ArrayList<>(Arrays.asList(17, 16, 12, 0, 40)), new ArrayList<>(Arrays.asList(52, 61, 61, 25, 31)));
        System.out.println(ans3);
    }


}
