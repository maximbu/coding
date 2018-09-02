package interviewbit.strings;

/**
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Example:

"A man, a plan, a canal: Panama" is a palindrome.

"race a car" is not a palindrome.

Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 **/
public class PalindromeString {
        public int isPalindrome(String A) {
            if(A == null) return 0;
            char[] ch = A.toCharArray();
            int left =0;
            int right = ch.length-1;
            while(left < right){
                while(left < right && !Character.isLetterOrDigit(ch[left])){
                    left++;
                }
                while(left < right && !Character.isLetterOrDigit(ch[right])){
                    right--;
                }
                if(left == right) return 1;
                if(Character.toLowerCase(ch[left++]) != Character.toLowerCase(ch[right--])){
                    return 0;
                }
            }
            return 1;
        }

    public static void main(String[] st) {
        PalindromeString q = new PalindromeString();

        System.out.println(q.isPalindrome("A man, a plan, a canal: Panama"));
    }
}
