package interviewbit.math;

/**
 * Created by max on 7/17/2017.
 * Given a positive integer which fits in a 32 bit signed integer, find if it can be expressed as A^P where P > 1 and A > 0. A and P both should be integers.
 */
public class PowerOfTwoIntegers {

  public static void main(String[] st) {
    PowerOfTwoIntegers q = new PowerOfTwoIntegers();

    int N = 33;
    System.out.println(q.isPower(N));
  }

  public boolean isPower(int a) {
    if (a == 1)
      return true;
    for (int i = 2; i * i <= a; i++) {
      int p = a;
      while (p % i == 0) {
        p /= i;
      }
      if (p == 1)
        return true;
    }
    return false;
  }
}
