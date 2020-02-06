package CodingInterviews2018.P16;

public class Square {
    Point topLeft;
    Point topRight;
    Point bottomRight;
    Point bottomLeft;
    double len;

    public Square(Point topLeft, Point topRight, Point bottomRight, Point bottomLeft) {
        this.topLeft = topLeft;
        this.topRight = topRight;
        len = dist(topLeft, topRight);
        this.bottomRight = bottomRight;
        this.bottomLeft = bottomLeft;
        if(notSame(dist(topLeft, bottomLeft), len) || notSame(dist(bottomLeft, bottomRight), len) || notSame(dist(topRight, topRight), len)){
            throw new IllegalArgumentException();
        }
    }

    private boolean notSame(double a, double b) {
        return !(Math.abs(a - b) < 0.0001);
    }

    private double dist(Point a,Point b){
        double ac = Math.abs(a.y - b.y);
        double cb = Math.abs(a.x - b.x);
        return Math.hypot(ac, cb);
    }

    public double getLen() {
        return len;
    }

    public Point getTopLeft() {
        return topLeft;
    }

    public void setTopLeft(Point topLeft) {
        this.topLeft = topLeft;
    }

    public Point getTopRight() {
        return topRight;
    }

    public void setTopRight(Point topRight) {
        this.topRight = topRight;
    }

    public Point getBottomRight() {
        return bottomRight;
    }

    public void setBottomRight(Point bottomRight) {
        this.bottomRight = bottomRight;
    }

    public Point getBottomLeft() {
        return bottomLeft;
    }

    public void setBottomLeft(Point bottomLeft) {
        this.bottomLeft = bottomLeft;
    }

    @Override
    public String toString() {
        return "Square{" +
                "topLeft=" + topLeft +
                ", topRight=" + topRight +
                ", bottomRight=" + bottomRight +
                ", bottomLeft=" + bottomLeft +
                ", len=" + len +
                '}';
    }
}
