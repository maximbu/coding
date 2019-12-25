package CodingInterviews.P5;


import CodingInterviews.utils.BitWiseUtils;

/**
 * Created by max on 12/26/2016.
 */
public class q5_7 {
    public static int pairSwap(int n) {
        return (((n & 0xaaaaaaaa) >>> 1) | ((n & 0x55555555) << 1));
    }


    public static void main(String[] st) {
        int n = BitWiseUtils.binToInt("10110");
        System.out.println("n:" + n + " bitwise:" + BitWiseUtils.intToBin(n));
        int flipped = pairSwap(n);
        System.out.println("flipped:" + flipped + " bitwise:" + BitWiseUtils.intToBin(flipped));
    }
}
