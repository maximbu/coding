package interviewbit.DynamicProgramming;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 *
 * Return the minimum cuts needed for a palindrome partitioning of s.
 *
 * Example :
 * Given
 * s = "aab",
 * Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
 */
public class PalindromePartitioningII {
    public int minCut(String A) {
        boolean[][] dp = new boolean[A.length()][A.length()];
        int[] cut = new int[A.length()];

        for (int j = 0; j < A.length(); j++) {
            cut[j] = j;
            for (int i = 0; i <= j; i++) {
                if (A.charAt(i) == A.charAt(j) && (j - i <= 1 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    cut[j] = (i == 0 ? 0 : Math.min(cut[j], cut[i - 1] + 1));
                }
            }
        }

        return cut[cut.length - 1];
    }
}
