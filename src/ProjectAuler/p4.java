package ProjectAuler;

/**
 * Created by max on 1/27/2017.
 */
public class p4 {
    /*
   A palindromic number reads the same both ways.
   The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
    Find the largest palindrome made  nfrom the product of two 3-digit numbers.
     */
    public static int questionNaive() {
        int max = 0;
        int lastj = 900;
        for (int i = 999; i > 900; i--) {
            for (int j = 999; j > 900; j--) {
                if (j == lastj) return max;
                int n = i * j;
                if (isPalindrom(n) && n > max) {
                    max = n;
                    lastj = j;
                }
            }
        }
        return max;
    }

    private static boolean isPalindrom(int n) {
        int tmp = n;
        int rev = 0;
        while (tmp > 0) {
            rev = rev * 10 + tmp % 10;
            tmp = tmp / 10;
        }
        return n == rev;
    }

    public static void main(String[] st) {
        p4 q = new p4();
        System.out.println(questionNaive());
    }
}
