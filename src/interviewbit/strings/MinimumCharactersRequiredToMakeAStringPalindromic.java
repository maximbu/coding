package interviewbit.strings;

/**
 * You are given a string. The only operation allowed is to insert characters in the beginning of the string. How many minimum characters are needed to be inserted to make the string a palindrome string
 *
 * Example:
 * Input: ABC
 * Output: 2
 * Input: AACECAAAA
 * Output: 2
 */
public class MinimumCharactersRequiredToMakeAStringPalindromic {
    public int solve(String A) {
        if(A == null) return 0;
        char[] ch = A.toCharArray();
        for(int i=0;i<ch.length;i++){
            if(isPolindrom(ch,ch.length-i-1))
                return i;
        }
        return 0;
    }

    private boolean isPolindrom(char[] ch , int to) {
        for (int i = 0; i < to; i++) {
            if (ch[i] != ch[to--])
                return false;
        }
        return true;
    }

    public static void main(String[] st) {
        var q = new MinimumCharactersRequiredToMakeAStringPalindromic();
        System.out.println(q.solve("aaaaa"));
    }
}
