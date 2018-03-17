package interviewbit.math;

/**
 * Created by max on 7/20/2017.
 * Given an integer n, return the number of trailing zeroes in n!.

 Note: Your solution should be in logarithmic time complexity.
 */
public class TrailingZerosInFactorial {
  public static void main(String[] st) {
    TrailingZerosInFactorial q = new TrailingZerosInFactorial();

    int N = 5;
    System.out.println(q.trailingZeroes(N));

    N = 25;
    System.out.println(q.trailingZeroes(N));
  }

  public int trailingZeroes(int a) {
    int powersOfFive = 0;
    for (int i = 5; i <= a; i *= 5) {
      powersOfFive += a / i;
    }
    return powersOfFive;
  }
}
