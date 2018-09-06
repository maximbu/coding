package interviewbit.Backtracking;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Given a collection of integers that might contain duplicates, S, return all possible subsets.
 *
 *  Note:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * The subsets must be sorted lexicographically.
 */

public class SubsetsII {

    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> A) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int x:A){
            map.put(x,map.getOrDefault(x,0)+1);
        }
        ArrayList<Integer> sorted= new ArrayList<>(map.keySet());
        sorted.sort(Comparator.reverseOrder());
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> curr = new ArrayList<>();
        subsetsWithDup(sorted,0,map,ans,curr);
        ans.sort(SubsetsII::compareLists);
        return ans;
    }

    private static int compareLists(ArrayList<Integer> o1, ArrayList<Integer> o2) {
        for (int i = 0; i < Math.min(o1.size(), o2.size()); i++) {
            int cmp = o1.get(i).compareTo(o2.get(i));
            if (cmp != 0) {
                return cmp;
            }
        }
        return Integer.compare(o1.size(), o2.size());
    }

    private void subsetsWithDup(ArrayList<Integer> A , int ind ,
            Map<Integer,Integer> map , ArrayList<ArrayList<Integer>> ans , ArrayList<Integer> curr) {
        if (ind == A.size()) {
            ArrayList<Integer> sorted = new ArrayList<>(curr);
            sorted.sort(Integer::compareTo);
            ans.add(sorted);
            return;
        }
        int currX = A.get(ind);
        for (int k = 0; k <= map.get(currX); k++) {
            ArrayList<Integer> tmp = new ArrayList<>(curr);
            subsetsWithDup(A, ind + 1, map, ans, addCurrXToCurr(curr, currX, k));
            curr = tmp;
        }
    }

    private ArrayList<Integer> addCurrXToCurr(ArrayList<Integer> l , int x , int times){
        for(int i=0;i<times;i++){
            l.add(x);
        }
        return l;
    }

    public static void main(String[] st) {
        SubsetsII q = new SubsetsII();

        ArrayList<Integer> A = new ArrayList<>();
        A.add(4);
        A.add(5);
        System.out.println(q.subsetsWithDup(A));
    }
}
