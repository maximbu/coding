package interviewbit.math;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by max on 7/17/2017.
 * Hamming distance between two non-negative integers is defined as the number of positions at which the corresponding bits are different.

 For example,

 HammingDistance(2, 7) = 2, as only the first and the third bit differs in the binary representation of 2 (010) and 7 (111).

 Given an array of N non-negative integers, find the sum of hamming distances of all pairs of integers in the array.
 Return the answer modulo 1000000007.
 */
public class SumOfPairwiseHammingDistance {
    public static void main(String[] st) {
        SumOfPairwiseHammingDistance q = new SumOfPairwiseHammingDistance();

        ArrayList<Integer> a = new ArrayList<>();
        a.add(2); // 0010
        a.add(4); // 0100
        a.add(6); // 0110
        System.out.println(q.hammingDistance(a));

        a = new ArrayList<>();
        a.add(Integer.MAX_VALUE);
        a.add(0);
        System.out.println(q.hammingDistance(a));
        System.out.println(d(Integer.MAX_VALUE,0));
    }

    public static int d(int x, int y) {
        int dist = 0;
        int val = x ^ y;

        // Count the number of set bits (Knuth's algorithm)
        while (val != 0) {
            ++dist;
            val &= val - 1;
        }

        return dist;
    }


    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int hammingDistance(final List<Integer> A) {
        int cnt =0;
        int modulo = 1000000007;
        for (int i = 0; i < 32; i++) {
            int endsWithZero = 0;
            int endsWithOne = 0;
            for (Integer num : A) {
                if ((num & (1<<i)) == 0) {
                    endsWithZero++;
                } else {
                    endsWithOne++;
                }
            }
            cnt = (int)((cnt + (2L*endsWithOne*endsWithZero)) % modulo);
        }
        return cnt;
    }
}
