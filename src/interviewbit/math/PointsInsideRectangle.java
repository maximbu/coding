package interviewbit.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by max on 7/20/2017.
 * You are given a rectangle with co-ordinates represented by arrays A and B, where the sides might not be parallel to the x-y axis.
 Given N points on x-y plane whose co-ordinates are represented by arrays C and D, count the number of points that lie strictly inside the rectangle.
 All the coordinates have integral values.
 */
public class PointsInsideRectangle {

    public static void main(String[] st) {
        PointsInsideRectangle q = new PointsInsideRectangle();

        ArrayList<Integer> a = new ArrayList<>();
        a.add(0);
        a.add(-2);
        a.add(2);
        a.add(4);

        ArrayList<Integer> b = new ArrayList<>();
        b.add(0);
        b.add(2);
        b.add(6);
        b.add(4);

        ArrayList<Integer> c = new ArrayList<>();
        c.add(1);
        c.add(2);
        c.add(1);
        c.add(5);
        c.add(-3);

        ArrayList<Integer> d = new ArrayList<>();
        d.add(3);
        d.add(4);
        d.add(2);
        d.add(5);
        d.add(1);

        System.out.println(q.solve(a, b, c, d));

    /*
    A : [ 757806, 870553, 1208794, 1096047 ]
    B : [ 750581, 637834, 976075, 1088822 ]
    C : [ -960840, -955568, -948123, -944567, -932689, -909006, -899213, -872499, -816231, -815487, -745458, -733965, -731767, -724160, -674483, -668124, -638622, -626199, -601653, -558231, -555957, -545997, -544386, -543614, -535798, -534548, -515867, -476700, -475144, -469624, -458175, -438328, -417182, -381407, -371638, -337506, -329494, -310312, -294120, -293259, -286345, -239709, -236737, -226459, -101763, -95015, -92985, -45365, -39041, -16265, 14345, 20699, 43223, 59858, 80467, 155882, 178162, 185280, 219005, 232976, 270563, 279358, 282342, 289593, 290780, 317859, 329292, 341423, 361695, 393776, 422139, 433328, 444707, 470220, 508399, 509636, 516573, 532007, 537797, 541645, 542654, 606489, 609080, 614672, 617072, 619918, 626655, 690373, 721697, 723175, 750776, 763166, 771255, 814811, 829093, 887413, 898447, 908990, 923037, 935731 ]
    D : [ -567401, -305898, -133127, 306804, -128699, 994624, -618554, -827823, 67682, 259449, 256638, 675439, 866179, 202790, -859640, -46451, -328534, 750143, 256970, -520372, -873728, 298573, -830382, 539967, -142881, 886848, -43491, -1859, -229702, 300055, 848590, -694308, -545489, 779474, 916511, -624980, 677863, 377492, 341491, -486602, 414689, 760790, 740840, -294549, -257631, -180968, -361856, -703029, -309178, -15868, -881165, 339541, -137928, -453872, -68725, -569599, -504392, 997206, -545062, 145377, -865567, 666039, -194872, 436167, 835283, -168730, 877227, 663200, -7680, -368684, -566371, 497670, -258796, 29626, -969593, 30447, -419927, -205084, -428907, -854872, 327835, -75951, -465094, -474657, 805466, 874210, 473763, -956825, -188138, -425076, -899816, 588745, -56595, 342698, 305541, 610272, -930175, 175954, 735343, 679916 ]
     */

        a = new ArrayList<>(Arrays.asList(757806, 870553, 1208794, 1096047));

        b = new ArrayList<>(Arrays.asList(750581, 637834, 976075, 1088822));

        c = new ArrayList<>(Arrays
                .asList(-960840, -955568, -948123, -944567, -932689, -909006, -899213, -872499, -816231,
                        -815487, -745458, -733965, -731767, -724160, -674483, -668124, -638622, -626199,
                        -601653, -558231, -555957, -545997, -544386, -543614, -535798, -534548, -515867,
                        -476700, -475144, -469624, -458175, -438328, -417182, -381407, -371638, -337506,
                        -329494, -310312, -294120, -293259, -286345, -239709, -236737, -226459, -101763, -95015,
                        -92985, -45365, -39041, -16265, 14345, 20699, 43223, 59858, 80467, 155882, 178162,
                        185280, 219005, 232976, 270563, 279358, 282342, 289593, 290780, 317859, 329292, 341423,
                        361695, 393776, 422139, 433328, 444707, 470220, 508399, 509636, 516573, 532007, 537797,
                        541645, 542654, 606489, 609080, 614672, 617072, 619918, 626655, 690373, 721697, 723175,
                        750776, 763166, 771255, 814811, 829093, 887413, 898447, 908990, 923037, 935731));

        d = new ArrayList<>(Arrays
                .asList(-567401, -305898, -133127, 306804, -128699, 994624, -618554, -827823, 67682, 259449,
                        256638, 675439, 866179, 202790, -859640, -46451, -328534, 750143, 256970, -520372,
                        -873728, 298573, -830382, 539967, -142881, 886848, -43491, -1859, -229702, 300055,
                        848590, -694308, -545489, 779474, 916511, -624980, 677863, 377492, 341491, -486602,
                        414689, 760790, 740840, -294549, -257631, -180968, -361856, -703029, -309178, -15868,
                        -881165, 339541, -137928, -453872, -68725, -569599, -504392, 997206, -545062, 145377,
                        -865567, 666039, -194872, 436167, 835283, -168730, 877227, 663200, -7680, -368684,
                        -566371, 497670, -258796, 29626, -969593, 30447, -419927, -205084, -428907, -854872,
                        327835, -75951, -465094, -474657, 805466, 874210, 473763, -956825, -188138, -425076,
                        -899816, 588745, -56595, 342698, 305541, 610272, -930175, 175954, 735343, 679916));

        System.out.println(q.solve(a, b, c, d));

    }

    public class Point{
        long x;
        long y;

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    public class Rectangle{

        private final double area;
        private ArrayList<Point> points;

        public Rectangle(ArrayList<Point> points) {
            this.points = points;
            this.area = calcuteArea();
        }

        private double calcuteArea() {
            Point p1 = points.get(0);
            Point p2 = points.get(1);
            Point p3 = points.get(2);
            Point p4 = points.get(3);
            return calculateTraingleArea(p1, p2, p3) + calculateTraingleArea(p2, p3, p4);
        }

        double calculateTraingleArea(Point p1, Point p2,Point p3) {
            return 0.5 * Math.abs(p1.x * (p2.y - p3.y) + p2.x * (p3.y - p1.y) + p3.x * (p1.y - p2.y));
        }

        public boolean isInside(Point p) {
            Point p1 = points.get(0);
            Point p2 = points.get(1);
            Point p3 = points.get(2);
            Point p4 = points.get(3);
            double trianglesArea = 0;
            double triangleArea = 0;
            triangleArea = calculateTraingleArea(p1, p, p2);
            if(triangleArea < 1){
                return false;
            }
            trianglesArea += triangleArea;
            triangleArea = calculateTraingleArea(p2, p, p3);
            if(triangleArea < 1){
                return false;
            }
            trianglesArea += triangleArea;
            triangleArea = calculateTraingleArea(p3, p, p4);
            if(triangleArea < 1){
                return false;
            }
            trianglesArea += triangleArea;
            triangleArea = calculateTraingleArea(p4, p, p1);
            if(triangleArea < 1){
                return false;
            }
            trianglesArea += triangleArea;
            return trianglesArea - area < 0.1;
        }
    }



    public int solve(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> C,
                     ArrayList<Integer> D) {
        ArrayList<Point> rec = IntStream.range(0, A.size())
                .mapToObj(i -> new Point(A.get(i), B.get(i)))
                .collect(Collectors.toCollection(ArrayList::new));
        ArrayList<Point> points = IntStream.range(0, C.size())
                .mapToObj(i -> new Point(C.get(i), D.get(i)))
                .collect(Collectors.toCollection(ArrayList::new));
        Rectangle rectangle = new Rectangle(rec);
        return (int) points.stream().filter(rectangle::isInside).count();
    }
}
