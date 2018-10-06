package interviewbit.DynamicProgramming;

import java.util.ArrayList;

/**
 * Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 *
 * For example, given
 *
 * s = "myinterviewtrainer",
 * dict = ["trainer", "my", "interview"].
 * Return 1 ( corresponding to true ) because "myinterviewtrainer" can be segmented as "my interview trainer".
 *
 * Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 */
public class WordBreak {

    public int wordBreak(String A, ArrayList<String> B) {
        boolean[] dp = new boolean[A.length()];
        for (int i = -1; i < A.length(); i++) {
            if (i == -1 || dp[i]) {
                String sub = A.substring(i + 1);
                for (String w : B) {
                    if (sub.startsWith(w)) {
                        dp[i + w.length()] = true;
                    }
                }
            }
        }
        return dp[A.length() - 1] ? 1 : 0;
    }
}
