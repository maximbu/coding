package CodingInterviews.P17;

/**
 * Created by max on 1/4/2017.
 */
public class p17_q1 {
    public static int add(int x, int y) {
        if (x == 0) return y;
        if (y == 0) return x;
        int sum = x ^ y;
        int carry = (x & y) << 1;
        return add(sum, carry);
    }

    public static void main(String[] st) {
        System.out.println("4+5=" + add(4, 5));
        System.out.println("993+997=" + add(993, 997));
    }
}
