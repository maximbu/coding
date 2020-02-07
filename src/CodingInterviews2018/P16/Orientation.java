package CodingInterviews2018.P16;

public enum Orientation {
    Top,
    Right,
    Bottom,
    Left;

    public static final Orientation[] values = values();

    public Orientation rotate(boolean clockwise) {
        return values[(4 + ordinal() + (clockwise ? 1 : -1)) % 4];
    }
}
