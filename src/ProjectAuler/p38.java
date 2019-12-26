package ProjectAuler;


/**
 * Created by max on 1/27/2017.
 */
public class p38 {
    /*
Take the number 192 and multiply it by each of 1, 2, and 3:
192 × 1 = 192
192 × 2 = 384
192 × 3 = 576
By concatenating each product we get the 1 to 9 pandigital, 192384576. We will call 192384576 the concatenated product of 192 and (1,2,3)
The same can be achieved by starting with 9 and multiplying by 1, 2, 3, 4, and 5, giving the pandigital, 918273645, which is the concatenated product of 9 and (1,2,3,4,5).
What is the largest 1 to 9 pandigital 9-digit number that can be formed as the concatenated product of an integer with (1,2, ... , n) where n > 1?
*/


    public int questionNaive() {
        int largest = 0;
        for (int i = 1; i < 10000; i++) {
            int p = getLargestProduct(i);
            if (largest < p && isPandigital(p)) {
                largest = p;
            }
        }

        return largest;
    }

    private int getLargestProduct(int i) {
        long ans = 0;
        long prevHighest = 0;
        for (int j = 1; j < 10; j++) {
            ans = Long.parseLong(String.valueOf(ans) + j * i);
            if (ans > 987654321) {
                ans = prevHighest;
                break;
            }
            prevHighest = ans;
        }
        return (int) ans;
    }

    private boolean isPandigital(int p) {
        boolean[] digits = new boolean[10];
        while (p > 0) {
            int d = p % 10;
            if (d == 0) return false;
            if (digits[d]) return false;
            digits[d] = true;
            p /= 10;
        }
        int i = 9;
        while (i > 0) {
            if (!digits[i--]) return false;
        }
        return true;
    }


    public static void main(String[] st) {
        p38 q = new p38();
        System.out.println(q.questionNaive());
    }
}
