package CodingInterviews2018.P16;

public class Location {
    private Cell cell;
    private Orientation orientation;

    public Location(Cell cell, Orientation orientation) {
        this.cell = cell;
        this.orientation = orientation;
    }

    public Cell getCell() {
        return cell;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    @Override
    public String toString() {
        return "Location{" +
                "cell=" + cell +
                ", orientation=" + orientation +
                '}';
    }
}
