package interviewbit.math;

/**
 * Created by max on 7/19/2017.
 * Reverse digits of an integer.
 * Return 0 if the result overflows and does not fit in a 32 bit signed integer
 */
public class ReverseInteger {

  public static void main(String[] st) {
    ReverseInteger q = new ReverseInteger();

    int N = 12121;
    System.out.println(q.reverse(N));

    N = 123;
    System.out.println(q.reverse(N));
  }


  public int reverse(int a) {
    int mul = 1;
    if (a < 0) {
      mul = -1;
      a *= -1;
    }
    long b = 0;
    while (a > 0) {
      b = b * 10 + a % 10;
      a /= 10;
    }
    if (b > Integer.MAX_VALUE) {
      return 0;
    }
    return (int) b * mul;
  }
}
