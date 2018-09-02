package CodingInterviews2018.P5;

import CodingInterviews.utils.BitWiseUtils;

public class q5_1 {

    private static int insertion(int M, int N, int i, int j) {
        int bits = (~0) << (j + 1) | ((1 << i) - 1);
        int clearedBits = M & bits;
        int ans = clearedBits | (N) << i;
        return ans;
    }

    public static void main(String[] st) {
        int N = BitWiseUtils.binToInt("10000000000");
        String Nbits = BitWiseUtils.intToBin(N);
        int M = BitWiseUtils.binToInt("10011");
        String Mbits = BitWiseUtils.intToBin(M);
        String ans = BitWiseUtils.intToBin(insertion(N, M, 2, 6));

        N = BitWiseUtils.binToInt("11111111111");
        Nbits = BitWiseUtils.intToBin(N);
        M = BitWiseUtils.binToInt("100000");
        Mbits = BitWiseUtils.intToBin(M);
        ans = BitWiseUtils.intToBin(insertion(N, M, 2, 6));
    }
}
