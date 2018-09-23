package interviewbit.strings;

import java.util.HashMap;

/**
 * Given a string S, find the longest palindromic substring in S.
 *
 * Substring of string S:
 *
 * S[i...j] where 0 <= i <= j < len(S)
 *
 * Palindrome string:
 *
 * A string which reads the same backwards. More formally, S is palindrome if reverse(S) = S.
 *
 * Incase of conflict, return the substring which occurs first ( with the least starting index ).
 *
 * Example :
 *
 * Input : "aaaabaaa"
 * Output : "aaabaaa"
 */
public class LongestPalindromicSubstring {

    public String longestPalindrome(String A) {
        int maxLen = 0;
        String ans = "";
        HashMap<Integer, HashMap<Integer, Boolean>> map = new HashMap<>();
        for (int i = 0; i < A.length(); i++) {
            for (int j = A.length() - 1; j >= i; j--) {
                if (j - i + 1 > maxLen && isPalindrome(A, i, j, map)) {
                    maxLen = j - i + 1;
                    ans = A.substring(i, j + 1);
                }
            }
        }
        return ans;
    }

    private boolean isPalindrome(String A, int from, int to, HashMap<Integer, HashMap<Integer, Boolean>> map) {
        if (from > to)
            return false;
        boolean ans = true;
        int origFrom = from;
        int origTo = to;
        while (from < to) {
            if (map.containsKey(from)) {
                HashMap<Integer, Boolean> tmp = map.get(from);
                if (tmp.containsKey(to)) {
                    return tmp.get(to);
                }
            }
            if (A.charAt(from) != A.charAt(to)) {
                ans = false;
                break;
            }
            from++;
            to--;
        }
        HashMap<Integer, Boolean> tmp;
        if (map.containsKey(origFrom)) {
            tmp = map.get(origFrom);
        } else {
            tmp = new HashMap<>();
            map.put(origFrom, tmp);
        }
        tmp.put(origTo, ans);
        return ans;
    }
}
