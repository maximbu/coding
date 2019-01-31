package hackerRank.interviewPrep.Search;

import java.util.Arrays;

public class TripleSum {
    static long triplets(int[] a, int[] b, int[] c) {
        int[] sortedA = Arrays.stream(a).sorted().distinct().toArray();
        int[] sortedB = Arrays.stream(b).sorted().distinct().toArray();
        int[] sortedC = Arrays.stream(c).sorted().distinct().toArray();
        long ans = 0;
        for (int x : sortedB) {
            int biggerA = Arrays.binarySearch(sortedA, x) + 1;
            if (biggerA < 0) {
                biggerA *= -1;
            }
            int biggerC = Arrays.binarySearch(sortedC, x) + 1;
            if (biggerC < 0) {
                biggerC *= -1;
            }
            ans += (long)biggerA * biggerC;
        }
        return ans;
    }

    public static void main(String[] st){
        System.out.println(triplets(new int[]{1,3,5},new int[]{2,3},new int[]{1,2,3}));
        System.out.println(triplets(new int[]{1,4,5},new int[]{2,3,3},new int[]{1,2,3}));
    }
}
