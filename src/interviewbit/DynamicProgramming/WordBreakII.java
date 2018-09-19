package interviewbit.DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.
 *
 * Return all such possible sentences.
 *
 * For example, given
 *
 * s = "catsanddog",
 * dict = ["cat", "cats", "and", "sand", "dog"].
 * A solution is
 *
 * [
 *   "cat sand dog",
 *   "cats and dog"
 * ]
 * Make sure the strings are sorted in your result.
 */
public class WordBreakII {

    public ArrayList<String> wordBreak(String A, ArrayList<String> B) {
        HashSet<String> dict = new HashSet<>(B);
        ArrayList<String> ans = new ArrayList<>();
        wordBreak(A, "", dict, ans);
        ans.sort(String::compareTo);
        return ans;
    }

    private void wordBreak(String A, String soFar, HashSet<String> dict, ArrayList<String> ans) {
        if (dict.contains(A)) {
            ans.add((soFar + " " + A).substring(1));
        }
        for (String w : dict) {
            if (A.startsWith(w)) {
                String tmp = soFar;
                soFar = soFar + " " + w;
                wordBreak(A.substring(w.length()), soFar, dict, ans);
                soFar = tmp;
            }
        }
    }

    public static void main(String[] st) {
        WordBreakII q = new WordBreakII();

        String A = "catsanddog";
        ArrayList<String> B = new ArrayList<>(Arrays.asList("cat", "cats", "and", "sand", "dog"));
        System.out.println(q.wordBreak(A, B));

        A = "bbabbbababbaabaabbabbabaa";
        B = new ArrayList<>(Arrays.asList("abaabaaabb", "ab", "a", "b", "aabbbbbabb", "abaabb", "babbaa", "bbabab", "aa"));
        System.out.println(q.wordBreak(A, B));
    }
}
