package interviewbit.math;

/**
 * Created by max on 7/19/2017.
 * Determine whether an integer is a palindrome. Do this without extra space.

 A palindrome integer is an integer x for which reverse(x) = x where reverse(x) is x with its digit reversed.
 Negative numbers are not palindromic.
 */
public class PalindromeInteger {
  public static void main(String[] st) {
    PalindromeInteger q = new PalindromeInteger();

    int N = 12121;
    System.out.println(q.isPalindrome(N));

    N = 123;
    System.out.println(q.isPalindrome(N));
  }

  public boolean isPalindrome(int a) {
    if(a<0) return false;
    int aVal = a;
    int b = 0;
    while (a >0){
      b = b*10 + a%10;
      a/=10;
    }
    return aVal==b;
  }
}
