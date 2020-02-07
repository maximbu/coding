package CodingInterviews2018.P16;

public class Pair<T, U> {
    private T op1;
    private U op2;

    public Pair(T op1, U op2) {
        this.op1 = op1;
        this.op2 = op2;
    }

    public T getOp1() {
        return op1;
    }

    public U getOp2() {
        return op2;
    }


    @Override
    public String toString() {
        return String.format("{%s , %s}", op1, op2);
    }
}
