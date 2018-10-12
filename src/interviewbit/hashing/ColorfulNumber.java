package interviewbit.hashing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * For Given Number N find if its COLORFUL number or not
 *
 * Return 0/1
 *
 * COLORFUL number:
 *
 * A number can be broken into different contiguous sub-subsequence parts.
 * Suppose, a number 3245 can be broken into parts like 3 2 4 5 32 24 45 324 245.
 * And this number is a COLORFUL number, since product of every digit of a contiguous subsequence is different
 * Example:
 *
 * N = 23
 * 2 3 23
 * 2 -> 2
 * 3 -> 3
 * 23 -> 6
 * this number is a COLORFUL number since product of every digit of a sub-sequence are different.
 *
 * Output : 1
 */
public class ColorfulNumber {

    public int colorful(int A) {
        String x = String.valueOf(A);
        List<String> l = new ArrayList<>();
        for (int s = 1; s <= x.length(); s++) {
            for (int i = 0; i < x.length() - s + 1; i++) {
                l.add(x.substring(i, i + s));
            }
        }
        HashSet<Integer> seen = new HashSet<>();
        for (String t : l) {
            int n = Integer.valueOf(t);
            int mul = 1;
            while (n > 0) {
                mul *= n % 10;
                n /= 10;
            }
            if (!seen.add(mul)) {
                return 0;
            }
        }
        return 1;
    }

    public static void main(String[] st){
        ColorfulNumber q = new ColorfulNumber();
        System.out.println(q.colorful(99));
    }
}
