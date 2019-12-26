package interviewbit.bitManipulation;

/**
 * Reverse bits of an 32 bit unsigned integer
 *
 * Example 1:
 *
 * x = 0,
 *
 *           00000000000000000000000000000000
 * =>        00000000000000000000000000000000
 * return 0
 *
 * Example 2:
 *
 * x = 3,
 *
 *           00000000000000000000000000000011
 * =>        11000000000000000000000000000000
 * return 3221225472
 *
 * Since java does not have unsigned int, use long
 */
public class ReverseBits {
    public long reverse(long a) {
        long ans = 0;
        for (int i = 0; i < 32; i++) {
            ans = (ans << 1) | (a >> i & 1);
        }
        return ans;
    }

    public static void main(String[] st) {
        ReverseBits q = new ReverseBits();
        System.out.println(q.reverse(0));
        System.out.println(q.reverse(1));
        System.out.println(q.reverse(2));
        System.out.println(q.reverse(3));
    }
}
