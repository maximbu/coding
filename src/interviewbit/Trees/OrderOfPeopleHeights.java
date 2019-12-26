package interviewbit.Trees;

import java.util.ArrayList;
import java.util.TreeMap;

public class OrderOfPeopleHeights {

    /**
     * You are given the following :
     * <p>
     * A positive number N
     * Heights : A list of heights of N persons standing in a queue
     * Infronts : A list of numbers corresponding to each person (P) that gives the number of persons who are taller than P and standing in front of P
     * You need to return list of actual order of persons’s height
     * <p>
     * Consider that heights will be unique
     * <p>
     * Example
     * <p>
     * Input :
     * Heights: 5 3 2 6 1 4
     * InFronts: 0 1 2 0 3 2
     * Output :
     * actual order is: 5 3 2 1 6 4
     * So, you can see that for the person with height 5, there is no one taller than him who is in front of him, and hence Infronts has 0 for him.
     * <p>
     * For person with height 3, there is 1 person ( Height : 5 ) in front of him who is taller than him.
     * <p>
     * You can do similar inference for other people in the list.
     */
    public ArrayList<Integer> order(ArrayList<Integer> A, ArrayList<Integer> B) {
        ArrayList<Integer> ans = new ArrayList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < A.size(); i++) {
            map.put(A.get(i), B.get(i));
        }

        while (!map.isEmpty()) {
            int height = map.lastKey();
            map.remove(height);
            ans.add(map.get(height), height);
        }
        return ans;
    }


    public ArrayList<Integer> orderNaive(ArrayList<Integer> A, ArrayList<Integer> B) {
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < A.size(); i++) {
            ans.add(next(A, B));
        }
        return ans;
    }

    private int next(ArrayList<Integer> A, ArrayList<Integer> B) {
        int elem = Integer.MAX_VALUE;
        for (int i = 0; i < A.size(); i++) {
            if (B.get(i) == 0) {
                elem = Math.min(elem, A.get(i));
            }
        }
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) <= elem) {
                B.set(i, B.get(i) - 1);
            }
        }

        return elem;
    }
}
