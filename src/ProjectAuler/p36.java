package ProjectAuler;


/**
 * Created by max on 1/27/2017.
 */
public class p36 {
    /*
The decimal number, 585 = 1001001001 (binary), is palindromic in both bases.
Find the sum of all numbers, less than one million, which are palindromic in base 10 and base 2.
(Please note that the palindromic number, in either base, may not include leading zeros.)
*/


    public int questionNaive(int n) {
        int cnt = 0;
        for (int i = 1; i < n; i++) {
            if (isPalindromic(i)) {
                cnt += i;
            }
        }
        return cnt;
    }

    private boolean isPalindromic(int i) {
        return isPalindromicBase10(i) && isPalindromicBase2(i);
    }

    private boolean isPalindromicBase2(int i) {
        int x = 0;
        int orig = i;
        while (i > 0) {
            int d = i & 1;
            i = i >> 1;
            x = x << 1;
            x = x | d;
        }
        return x == orig;
    }

    private boolean isPalindromicBase10(int i) {
        int x = 0;
        int orig = i;
        while (i > 0) {
            int d = i % 10;
            i /= 10;
            x = x * 10 + d;
        }
        return x == orig;
    }


    public static void main(String[] st) {
        p36 q = new p36();
        System.out.println(q.isPalindromic(585));
        System.out.println(q.questionNaive(1000000));
    }
}
