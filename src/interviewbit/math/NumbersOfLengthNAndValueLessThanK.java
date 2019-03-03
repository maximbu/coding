package interviewbit.math;

import java.util.ArrayList;

/**
 * Given a set of digits (A) in sorted order, find how many numbers of length B are possible whose value is less than number C.

 NOTE: All numbers can only have digits from the given set.
 **/
public class NumbersOfLengthNAndValueLessThanK {

    public static void main(String[] st) {
        NumbersOfLengthNAndValueLessThanK q = new NumbersOfLengthNAndValueLessThanK();

        int N = 1;
        int K = 2;
        ArrayList<Integer> a = new ArrayList<>();
        //a.add(3);
        a.add(0);
        a.add(1);
        a.add(5);
        System.out.println(q.solve(a, N, K));

        N = 2;
        K = 21;
        a = new ArrayList<>();
        //a.add(4);
        a.add(0);
        a.add(1);
        a.add(2);
        a.add(5);
        System.out.println(q.solve(a, N, K));

        N = 5;
        K = 42950;
        a = new ArrayList<>();
        //a.add(4);
        a.add(2);
        a.add(3);
        a.add(5);
        a.add(6);
        a.add(7);
        a.add(9);
        System.out.println(q.solve(a, N, K));
    }


    public int solve(ArrayList<Integer> A, int B, int C) {
        int cLen = String.valueOf(C).length();
        int n = A.size();
        if (cLen < B || n == 0)
            return 0;
        boolean hasZero = (A.get(0) == 0);
        if (cLen > B) {
            // all combinations
            if (B == 1) {
                return n;
            } else {
                int allCombinations = (int) Math.pow(n, B);
                return hasZero ? allCombinations * (n - 1) / n : allCombinations;
            }
        }
        // B == cLen
        int pow10 = (int) Math.pow(10, B - 1);
        int count = 0;
        for (int i = B; i > 0; i--) {
            int relevantDigit = C / pow10;
            C %= pow10;
            pow10 /= 10;
            int j = 0;
            while (j < n && A.get(j) < relevantDigit) {
                j++;
            }
            int combinations = j * (int) Math.pow(n, i - 1);
            if (i == B && hasZero && B > 1) {
                combinations = combinations * (j - 1) / j;
            }
            count += combinations;
            if (j == n || A.get(j) > relevantDigit)
                break;
        }
        return count;
    }
}
