package interviewbit.strings;

/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
 *
 * If the last word does not exist, return 0.
 *
 * Note: A word is defined as a character sequence consists of non-space characters only.
 *
 * Example:
 *
 * Given s = "Hello World",
 *
 * return 5 as length("World") = 5.
 *
 * Please make sure you try to solve this problem without using library functions. Make sure you only traverse the string once.
 */
public class LengthOfLastWord {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int lengthOfLastWord(final String A) {
        int len =0;
        int start = A.length()-1;
        while (start >= 0 && A.charAt(start)==' '){
            start--;
        }
        while (start>=0) {
            if(A.charAt(start)==' ') return len;
            len++;
            start--;
        }
        return len;
    }

    public static void main(String[] st) {
        LengthOfLastWord q = new LengthOfLastWord();
        System.out.println(q.lengthOfLastWord("Hello World"));
        System.out.println(q.lengthOfLastWord("d"));
        System.out.println(q.lengthOfLastWord("Hello World   "));
    }
}
