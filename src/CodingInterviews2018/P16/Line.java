package CodingInterviews2018.P16;

import java.util.Objects;

public class Line {
    private Point start;
    private Point end;

    private double A;
    private double B;

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
        A = Math.abs((start.getY() - end.getY()) / (start.getX() - end.getX()));
        B = Double.isInfinite(A) ? start.getX() : start.getY() - A * start.getX();
    }

    public double getA() {
        return A;
    }

    public double getB() {
        return B;
    }

    public Point getStart() {
        return start;
    }

    public Point getEnd() {
        return end;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Double.compare(line.A, A) == 0 &&
                Double.compare(line.B, B) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(A, B);
    }

    @Override
    public String toString() {
        return "Section{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}
