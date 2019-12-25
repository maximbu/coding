package CodingInterviews.P16;

/**
 * Created by max on 1/21/2017.
 */
public class q16_7 {
    private int sign(int a) {
        return ((a >> 31) & 1);
    }

    public int max(int a, int b) {
        int s = sign(a - b);
        return a - (a - b) * s;
    }

    public static void main(String[] st) {
        q16_7 q = new q16_7();
        System.out.println(q.sign(15));
        System.out.println(q.sign(8));
        System.out.println(q.max(-16, -15));
    }
}
