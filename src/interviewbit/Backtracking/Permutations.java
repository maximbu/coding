package interviewbit.Backtracking;

import java.util.ArrayList;

/**
 * Given a collection of numbers, return all possible permutations.
 *
 * Example:
 *
 * [1,2,3] will have the following permutations:
 *
 * [1,2,3]
 * [1,3,2]
 * [2,1,3]
 * [2,3,1]
 * [3,1,2]
 * [3,2,1]
 *  NOTE
 * No two entries in the permutation sequence should be the same.
 * For the purpose of this problem, assume that all the numbers in the collection are unique.
 *  Warning : DO NOT USE LIBRARY FUNCTION FOR GENERATING PERMUTATIONS.
 * Example : next_permutations in C++ / itertools.permutations in python.
 * If you do, we will disqualify your submission retroactively and give you penalty points.
 */
public class Permutations {
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        return permute(A,0);
    }

    private ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A,int ind) {
        if(ind == A.size()){
            ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
            ans.add(new ArrayList<>());
            return ans;
        }
        int val = A.get(ind);
        ArrayList<ArrayList<Integer>> withoutVal = permute(A,ind+1);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for(ArrayList<Integer> arr : withoutVal){
            for(int i=0;i<=arr.size();i++){
                ArrayList<Integer> withVal = new ArrayList<>(arr);
                withVal.add(i,val);
                ans.add(withVal);
            }
        }
        return ans;
    }
}
