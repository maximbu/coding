package interviewbit.bitManipulation;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given an array of N integers, find the pair of integers in the array which have minimum XOR value. Report the minimum XOR value.
 *
 * Examples :
 * Input
 * 0 2 5 7
 * Output
 * 2 (0 XOR 2)
 * Input
 * 0 4 7 9 
 * Output
 * 3 (4 XOR 7)
 *
 * Constraints:
 * 2 <= N <= 100 000
 * 0 <= A[i] <= 1 000 000 000
 */
public class MinXorValue {
    public int findMinXor(ArrayList<Integer> A) {
        return findMinXor(A, 30);

    }

    public int findMinXor(ArrayList<Integer> A, int msbDigit) {
        int minXor = Integer.MAX_VALUE;
        if (A.size() < 4 || msbDigit == 0) {
            for (int i = 0; i < A.size(); i++) {
                for (int j = i + 1; j < A.size(); j++) {
                    int ans = A.get(i) ^ A.get(j);
                    if (ans < minXor) {
                        minXor = ans;
                        System.out.println("Xor of " + A.get(i) + " and " + A.get(j) + " is the new min: " + ans);
                    }
                }
            }
            return minXor;
        }
        ArrayList<Integer> msb1 = new ArrayList<Integer>();
        ArrayList<Integer> msb0 = new ArrayList<Integer>();
        int d = 1 << msbDigit;
        for (Integer aA : A) {
            if ((aA & d) == 0) {
                msb0.add(aA);
            } else {
                msb1.add(aA);
            }
        }
        return Math.min(findMinXor(msb0, msbDigit - 1), findMinXor(msb1, msbDigit - 1));

    }

    public static void main(String[] st) {
        MinXorValue q = new MinXorValue();

        ArrayList<Integer> X = new ArrayList<>(Arrays.asList(14, 12, 5, 8, 11, 4));
        ArrayList<Integer> X2 = new ArrayList<>(Arrays.asList(3, 2, 13, 1, 5, 13, 0, 13, 13));
        ArrayList<Integer> X3 = new ArrayList<>(
                Arrays.asList(492416, 275153, 684032, 319360, 543232, 804480, 525824, 671825, 1036753, 940625, 909521, 405120, 1076689, 80081, 57856, 1000145, 13649, 596049, 429649, 289489, 907136, 261120, 1247313, 902609, 576465, 1133696, 1128576, 877440, 1058432, 554449, 1206225, 1007953, 1066705,
                        1237329, 491601, 300753, 789073, 1233408, 513617, 657152, 993664, 93568, 324689, 457169, 254208, 1250560, 217169, 557568, 416896, 256465, 687313, 21888, 433536, 276224, 536145, 466304, 3200, 162176, 341376, 589824, 1075840, 411345, 401873, 52561, 653649, 1077376, 1011456,
                        339281, 297472, 931200, 869969, 1131601, 326272, 94801, 1246464, 646400, 727040, 1001856, 120192, 1093585, 309632, 313169, 160977, 1102720, 1126993));

        //System.out.println(492416 ^ 491601);
        System.out.println(q.findMinXor(X));
        System.out.println(q.findMinXor(X2));
        System.out.println(q.findMinXor(X3));
    }
}
