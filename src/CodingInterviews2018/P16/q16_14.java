package CodingInterviews2018.P16;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class q16_14 {

    private static Line bestLine(List<Point> points) {
        HashMap<Line, Integer> map = new HashMap<>();
        int maxSoFar = 0;
        Line bestLine = null;
        for (int i = 0; i < points.size(); i++) {
            Point p = points.get(i);
            for (int i1 = i + 1; i1 < points.size(); i1++) {
                Point p2 = points.get(i1);
                Line l = new Line(p, p2);
                int cnt = map.getOrDefault(l, 0);
                map.put(l, cnt + 1);
                if (cnt + 1 > maxSoFar) {
                    maxSoFar = cnt + 1;
                    bestLine = l;
                }
            }
        }
        return bestLine;
    }


    public static void main(String[] args) {
        List<Point> points = Arrays.asList(new Point(3, 4), new Point(2, 2), new Point(7, 3), new Point(5, 5), new Point(1, 1), new Point(10, 10), new Point(3, 7));
        System.out.println(bestLine(points));
    }
}
