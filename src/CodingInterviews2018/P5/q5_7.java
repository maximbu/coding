package CodingInterviews2018.P5;

import CodingInterviews.utils.BitWiseUtils;

public class q5_7 {
    private static int swapOddEvenBits(int x) {
        return (((x & 0xaaaaaaaa) >>> 1) | (x & 0x55555555) << 1);
    }

    public static void main(String[] st) {
        int n = BitWiseUtils.binToInt("10110");
        System.out.println("n:" + n + " bitwise:" + BitWiseUtils.intToBin(n));
        int flipped = swapOddEvenBits(n);
        System.out.println("flipped:" + flipped + " bitwise:" + BitWiseUtils.intToBin(flipped));
    }
}
