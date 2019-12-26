package interviewbit.strings;

/**
 * Given an input string, reverse the string word by word.
 *
 * Example:
 *
 * Given s = "the sky is blue",
 *
 * return "blue is sky the".
 *
 * A sequence of non-space characters constitutes a word.
 * Your reversed string should not contain leading or trailing spaces, even if it is present in the input string.
 * If there are multiple spaces between words, reduce them to a single space in the reversed string.
 */
public class ReverseTheString {
    public String reverseWords(String a) {
        StringBuilder sb = new StringBuilder();
        String[] words = a.trim().split(" ");
        for (int i = words.length - 1; i >= 0; i--) {
            String w = words[i];
            if (w.length() > 0) {
                if (i != words.length - 1) {
                    sb.append(" ");
                }
                sb.append(w);
            }
        }
        return sb.toString();
    }

    public static void main(String[] st) {
        ReverseTheString q = new ReverseTheString();
        System.out.println(q.reverseWords("the sky is blue"));
        System.out.println(q.reverseWords("j"));
    }
}
