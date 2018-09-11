package interviewbit.HeapsAndMaps;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * You are given an array of N integers, A1, A2 ,…, AN and an integer K. Return the of count of distinct numbers in all windows of size K.
 *
 * Formally, return an array of size N-K+1 where i’th element in this array contains number of distinct elements in sequence Ai, Ai+1 ,…, Ai+k-1.
 *
 * Note:
 *
 * If K > N, return empty array.
 * For example,
 *
 * A=[1, 2, 1, 3, 4, 3] and K = 3
 *
 * All windows of size K are
 *
 * [1, 2, 1]
 * [2, 1, 3]
 * [1, 3, 4]
 * [3, 4, 3]
 *
 * So, we return an array [2, 3, 3, 2].
 */
public class DistinctNumbersInWindow {
    public ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
        ArrayList<Integer> ans = new ArrayList<>();
        if(B > A.size()){
            return ans;
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0 ; i < B ; i++){
            map.put(A.get(i),map.getOrDefault(A.get(i),0)+1);
        }
        ans.add(map.keySet().size());
        for(int i=B ; i < A.size() ; i++){
            removePrev(map, A.get(i-B));
            map.put(A.get(i),map.getOrDefault(A.get(i),0)+1);
            ans.add(map.keySet().size());
        }
        return ans;
    }

    private void removePrev(HashMap<Integer, Integer> map, int val) {
        if (map.get(val) == 1) {
            map.remove(val);
        } else {
            map.put(val, map.get(val) - 1);
        }
    }

    public static void main(String[] st){
        DistinctNumbersInWindow q = new DistinctNumbersInWindow();
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(1);
        a.add(3);
        a.add(4);
        a.add(3);
        System.out.println(q.dNums(a,3));
    }
}
