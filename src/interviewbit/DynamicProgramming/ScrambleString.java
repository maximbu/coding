package interviewbit.DynamicProgramming;

/**
 * Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.
 *
 * Below is one possible representation of s1 = “great”:
 *
 *
 *     great
 *    /    \
 *   gr    eat
 *  / \    /  \
 * g   r  e   at
 *            / \
 *           a   t
 *
 * To scramble the string, we may choose any non-leaf node and swap its two children.
 *
 * For example, if we choose the node “gr” and swap its two children, it produces a scrambled string “rgeat”.
 *
 *     rgeat
 *    /    \
 *   rg    eat
 *  / \    /  \
 * r   g  e   at
 *            / \
 *           a   t
 * We say that “rgeat” is a scrambled string of “great”.
 *
 * Similarly, if we continue to swap the children of nodes “eat” and “at”, it produces a scrambled string “rgtae”.
 *
 *     rgtae
 *    /    \
 *   rg    tae
 *  / \    /  \
 * r   g  ta  e
 *        / \
 *       t   a
 * We say that “rgtae” is a scrambled string of “great”.
 *
 * Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1. Return 0/1 for this problem.
 */
public class ScrambleString {

    public int isScramble(final String A, final String B) {
        if (A.equals(B)) return 1;

        if( A.length() != B.length()) {
            return 0;
        }
        int[] l = new int[256];
        for (int i=0; i<A.length(); i++) {
            l[A.charAt(i)]++;
            l[B.charAt(i)]--;
        }
        for (int x : l) {
            if (x != 0) {
                return 0;
            }
        }
        for (int i=1; i<A.length(); i++) {
            if (isScramble(A.substring(0, i), B.substring(0, i))
                    * isScramble(A.substring(i), B.substring(i)) == 1
                    ||
                    isScramble(A.substring(0, i), B.substring(B.length() - i))
                    * isScramble(A.substring(i), B.substring(0, B.length() - i)) == 1) {
                return 1;
            }
        }
        return 0;
    }


    public static void main(String[] st){
        ScrambleString q = new ScrambleString();
        System.out.println(q.isScramble("abbbcbaaccacaacc","acaaaccabcabcbcb"));
        System.out.println(q.isScramble("ABCDE","CAEBD"));
    }
}
