package interviewbit.Backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 2 3 ... n.
 *
 * Make sure the combinations are sorted.
 *
 * To elaborate,
 *
 * Within every entry, elements should be sorted. [1, 4] is a valid entry while [4, 1] is not.
 * Entries should be sorted within themselves.
 * Example :
 * If n = 4 and k = 2, a solution is:
 *
 * [
 *   [1,2],
 *   [1,3],
 *   [1,4],
 *   [2,3],
 *   [2,4],
 *   [3,4],
 * ]
 *  Warning : DO NOT USE LIBRARY FUNCTION FOR GENERATING COMBINATIONS.
 * Example : itertools.combinations in python.
 * If you do, we will disqualify your submission retroactively and give you penalty points.
 */
public class Combinations {

    public ArrayList<ArrayList<Integer>> combineRec(int A, int B) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if (B == 0) {
            ArrayList<Integer> empty = new ArrayList<>();
            ans.add(empty);
            return ans;
        }
        ArrayList<ArrayList<Integer>> combinePrev = combine(A, B - 1);

        for (ArrayList<Integer> prev : combinePrev) {
            for (int i = 1; i <= A; i++) {
                int l = Collections.binarySearch(prev, i);
                if (l < 0) {
                    ArrayList<Integer> tmp = new ArrayList<>(prev);
                    tmp.add(-1 * (l + 1), i);
                    ans.add(tmp);
                }
            }
        }
        return ans;
    }

    public ArrayList<ArrayList<Integer>> combine(int A, int B) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        combine(A, B, 1, new LinkedList<>(), result);

        return result;
    }

    private void combine(int A, int B, int start, LinkedList<Integer> curr,
                         ArrayList<ArrayList<Integer>> ans) {
        if (curr.size() == B) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for (int i = start; i <= A; i++) {
            curr.addLast(i);
            combine(A, B, i + 1, curr, ans);
            curr.removeLast();
        }
    }


    public static void main(String[] st) {
        Combinations q = new Combinations();
        ArrayList<ArrayList<Integer>> ans = q.combine(9, 8);
        System.out.println(ans);
    }
}
