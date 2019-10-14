package interviewbit.DynamicProgramming;

/**
 * Given a string, find if there is any sub-sequence that repeats itself.
 * A sub-sequence of a string is defined as a sequence of characters generated by deleting some characters in the string without changing the order of the remaining characters.
 *
 * Input:
 * string
 *
 * Output:
 *
 * 0/1
 * 0 -> No
 * 1 -> Yes
 * Example:
 *
 * abab ------> yes, ab is repeated. So, return 1.
 * abba ------> No, a and b follow different order. So, return 0.
 * NOTE : sub-sequence length should be greater than or equal to 2
 */
public class RepeatingSubSequence {

    public int anytwo(String A) {
        int foundInd = A.length();
        for (int i = 0; i < A.length(); i++) {
            for (int j = i + 1; j < A.length(); j++) {
                if (A.charAt(i) == A.charAt(j)) {
                    if (foundInd < j) {
                        return 1;
                    }
                    foundInd = j;
                }
            }
        }
        return 0;
    }

    public static void main(String[] st) {
        RepeatingSubSequence q = new RepeatingSubSequence();
        System.out.println(q.anytwo("aabb"));
    }
}