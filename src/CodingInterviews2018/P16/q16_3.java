package CodingInterviews2018.P16;

import java.util.Optional;

public class q16_3 {

    private static Optional<Point> intersection(Segment s1, Segment s2) {
        double a1 = (s1.start.y - s1.end.y) / (s1.start.x - s1.end.x);
        double a2 = (s2.start.y - s2.end.y) / (s2.start.x - s2.end.x);
        double b1 = (s1.start.y - a1 * s1.start.x);
        double b2 = (s2.start.y - a2 * s2.start.x);
        if (Double.isInfinite(a1) && Double.isInfinite(a2)) {
            return Optional.empty();
        }
        if (Math.abs(a1 - a2) < 0.00001) return Optional.empty();
        if(Double.isInfinite(a1)){
            return Optional.of(new Point(s1.start.x, a2*s1.start.x+b2));
        }
        if(Double.isInfinite(a2)){
            return Optional.of(new Point(s2.start.x, a1*s2.start.x+b1));
        }
        double interX = (b2 - b1) / (a1 - a2);
        double interY = a1 * interX + b1;
        return Optional.of(new Point(interX, interY));
    }



    public static void main(String[] args) {
        Segment s1 = new Segment(new Point(4,6),new Point(7,8));
        Segment s2 = new Segment(new Point(7,8),new Point(4,6));
        Segment s3 = new Segment(new Point(1,1),new Point(6,6));
        Segment s4 = new Segment(new Point(4,6),new Point(4,8));

        System.out.println(intersection(s1,s2));
        System.out.println(intersection(s2,s3));
        System.out.println(intersection(s1,s3));
        System.out.println(intersection(s1,s4));
    }
}
