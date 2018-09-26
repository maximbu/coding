package interviewbit.bitManipulation;

/**
 * Divide two integers without using multiplication, division and mod operator.
 *
 * Return the floor of the result of the division.
 *
 * Example:
 *
 * 5 / 2 = 2
 * Also, consider if there can be overflow cases. For overflow case, return INT_MAX.
 */
public class DivideIntegers {
    public int divide(int A, int B) {
        int a = (A == Integer.MIN_VALUE) ? Integer.MAX_VALUE : Math.abs(A);
        int b = Math.abs(B);
        int ans = 0;
        while (b <= a) {
            ans++;
            a -= b;
        }
        if ((A > 0 && B < 0) || (A < 0 && B > 0)) {
            ans = (A == Integer.MIN_VALUE) ? A : -ans;
        }
        return ans;
    }

    public static void main(String[] st){
        DivideIntegers q = new DivideIntegers();

        System.out.println(q.divide(-2147483648,-10000000));
        System.out.println(q.divide(-1239030549,-11630));
    }
}
