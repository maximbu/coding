package CodingInterviews.P16;


/**
 * Created by max on 1/21/2017.
 */
public class q16_3 {

    public static class Point {
        double x;
        double y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public double getX() {
            return x;
        }

        public void setX(double x) {
            this.x = x;
        }

        public double getY() {
            return y;
        }

        public void setY(double y) {
            this.y = y;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    public class LineSegment {
        private final double minX;
        private final double maxX;
        private final double A;
        private final double B;

        public LineSegment(Point x1, Point x2) {
            A = (x2.getY() - x1.getY()) / (x2.getX() - x1.getX());
            B = x1.getY() - A * x1.getX();
            minX = Math.min(x1.getX(), x2.getX());
            maxX = Math.max(x1.getX(), x2.getX());
        }

        private boolean equal(double x, double y) {
            return Math.abs(x - y) < 0.0001;
        }

        public boolean isOnLine(Point p) {
            return equal(A * p.getX() + B - p.getY(), 0);
        }

        public boolean isOnLineSegment(Point p) {
            return isOnLine(p) && p.getX() >= minX && p.getX() <= maxX;
        }

        public boolean isSameLine(LineSegment l) {
            return equal(A, l.A) && equal(B, l.B);
        }

        public Point intercept(LineSegment l) {
            double x = (B - l.B) / (l.A - A);
            if (Double.isInfinite(x)) return null;
            double y = A * x + B;
            return new Point(x, y);
        }
    }

    public Point interception(Point x1, Point x2, Point y1, Point y2) {
        LineSegment l1 = new LineSegment(x1, x2);
        LineSegment l2 = new LineSegment(y1, y2);
        if (l1.isSameLine(l2)) return x1;
        Point p = l1.intercept(l2);
        if (p != null && l1.isOnLineSegment(p) && l2.isOnLineSegment(p)) return p;
        return null;
    }

    public static void main(String[] s) {
        q16_3 q = new q16_3();
        System.out.println(q.interception(new Point(1, 7), new Point(7, 3), new Point(3, 3), new Point(5, 5)));
    }
}
