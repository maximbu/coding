package interviewbit.DynamicProgramming;

/**
 * Implement wildcard pattern matching with support for '?' and '*'.
 *
 * '?' : Matches any single character.
 * '*' : Matches any sequence of characters (including the empty sequence).
 * The matching should cover the entire input string (not partial).
 *
 * The function prototype should be:
 *
 * int isMatch(const char *s, const char *p)
 * Examples :
 *
 * isMatch("aa","a") → 0
 * isMatch("aa","aa") → 1
 * isMatch("aaa","aa") → 0
 * isMatch("aa", "*") → 1
 * isMatch("aa", "a*") → 1
 * isMatch("ab", "?*") → 1
 * isMatch("aab", "c*a*b") → 0
 * Return 1/0 for this problem.
 */
public class RegularExpressionMatch {
    public int isMatch(final String A, final String B) {
        int Ai = 0;
        int Bi = 0;
        int starIndex = -1;
        int iIndex = -1;

        while (Ai < A.length()) {
            if (Bi < B.length() && (B.charAt(Bi) == '?' || B.charAt(Bi) == A.charAt(Ai))) {
                Ai++;
                Bi++;
                continue;
            }
            if (Bi < B.length() && B.charAt(Bi) == '*') {
                starIndex = Bi;
                iIndex = Ai;
                Bi++;
                continue;
            }
            if (starIndex != -1) {
                Bi = starIndex + 1;
                iIndex++;
                Ai = iIndex;

                continue;
            }
            return 0;
        }

        while (Bi < B.length() && B.charAt(Bi) == '*') {
            ++Bi;
        }

        return Bi == B.length() ? 1 : 0;
    }

    public static void main(String[] st){
        RegularExpressionMatch q = new RegularExpressionMatch();
        System.out.println(q.isMatch("cacab","**bcbbac?ba"));
        System.out.println(q.isMatch("cbcc","*??c*?c*b?"));
        System.out.println(q.isMatch("a","?"));
        System.out.println(q.isMatch("aa","?"));
        System.out.println(q.isMatch("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","a**************************************************************************************"));
        System.out.println(q.isMatch("aabbaaabbbaa","a*bbb*aaa"));
        System.out.println(q.isMatch("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","*b"));
    }
}
