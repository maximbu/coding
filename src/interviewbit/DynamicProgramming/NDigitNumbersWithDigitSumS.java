package interviewbit.DynamicProgramming;

/**
 * Find out the number of N digit numbers, whose digits on being added equals to a given number S. Note that a valid number starts from digits 1-9 except the number 0 itself. i.e. leading zeroes are not allowed.
 *
 * Since the answer can be large, output answer modulo 1000000007
 *
 *  N = 2, S = 4
 * Valid numbers are {22, 31, 13, 40}
 * Hence output 4.
 */
public class NDigitNumbersWithDigitSumS {
    public int solve(int A, int B) {
        Integer[][] lookup = new Integer[A + 1][B + 1];
        return countRec(A , B, lookup , true);
    }

    private int countRec(int n, int sum, Integer[][] lookup , boolean first) {
        if (n == 0) {
            return sum == 0 ? 1 : 0;
        }
        if (lookup[n][sum] != null) {
            return lookup[n][sum];
        }
        long ans = 0;

        for (int i = (first ? 1 : 0); i <= Math.min(9,sum); i++) {
            ans += countRec(n - 1, sum - i, lookup, false);
        }
        lookup[n][sum] = (int)(ans % 1000000007);
        return lookup[n][sum];
    }
}
