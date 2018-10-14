package interviewbit.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Find the largest continuous sequence in a array which sums to zero.
 *
 * Example:
 *
 *
 * Input:  {1 ,2 ,-2 ,4 ,-4}
 * Output: {2 ,-2 ,4 ,-4}
 *
 *  NOTE : If there are multiple correct answers, return the sequence which occurs first in the array
 */
public class LargestContinuousSequenceZeroSum {
    public ArrayList<Integer> lszero(ArrayList<Integer> A) {
        HashMap<Long, Integer> map = new HashMap<>();
        long sum = 0;
        int from = 1;
        int longest = -1;
        map.put(0l, -1);
        for (int i = 0; i < A.size(); i++) {
            sum += A.get(i);
            if (map.containsKey(sum)) {
                int len = i - map.get(sum) - 1;
                if (len > longest) {
                    longest = len;
                    from = map.get(sum) + 1;
                }
            } else {
                map.put(sum, i);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = from; i <= from + longest; i++) {
            ans.add(A.get(i));
        }
        return ans;
    }


    public ArrayList<Integer> lszero2(ArrayList<Integer> A) {
        int longest = 0;
        int from = 0;
        boolean hasZero = false;

        for (int i = 0; i < A.size(); i++) {
            long sum = A.get(i);
            if(sum == 0) {
                hasZero = true;
            }
            for (int j = i + 1; j < A.size(); j++) {
                sum += A.get(j);
                if (sum == 0 && longest < j - i) {
                    longest = j - i;
                    from = i;
                }
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        if (longest > 0) {
            for (int i = from; i <= from + longest; i++) {
                ans.add(A.get(i));
            }
        }else if (hasZero) {
            ans.add(0);
        }
        return ans;
    }

    public static void main(String[] st){
        LargestContinuousSequenceZeroSum q = new LargestContinuousSequenceZeroSum();
        System.out.println(q.lszero(new ArrayList<>(Arrays.asList(1, 2, -3, 3))));
        System.out.println(q.lszero(new ArrayList<>(Arrays.asList(0, -10, 20, 3, 23, 10, -20, 2, 19, -29, 0))));
        System.out.println(q.lszero(new ArrayList<>(Arrays.asList( -25, -6, 22, -28, 21, 8, -17, -9, -11, -4, -25, 0, 13, -10, -15, 15, 26, 27, 24, 0, 2))));
        System.out.println(q.lszero(new ArrayList<>(Arrays.asList(1, 2, -2, 4, -4))));
    }
}
