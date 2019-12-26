package ProjectAuler;


/**
 * Created by max on 1/27/2017.
 */
public class p55 {
    /*
If we take 47, reverse and add, 47 + 74 = 121, which is palindromic.
Not all numbers produce palindromes so quickly. For example,
349 + 943 = 1292,
1292 + 2921 = 4213
4213 + 3124 = 7337
That is, 349 took three iterations to arrive at a palindrome.
Although no one has proved it yet, it is thought that some numbers, like 196, never produce a palindrome. A number that never forms a palindrome through the reverse and add process is called a Lychrel number. Due to the theoretical nature of these numbers, and for the purpose of this problem, we shall assume that a number is Lychrel until proven otherwise. In addition you are given that for every number below ten-thousand, it will either (i) become a palindrome in less than fifty iterations, or, (ii) no one, with all the computing power that exists, has managed so far to map it to a palindrome. In fact, 10677 is the first number to be shown to require over fifty iterations before producing a palindrome: 4668731596684224866951378664 (53 iterations, 28-digits).
Surprisingly, there are palindromic numbers that are themselves Lychrel numbers; the first example is 4994.
How many Lychrel numbers are there below ten-thousand?
*/


    public int questionNaive(int n) {
        int cnt = 0;
        for (int i = 10; i < n; i++) {
            if (isLychrel(i)) {
                cnt++;
                System.out.println(i + ", ");
            }
        }
        return cnt;
    }

    private long inverse(long a) {
        long ans = 0;
        while (a > 0) {
            ans = ans * 10 + a % 10;
            a /= 10;
        }
        return ans;
    }

    private boolean isPalindrome(long x) {
        return x == inverse(x);
    }

    private boolean isLychrel(int x) {
        long s = x;
        for (int i = 0; i < 50; i++) {
            s += inverse(s);
            if (isPalindrome(s)) return false;
        }
        return true;
    }


    public static void main(String[] st) {
        p55 q = new p55();
        System.out.println(q.questionNaive(10000));
    }
}
