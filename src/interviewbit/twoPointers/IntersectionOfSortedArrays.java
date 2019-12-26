package interviewbit.twoPointers;

import java.util.ArrayList;
import java.util.List;

/**
 * Find the intersection of two sorted arrays.
 * OR in other words,
 * Given 2 sorted arrays, find all the elements which occur in both the arrays.
 *
 * Example :
 *
 * Input :
 *     A : [1 2 3 3 4 5 6]
 *     B : [3 3 5]
 *
 * Output : [3 3 5]
 *
 * Input :
 *     A : [1 2 3 3 4 5 6]
 *     B : [3 5]
 *
 * Output : [3 5]
 */

public class IntersectionOfSortedArrays {
    public ArrayList<Integer> intersect(final List<Integer> A, final List<Integer> B) {
        ArrayList<Integer> ans = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < A.size() && j < B.size()) {
            if (A.get(i) < B.get(j)) {
                i++;
            } else if (A.get(i) > B.get(j)) {
                j++;
            } else if (A.get(i).equals(B.get(j))) {
                ans.add(A.get(i));
                i++;
                j++;
            }
        }
        return ans;
    }

    public static void main(String[] st) {
        IntersectionOfSortedArrays q = new IntersectionOfSortedArrays();
        var a = new ArrayList<Integer>();
        a.add(1000);
        var b = new ArrayList<Integer>();
        b.add(1000);
        System.out.println(q.intersect(a, b));
    }
}
