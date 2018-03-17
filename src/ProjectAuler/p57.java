package ProjectAuler;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 * Created by max on 3/18/2017.
 */
public class p57 {
    /*
    It is possible to show that the square root of two can be expressed as an infinite continued fraction.

√ 2 = 1 + 1/(2 + 1/(2 + 1/(2 + ... ))) = 1.414213...

By expanding this for the first four iterations, we get:

1 + 1/2 = 3/2 = 1.5
1 + 1/(2 + 1/2) = 7/5 = 1.4
1 + 1/(2 + 1/(2 + 1/2)) = 17/12 = 1.41666...
1 + 1/(2 + 1/(2 + 1/(2 + 1/2))) = 41/29 = 1.41379...

The next three expansions are 99/70, 239/169, and 577/408, but the eighth expansion, 1393/985, is the first example where the number of digits in the numerator exceeds the number of digits in the denominator.

In the first one-thousand expansions, how many fractions contain a numerator with more digits than denominator?
     */

    public static void main(String[] st) {
        p57 q = new p57();
        System.out.println(q.questionNaive());

    }

    private int questionNaive() {
        int cnt = 0;
        BigInteger up = new BigInteger("3");
        BigInteger down = new BigInteger("2");
        BigInteger two = new BigInteger("2");
        //double up = 3;
        //double down = 2;
        for (int i = 1; i < 1000; i++) {
            up = up.add(two.multiply(down));
            down = up.subtract(down);
            if (up.toString().length() > down.toString().length())
                cnt++;
        }
        return cnt;
    }
}
