package interviewbit.binarySearch;


/**
Implement int sqrt(int x).

Compute and return the square root of x.

If x is not a perfect square, return floor(sqrt(x))

DO NOT USE SQRT FUNCTION FROM STANDARD LIBRARY
 **/
public class SquareRootofInteger {

  public static void main(String[] st) {
    SquareRootofInteger q = new SquareRootofInteger();


    System.out.println(q.sqrt(11));

    System.out.println("0->" + q.sqrt(0));
    System.out.println("1->" + q.sqrt(1));
    System.out.println("1->" + q.sqrt(2));
    System.out.println("1->" + q.sqrt(3));
    System.out.println("2->" + q.sqrt(4));
    System.out.println("2->" + q.sqrt(5));
    System.out.println("2->" + q.sqrt(6));
    System.out.println("2->" + q.sqrt(7));
    System.out.println("2->" + q.sqrt(8));
    System.out.println("3->" + q.sqrt(9));

    System.out.println(q.sqrt(930675566));

  }

  public int sqrt(int a) {
    if (a < 2) return a;
    int left = 1;
    int right = a / 2;
    int mid = 0;
    while (right > left) {
      mid = left + (right - left) / 2;
      long mult = (long) mid * mid;
      long nextMult = (long) (mid + 1) * (mid + 1);
      if (mult == a || (mult < a && nextMult > a)) {
        return mid;
      }
      if (nextMult > a) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return Math.max(right, 1);
  }
}
