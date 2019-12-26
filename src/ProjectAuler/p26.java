package ProjectAuler;

import java.util.HashSet;


/**
 * Created by max on 1/27/2017.
 */
public class p26 {
    /*
A unit fraction contains 1 in the numerator. The decimal representation of the unit fractions with denominators 2 to 10 are given:
1/2	= 	0.5
1/3	= 	0.(3)
1/4	= 	0.25
1/5	= 	0.2
1/6	= 	0.1(6)
1/7	= 	0.(142857)
1/8	= 	0.125
1/9	= 	0.(1)
1/10	= 	0.1
Where 0.1(6) means 0.166666..., and has a 1-digit recurring cycle. It can be seen that 1/7 has a 6-digit recurring cycle.
Find the value of d < 1000 for which 1/d contains the longest recurring cycle in its decimal fraction part.
     */


    public int questionNaive(int n) {
        int longest = 0;
        int longestI = 1;
        for (int i = 2; i < n; i++) {
            int reoc = numOfReoc(i);
            if (reoc > longest) {
                longest = reoc;
                longestI = i;
            }
        }
        return longestI;
    }

    private int numOfReoc(int i) {
        HashSet<Integer> set = new HashSet<>();
        int len = 0;
        int r = 10;
        while (true) {
            r = 10 * (r % i);
            if (r == 0) return len;
            if (set.contains(r)) return len;
            set.add(r);
            len++;
        }
    }


    public static void main(String[] st) {
        p26 q = new p26();
        System.out.println(q.questionNaive(1000));
    }
}
