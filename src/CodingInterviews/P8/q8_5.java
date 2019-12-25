package CodingInterviews.P8;

/**
 * Created by max on 12/27/2016.
 */
public class q8_5 {
    public static int multiply(int a, int b) {
        return a < b ? multiplyRec(a, b) : multiplyRec(b, a);
    }

    private static int multiplyRec(int sm, int bg) {
        if (sm == 0) return 0;
        if (sm == 1) return bg;
        int halfSum = multiplyRec(sm >> 1, bg);
        int retVal = halfSum + halfSum;
        if ((sm & 1) == 1) {
            retVal += bg;
        }
        return retVal;
    }

    public static void main(String[] st) {
        int x = multiply(13, 7);
        if (x != 13 * 7) {
            throw new RuntimeException("Wrong !!!!");
        }

        x = multiply(8, 9);
        if (x != 72) {
            throw new RuntimeException("Wrong !!!!");
        }
    }
}
