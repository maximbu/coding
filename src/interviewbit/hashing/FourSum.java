package interviewbit.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
 *
 *  Note:
 * Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
 * The solution set must not contain duplicate quadruplets.
 * Example :
 * Given array S = {1 0 -1 0 -2 2}, and target = 0
 * A solution set is:
 *
 *     (-2, -1, 1, 2)
 *     (-2,  0, 0, 2)
 *     (-1,  0, 0, 1)
 * Also make sure that the solution set is lexicographically sorted.
 * Solution[i] < Solution[j] iff Solution[i][0] < Solution[j][0] OR (Solution[i][0] == Solution[j][0] AND ... Solution[i][k] < Solution[j][k])
 */
public class FourSum {
    private static class Ind {
        int i;
        int j;

        Ind(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public ArrayList<ArrayList<Integer>> fourSum(ArrayList<Integer> A, int B) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        HashMap<Integer, List<Ind>> map = new HashMap<>();
        for (int i = 0; i < A.size(); i++) {
            for (int j = i + 1; j < A.size(); j++) {
                int key = A.get(i) + A.get(j);
                if (map.containsKey(B - key)) {
                    for (Ind option : map.get(B - key)) {
                        if (i == option.i || j == option.j || i == option.j || j == option.i) {
                            continue;
                        }
                        ArrayList<Integer> newSolution = new ArrayList<>(Arrays.asList(A.get(option.i), A.get(option.j), A.get(i), A.get(j)));
                        newSolution.sort(Integer::compareTo);
                        if (!containsSolution(ans, newSolution)) {
                            ans.add(newSolution);
                        }
                    }
                }
                if (!map.containsKey(key)) {
                    map.put(key, new ArrayList<>());
                }
                map.get(key).add(new Ind(i, j));
            }
        }
        ans.sort((o1, o2) -> {
            for (int i = 0; i < o1.size(); i++) {
                int comp = Integer.compare(o1.get(i), o2.get(i));
                if (comp != 0) {
                    return comp;
                }
            }
            return 0;
        });
        return ans;
    }

    private boolean containsSolution(ArrayList<ArrayList<Integer>> solutions, ArrayList<Integer> newSolution) {
        for (ArrayList<Integer> sol : solutions) {
            boolean contains = IntStream.range(0, sol.size()).allMatch(i -> sol.get(i).equals(newSolution.get(i)));
            if (contains) return true;
        }
        return false;
    }

    public static void main(String[] st) {
        FourSum q = new FourSum();
        System.out.println(q.fourSum(new ArrayList<>(Arrays.asList(9, -8, -10, -7, 7, -8, 2, -7, 4, 7, 0, -3, -4, -5, -1, -4, 5, 8, 1, 9, -2, 5, 10, -5, -7, -1, -6, 4, 1, -5, 3, 8, -4, -10, -9, -3, 10, 0, 7, 9, -8, 10, -9, 7, 8, 0, 6, -6, -7, 6, -4, 2, 0, 10, 1, -2, 5, -2)), 0));
    }
}
