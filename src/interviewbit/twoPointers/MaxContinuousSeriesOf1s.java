package interviewbit.twoPointers;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * You are given with an array of 1s and 0s. And you are given with an integer M, which signifies number of flips allowed.
 * Find the position of zeros which when flipped will produce maximum continuous series of 1s.
 *
 * For this problem, return the indices of maximum continuous series of 1s in order.
 *
 * Example:
 *
 * Input :
 * Array = {1 1 0 1 1 0 0 1 1 1 }
 * M = 1
 *
 * Output :
 * [0, 1, 2, 3, 4]
 *
 * If there are multiple possible solutions, return the sequence which has the minimum start index.
 */
public class MaxContinuousSeriesOf1s {
    public ArrayList<Integer> maxone(ArrayList<Integer> A, int B) {
        int max = 0;
        int maxIndStart = 0;
        int maxIndEnd = 0;
        for (int i = 0; i < A.size(); i++) {
            int zeroes = 0;
            int sum = 0;
            for (int j = i; j < A.size(); j++) {
                int x = A.get(j);
                if (x == 0) {
                    zeroes++;
                    if (zeroes > B) {
                        break;
                    }
                }
                sum++;
                if (sum > max) {
                    max = sum;
                    maxIndStart = i;
                    maxIndEnd = j;
                }
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = maxIndStart; i <= maxIndEnd; i++) {
            ans.add(i);
        }
        return ans;
    }

    public static void main(String[] st) {
        MaxContinuousSeriesOf1s q = new MaxContinuousSeriesOf1s();
        var a = new ArrayList<>(Arrays.asList(1, 0, 1, 0, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0));
        System.out.println(q.maxone(a,4));
        a = new ArrayList<>(Arrays.asList(0, 1, 1, 1));
        System.out.println(q.maxone(a,0));
        a = new ArrayList<>(Arrays.asList(1, 1, 0));
        System.out.println(q.maxone(a,2));
    }
}
