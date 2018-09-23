package interviewbit.strings;

/**
 * Implement strStr().
 *
 *  strstr - locate a substring ( needle ) in a string ( haystack ).
 * Try not to use standard library string functions for this question.
 *
 * Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 *  NOTE: Good clarification questions:
 * What should be the return value if the needle is empty?
 * What if both haystack and needle are empty?
 * For the purpose of this problem, assume that the return value should be -1 in both cases.
 */
public class ImplementStrStr {

    public int strStr(final String A, final String B) {
        int n = A.length() - B.length();
        if (A.length() == 0 || n < 0)
            return -1;
        for (int i = 0; i < A.length() - B.length() + 1; i++) {
            if (strStr(A, B, i)) {
                return i;
            }
        }
        return -1;
    }

    private boolean strStr(final String A, final String B, int startInd) {
        int bInd = 0;
        while (bInd < B.length()) {
            if (startInd >= A.length() || A.charAt(startInd++) != B.charAt(bInd++)) {
                return false;
            }
        }
        return true;
    }
}
