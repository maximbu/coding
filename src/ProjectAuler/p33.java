package ProjectAuler;


/**
 * Created by max on 1/27/2017.
 */
public class p33 {
    /*
The fraction 49/98 is a curious fraction, as an inexperienced mathematician in attempting to simplify it may incorrectly believe that 49/98 = 4/8, which is correct, is obtained by cancelling the 9s.
We shall consider fractions like, 30/50 = 3/5, to be trivial examples.
There are exactly four non-trivial examples of this type of fraction, less than one in value, and containing two digits in the numerator and denominator.
If the product of these four fractions is given in its lowest common terms, find the value of the denominator.
*/


    public double questionNaive() {
        double mult = 1;
        for (int i = 11; i < 100; i++) {
            if (i % 10 == 0) continue;
            int down1 = i / 10;
            int down2 = i % 10;
            for (int j = 11; j < i; j++) {
                if (j % 10 == 0) continue;
                int up1 = j / 10;
                int up2 = j % 10;
                if (down1 == up1) {
                    mult *= multiplier(i, down2, j, up2);
                }
                if (down1 == up2) {
                    mult *= multiplier(i, down2, j, up1);
                }
                if (down2 == up1) {
                    mult *= multiplier(i, down1, j, up2);
                }
                if (down2 == up2) {
                    mult *= multiplier(i, down1, j, up1);
                }
            }

        }
        return 1 / mult;
    }

    private double multiplier(int i, int down, double j, int up) {
        if (Math.abs((double) up / down - j / i) < 0.0001) {
            System.out.print(j + "/" + i + "--->" + up + "/" + down);
            for (int k = 2; k < 4; k++) {
                while (up % k == 0 && down % k == 0) {
                    up /= k;
                    down /= k;
                }
            }
            System.out.println("--->" + up + "/" + down);
            return (double) up / down;

        }
        return 1;
    }


    public static void main(String[] st) {
        p33 q = new p33();
        System.out.println(q.questionNaive());
    }
}
