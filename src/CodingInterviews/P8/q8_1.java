package CodingInterviews.P8;


/**
 * Created by max on 12/25/2016.
 */
public class q8_1 {
    public static long tripleStep(int n) {
        long[] a = new long[n + 1];
        if (n < 3) {
            return n;
        }
        a[0] = 1;
        a[1] = 1;
        a[2] = 2;
        for (int i = 3; i < n + 1; i++) {
            a[i] = a[i - 1] + a[i - 2] + a[i - 3];
        }
        return a[n];
    }


    public static void main(String[] st){
        for (int i = 0; i < 30; i++) {
            System.out.println(i + ": " + tripleStep(i));
        }
    }
}
