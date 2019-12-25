package CodingInterviews.P5;

import CodingInterviews.utils.BitWiseUtils;

/**
 * Created by max on 12/25/2016.
 */
public class q5_1 {
    public static int insertion(int N, int M, int i, int j) {
        int clearFirstJBitsMask = (~0) << (j + 1);
        int leaveFirstJBitsMask = ~clearFirstJBitsMask;
        int MWithTrailingIZeroes = M << i;
        return N | (leaveFirstJBitsMask & MWithTrailingIZeroes);
    }

    public static void main(String[] st) {
        int N = BitWiseUtils.binToInt("10000000000");
        String tst = BitWiseUtils.intToBin(N);
        int M = BitWiseUtils.binToInt("10011");
        tst = BitWiseUtils.intToBin(M);
        String ans = BitWiseUtils.intToBin(insertion(N, M, 2, 6));
    }
}
