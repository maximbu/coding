package CodingInterviews.P5;

/**
 * Created by max on 12/25/2016.
 */
public class q5_2 {
    public static String binToString(double d) {
        if (d < 0 || d > 1) {
            return "ERROR";
        }
        StringBuilder b = new StringBuilder();
        b.append(".");
        while (d > 0) {
            if (b.length() >= 32) {
                return "ERROR";
            }
            int digit = d * 2 >= 1 ? 1 : 0;
            b.append(digit);
            d = d * 2 - digit;
        }
        return b.toString();
    }

    public static void main(String[] args) {
        String bs = binToString(.125);
        System.out.println(bs);

        for (int i = 0; i < 1000; i++) {
            double num = i / 1000.0;
            String binary = binToString(num);
            if (!binary.equals("ERROR")) {
                System.out.println(num + " : " + binary);
            }
        }
    }
}
