package interviewbit.DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Given an array of integers, find the length of longest subsequence which is first increasing then decreasing.
 *
 * **Example: **
 *
 * For the given array [1 11 2 10 4 5 2 1]
 *
 * Longest subsequence is [1 2 10 4 2 1]
 *
 * Return value 6
 */
public class LengthOfLongestSubsequence {
    public int longestSubsequenceLength(final List<Integer> A) {
        if (A.size() == 0)
            return 0;
        int inc[] = new int[A.size()];
        inc[0] = 1;
        for (int i = 1; i < A.size(); i++) {
            inc[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (A.get(i) > A.get(j)) {
                    inc[i] = Math.max(inc[i], inc[j] + 1);
                }
            }
        }

        int dec[] = new int[A.size()];
        dec[A.size() - 1] = 1;
        for (int i = A.size() - 1; i >= 0; i--) {
            dec[i] = 1;
            for (int j = i + 1; j < A.size(); j++) {
                if (A.get(i) > A.get(j)) {
                    dec[i] = Math.max(dec[i], dec[j] + 1);
                }
            }
        }

        int max = 0;
        for (int i = 0; i < A.size(); i++) {
            max = Math.max(max, inc[i] + dec[i] - 1);
        }
        return max;
    }

    public static void main(String[] st) {
        LengthOfLongestSubsequence q = new LengthOfLongestSubsequence();

        var arr2 = new ArrayList<>(Arrays.asList(1 , 3 , 5 , 6 , 4 , 8 , 4 , 3 , 2 , 1 , 6));
        System.out.println(q.longestSubsequenceLength(arr2));

        var arr = new ArrayList<>(Arrays.asList(1 ,11 ,2 ,10 ,4 ,5 ,2 ,1));
        System.out.println(q.longestSubsequenceLength(arr));
        System.out.println(q.longestSubsequenceLength(new ArrayList<>()));

    }
}
