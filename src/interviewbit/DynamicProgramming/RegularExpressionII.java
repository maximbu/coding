package interviewbit.DynamicProgramming;

/**
 * Implement regular expression matching with support for '.' and '*'.
 *
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 *
 * The matching should cover the entire input string (not partial).
 *
 * The function prototype should be:
 *
 * int isMatch(const char *s, const char *p)
 * Some examples:
 *
 * isMatch("aa","a") → 0
 * isMatch("aa","aa") → 1
 * isMatch("aaa","aa") → 0
 * isMatch("aa", "a*") → 1
 * isMatch("aa", ".*") → 1
 * isMatch("ab", ".*") → 1
 * isMatch("aab", "c*a*b") → 1
 * Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 */
public class RegularExpressionII {

    public int isMatch(final String A, final String B) {
        if (B.length() == 0) {
            return A.length() == 0 ? 1 : 0;
        }

        if (nextStar(B) && isMatch(A, B.substring(2)) == 1) {
            return 1;
        }
        if (A.length() == 0 || !firstCharMatch(A, B)) {
            return 0;
        }

        return isMatch(A.substring(1), B.substring(nextStar(B) ? 0 : 1));
    }

    private boolean firstCharMatch(final String A, final String B) {
        return A.charAt(0) == B.charAt(0) || B.charAt(0) == '.';
    }

    private boolean nextStar(String p) {
        return p.length() >= 2 && p.charAt(1) == '*';
    }


    public static void main(String[] st) {
        RegularExpressionII q = new RegularExpressionII();
        System.out.println(q.isMatch("efwihfioghih35i", ".*"));
        System.out.println(q.isMatch("abaabaaabbbbbababbbabaaababbbbbbbababbaabaabbaaabbabbaabbbabbbaabbabbaabaaaabbbaabbbaaa", "."));
    }

}
