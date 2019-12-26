package interviewbit.DynamicProgramming;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given an array with non negative numbers, divide the array into two parts such that the average of both the parts is equal.
 * Return both parts (If exist).
 * If there is no solution. return an empty list.
 *
 * Example:
 *
 *
 * Input:
 * [1 7 15 29 11 9]
 *
 * Output:
 * [9 15] [1 7 11 29]
 *
 * The average of part is (15+9)/2 = 12,
 * average of second part elements is (1 + 7 + 11 + 29) / 4 = 12
 *
 *  NOTE 1: If a solution exists, you should return a list of exactly 2 lists of integers A and B which follow the following condition :
 * numElements in A <= numElements in B
 * If numElements in A = numElements in B, then A is lexicographically smaller than B ( https://en.wikipedia.org/wiki/Lexicographical_order )
 * NOTE 2: If multiple solutions exist, return the solution where length(A) is minimum. If there is still a tie, return the one where A is lexicographically smallest. NOTE 3: Array will contain only non negative numbers.
 */
public class EqualAveragePartition {

    static class dpHelper {

        int val;
        ArrayList<Integer> items;

        public dpHelper() {
            items = new ArrayList<>();
        }

        public dpHelper(int newItem, List<Integer> l) {
            items = new ArrayList<>(l);
            items.add(newItem);
            val = items.stream().mapToInt(Integer::intValue).sum();
        }
    }

    public ArrayList<ArrayList<Integer>> avgset(ArrayList<Integer> A) {
        A.sort(Integer::compareTo);
        int sum = A.stream().mapToInt(Integer::intValue).sum();
        for (int i = 1; i <= A.size() / 2; i++) {
            ArrayList<Integer> a = subsetOfSizeWithVal(i, (sum * i) / A.size(), A);
            if (a.size() == i) {
                ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
                ans.add(a);
                ans.add(A.stream().filter(x -> !a.contains(x))
                        .collect(Collectors.toCollection(ArrayList::new)));
                return ans;
            }
        }
        return new ArrayList<>();
    }

    private ArrayList<Integer> subsetOfSizeWithVal(int size, int val, ArrayList<Integer> A) {
        throw new RuntimeException(); // TODO: continue
    }


}
