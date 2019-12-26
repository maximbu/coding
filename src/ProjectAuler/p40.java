package ProjectAuler;


/**
 * Created by max on 1/27/2017.
 */
public class p40 {
    /*
An irrational decimal fraction is created by concatenating the positive integers:
0.123456789101112131415161718192021...
It can be seen that the 12th digit of the fractional part is 1.
If dn represents the nth digit of the fractional part, find the value of the following expression.
d1 × d10 × d100 × d1000 × d10000 × d100000 × d1000000
*/


    public int questionNaive(int n) {
        int cnt = 1;
        StringBuilder sb = new StringBuilder();
        int i = 1;
        while (sb.length() < n) {
            sb.append(i);
            i++;
        }
        int t = 1;
        while (t < n) {
            cnt *= sb.charAt(t - 1) - '0';
            t *= 10;
        }
        return cnt;
    }


    public static void main(String[] st) {
        p40 q = new p40();
        System.out.println(q.questionNaive(1000000));
    }
}
