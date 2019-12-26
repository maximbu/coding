package interviewbit.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 *
 * Each number in C may only be used once in the combination.
 *
 *  Note:
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 * The solution set must not contain duplicate combinations.
 * Example :
 *
 * Given candidate set 10,1,2,7,6,1,5 and target 8,
 *
 * A solution set is:
 *
 * [1, 7]
 * [1, 2, 5]
 * [2, 6]
 * [1, 1, 6]
 *  Warning : DO NOT USE LIBRARY FUNCTION FOR GENERATING COMBINATIONS.
 * Example : itertools.combinations in python.
 * If you do, we will disqualify your submission retroactively and give you penalty points.
 */
public class CombinationSumII {

    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        A.sort(Integer::compareTo);
        combinationSum(A, 0, B, new LinkedList<>(), ans);
        return ans;
    }

    private void combinationSum(ArrayList<Integer> A, int from, int B, LinkedList<Integer> curr, ArrayList<ArrayList<Integer>> ans) {
        if (B < 0)
            return;
        if (B == 0) {
            ArrayList<Integer> tmp = new ArrayList<>(curr);
            tmp.sort(Integer::compareTo);
            ans.add(tmp);
            return;
        }
        for (int i = from; i < A.size(); i++) {
            int cnt = 1;
            while (i + 1 < A.size() && A.get(i).equals(A.get(i + 1))) {
                cnt++;
                i++;
            }
            for (int k = 1; k <= cnt; k++) {
                for (int j = 0; j < k; j++) {
                    curr.addLast(A.get(i));
                }
                combinationSum(A, i + 1, B - k * A.get(i), curr, ans);
                for (int j = 0; j < k; j++) {
                    curr.removeLast();
                }
            }
        }
    }

    public static void main(String[] st) {
        CombinationSumII q = new CombinationSumII();
        ArrayList<ArrayList<Integer>> ans = q.combinationSum(new ArrayList<>(Arrays.asList(10, 1, 2, 7, 6, 1, 5)), 8);
        System.out.println(ans);
    }
}
