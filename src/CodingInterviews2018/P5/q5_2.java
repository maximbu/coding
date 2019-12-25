package CodingInterviews2018.P5;

public class q5_2 {
    private static String binToString(double x) {
        if (x < 0 || x > 1) {
            throw new IllegalArgumentException();
        }
        double frac = 0.5;
        var s = new StringBuilder();
        s.append('.');
        while (x > 0) {
            if (s.length() > 32) {
                return "ERROR";
            }
            if (x >= frac) {
                s.append(1);
                x -= frac;
            } else {
                s.append(0);
            }
            frac /= 2;
        }
        return s.toString();


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
