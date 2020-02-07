package CodingInterviews2018.P16;

import java.util.*;

public class q16_21 {

    private static int[] sumSwap(int[] a, int[] b) {
        int[] sortedA = a.clone();
        int[] sortedB = b.clone();
        Arrays.sort(sortedA);
        Arrays.sort(sortedB);
        int sumA = Arrays.stream(sortedA).sum();
        int sumB = Arrays.stream(sortedB).sum();
        int diff = sumA - sumB;
        int aInd = 0;
        int bInd = 0;
        while (aInd < a.length && bInd < b.length) {
            int elemDiff = sortedA[aInd] - sortedB[bInd];
            if (elemDiff == diff) {
                return new int[]{sortedA[aInd], sortedB[bInd], sumA - diff / 2};
            }
            if (elemDiff > diff) {
                bInd++;
            } else {
                aInd++;
            }
        }

        return new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};
    }


    public static void main(String[] args) {
        int[] a = {4, 1, 2, 1, 1, 2, 2, 8,-4};
        int[] b = {3, 6, 3, 3, 1};
        int[] res = sumSwap(a, b);
        if(res[0]== Integer.MAX_VALUE){
            System.out.printf("It's impossible to make arrays %s and %s equal by swapping two elements%n", Arrays.toString(a), Arrays.toString(b));
        }
        else {
            System.out.printf("To make arrays %s and %s equal we need to swap:%d with:%d and get a sum of %d%n", Arrays.toString(a), Arrays.toString(b), res[0], res[1], res[2]);
        }
    }
}
