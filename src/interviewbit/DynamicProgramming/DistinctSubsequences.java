package interviewbit.DynamicProgramming;

import java.util.stream.IntStream;

/**
 * Given two sequences S, T, count number of unique ways in sequence S, to form a subsequence that is identical to the sequence T.
 *
 *  Subsequence : A subsequence of a string is a new string which is formed from the original string by deleting some (can be none ) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
 * Example :
 *
 * S = "rabbbit"
 * T = "rabbit"
 * Return 3. And the formations as follows:
 *
 * S1= "ra_bbit"
 * S2= "rab_bit"
 * S3="rabb_it"
 * "_" marks the removed character.
 */
public class DistinctSubsequences {

    public int numDistinct(String A, String B) {
        if (A.length() < B.length())
            return 0;
        if (A.length() == B.length())
            return A.equals(B) ? 1 : 0;
        if (B.length() == 1) {
            return count(A, B.charAt(0));
        }
        int ans = 0;
        for (int i = 0; i < A.length() - B.length() + 1; i++) {
            if (A.charAt(i) == B.charAt(0)) {
                ans += numDistinct(A.substring(i + 1), B.substring(1));
            }
        }
        return ans;
    }

    private int count(String A, char b) {
        return (int) IntStream.range(0, A.length()).filter(i -> A.charAt(i) == b).count();
    }
}
