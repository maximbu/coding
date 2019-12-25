package CodingInterviews.P16;

import java.util.HashSet;

/**
 * Created by max on 1/22/2017.
 */
public class q16_11 {
    public static void main(String[] s) {
        q16_11 q = new q16_11();
        System.out.println(q.allLengths(7, 5, 12));
    }

    public HashSet<Integer> allLengths(int k, int shorter, int longer) {
        HashSet<Integer> len = new HashSet<Integer>();
        for (int s = 0; s <= k; s++) {
            len.add(s * shorter + (k - s) * longer);
        }
        return len;
    }


}
