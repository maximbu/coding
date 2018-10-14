package interviewbit.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;

/**
 * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 *
 * The same repeated number may be chosen from C unlimited number of times.
 *
 *  Note:
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 * The combinations themselves must be sorted in ascending order.
 * CombinationA > CombinationB iff (a1 > b1) OR (a1 = b1 AND a2 > b2) OR … (a1 = b1 AND a2 = b2 AND … ai = bi AND ai+1 > bi+1)
 * The solution set must not contain duplicate combinations.
 * Example,
 * Given candidate set 2,3,6,7 and target 7,
 * A solution set is:
 *
 * [2, 2, 3]
 * [7]
 *  Warning : DO NOT USE LIBRARY FUNCTION FOR GENERATING COMBINATIONS.
 * Example : itertools.combinations in python.
 * If you do, we will disqualify your submission retroactively and give you penalty points.
 */
public class CombinationSum {

    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        combinationSum(new ArrayList<>(A.stream().distinct().sorted().collect(Collectors.toList())), 0, B, new LinkedList<>(), ans);
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
            curr.addLast(A.get(i));
            combinationSum(A, i, B - A.get(i), curr, ans);
            curr.removeLast();
        }
    }

    public static void main(String[] st) {
        CombinationSum q = new CombinationSum();
        ArrayList<ArrayList<Integer>> ans = q.combinationSum(new ArrayList<>(Arrays.asList(8, 10, 6, 11, 1, 16, 8)),28);
        System.out.println(ans);
    }
}
