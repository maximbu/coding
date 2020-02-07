package CodingInterviews2018.P16;

public class SubSortResult {
    int from;
    int to;

    public SubSortResult(int from, int to) {
        this.from = from;
        this.to = to;
    }

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }

    @Override
    public String toString() {
        return "SubSortResult{" +
                "from=" + from +
                ", to=" + to +
                '}';
    }
}
