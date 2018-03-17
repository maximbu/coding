package interviewbit.binarySearch;

import java.util.ArrayList;

/***
 * Implement pow(x, n) % d.

 In other words, given x, n and d,

 find (xn % d)

 Note that remainders on division cannot be negative.
 In other words, make sure the answer you return is non negative.
 */
public class ImplementPowerFunction {

  public static void main(String[] st) {
    ImplementPowerFunction q = new ImplementPowerFunction();
    int x = 2;
    int n = 3;
    int d = 3;

    System.out.println(q.pow(x, n, d));

    x = 0;
    n = 0;
    d = 1;

    System.out.println(q.pow(x, n, d));

    x = -1;
    n = 1;
    d = 20;

    System.out.println(q.pow(x, n, d));

    x = 79161127;
    n = 99046373;
    d = 57263970;
    // 47168647

    System.out.println(q.pow(x, n, d));
  }

  public int pow(int x, int n, int d) {
    if(x == 0) return 0;
    if(x < 0) x =(d + x)%d;
    return (int) powRec(x,n,d);
  }

  public long powRec(long x, long n, long d) {
    if(n == 0) return 1;
    if(n == 1) return x%d;
    if (n%2 == 0){
      long y = powRec(x,n/2,d);
      return ((y%d)*(y%d))%d;
    }
    else{
      long y = powRec(x,(n-1)/2,d);
      return (((y%d)*(y%d))%d * x%d)%d;
    }
  }
}
