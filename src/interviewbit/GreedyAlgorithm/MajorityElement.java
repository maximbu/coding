package interviewbit.GreedyAlgorithm;

import java.util.HashMap;
import java.util.List;

public class MajorityElement {

    /**
     * Given an array of size n, find the majority element. The majority element is the element that appears more than floor(n/2) times.
     *
     * You may assume that the array is non-empty and the majority element always exist in the array.
     *
     * Example :
     *
     * Input : [2, 1, 2]
     * Return  : 2 which occurs 2 times which is greater than 3/2.
     *
     */
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int majorityElement(final List<Integer> A) {
        HashMap<Integer, Integer> m = new HashMap<>();
        for (int x : A) {
            int v = m.getOrDefault(x, 0) + 1;
            if (v > A.size() / 2) {
                return x;
            }
            m.put(x, v);
        }
        return -1;
    }
}
