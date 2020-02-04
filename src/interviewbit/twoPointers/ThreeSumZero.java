package interviewbit.twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.IntStream;

/**
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 *
 * Note:
 *
 *  Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
 * The solution set must not contain duplicate triplets. For example, given array S = {-1 0 1 2 -1 -4}, A solution set is:
 * (-1, 0, 1)
 * (-1, -1, 2)
 */
public class ThreeSumZero {
    public ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> A) {
        A.sort(Integer::compareTo);
        HashSet<Integer> neg = new HashSet<>();
        HashSet<Integer> pos = new HashSet<>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int posInd=0;
        int zeroes = 0;
        for(int x:A){
            if(x<0){
                neg.add(x);
                posInd++;
            }
            else{
                if(x == 0){
                    zeroes++;
                }
                pos.add(x);
            }
        }

        findTrippets(A, 0,posInd, pos, ans);
        findTrippets(A, posInd,A.size(), neg, ans);

        if(zeroes >= 3){
            ans.add(new ArrayList<>(Arrays.asList(0,0,0)));
        }

        return ans;
    }

    private void findTrippets(ArrayList<Integer> A, int from ,int to, HashSet<Integer> pos, ArrayList<ArrayList<Integer>> ans) {
        for(int i=from;i<to;i++){
            for(int j=i+1;j<to;j++){
                int sum = A.get(i)+A.get(j);
                if(pos.contains(-1*sum)){
                    ArrayList<Integer> tmp = new ArrayList<>(Arrays.asList(A.get(i),A.get(j),-1*sum));
                    tmp.sort(Integer::compareTo);
                    if(!containsSolution(ans,tmp)){
                        ans.add(tmp);
                    }
                }
            }
        }
    }

    private boolean containsSolution(ArrayList<ArrayList<Integer>> solutions, ArrayList<Integer> newSolution) {
        for (ArrayList<Integer> sol:solutions) {
            boolean contains = IntStream.range(0, sol.size()).allMatch(i -> sol.get(i).equals(newSolution.get(i)));
            if(contains) return true;
        }
        return false;
    }
}
