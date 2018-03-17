package P5;

import utils.BitWiseUtils;

/**
 * Created by max on 12/26/2016.
 */
public class q5_4 {
    public static int nextNumber(int n) {
        if (n == 0) return 0;
        int c = n;
        int trailingZeros = 0;
        while (c != 0 && (c & 1) == 0) {
            trailingZeros++;
            c = c >> 1;
        }
        int onesToAdd = 0;
        while ((c & 1) == 1) {
            onesToAdd++;
            c = c >> 1;
        }

        int positionToFlip = trailingZeros + onesToAdd;
        n = n | (1 << positionToFlip);
        n = n & (~0) << positionToFlip;
        n = n | (1 << (onesToAdd - 1)) - 1;
        return n;
    }

    public static int prevNumber(int n){
       return ~nextNumber(~n);
    }

    public static void main(String[] st) {
        int n = 13948;
        System.out.println("n:" + n + " bitwise:" + BitWiseUtils.intToBin(n));
        int next = nextNumber(n);
        System.out.println("next:" + next + " bitwise:" + BitWiseUtils.intToBin(next));
        int prev = prevNumber(n);
        System.out.println("prev:" + prev + " bitwise:" + BitWiseUtils.intToBin(prev));

        n = BitWiseUtils.binToInt("10011110000011");
        System.out.println("n:" + n + " bitwise:" + BitWiseUtils.intToBin(n));
        next = nextNumber(n);
        System.out.println("next:" + next + " bitwise:" + BitWiseUtils.intToBin(next));
        prev = prevNumber(n);
        System.out.println("prev:" + prev + " bitwise:" + BitWiseUtils.intToBin(prev));
    }
}
