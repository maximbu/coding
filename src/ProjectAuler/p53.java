package ProjectAuler;


import java.math.BigInteger;

/**
 * Created by max on 1/27/2017.
 */
public class p53 {
    /*
There are exactly ten ways of selecting three from five, 12345:
123, 124, 125, 134, 135, 145, 234, 235, 245, and 345
In combinatorics, we use the notation, 5C3 = 10.
In general,
nCr =
n!
r!(n−r)!
,where r ≤ n, n! = n×(n−1)×...×3×2×1, and 0! = 1.
It is not until n = 23, that a value exceeds one-million: 23C10 = 1144066.
How many, not necessarily distinct, values of  nCr, for 1 ≤ n ≤ 100, are greater than one-million?
*/


    public int questionNaive(int max) {
        int cnt = 0;
        BigInteger[] fact = getFact(101);

        for (int n = 1; n <= 100; n++) {
            for (int r = 1; r <= n; r++) {
                BigInteger nCr = fact[n].divide(fact[r].multiply(fact[n - r]));
                if (nCr.compareTo(BigInteger.valueOf(max)) > 0) cnt++;
            }
        }
        return cnt;
    }

    private BigInteger[] getFact(int n) {
        BigInteger[] ans = new BigInteger[n + 1];
        ans[0] = BigInteger.valueOf(1);
        for (int i = 1; i < n; i++) {
            ans[i] = ans[i - 1].multiply(BigInteger.valueOf(i));
        }
        return ans;
    }


    public static void main(String[] st) {
        p53 q = new p53();
        System.out.println(q.questionNaive(1000000));
    }
}
