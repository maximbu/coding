package interviewbit.arrays;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by max on 7/13/2017.
 * You are given an array (zero indexed) of N non-negative integers, A0, A1 ,…, AN-1.
 * Find the minimum sub array Al, Al+1 ,…, Ar so if we sort(in ascending order) that sub array, then the whole array should get sorted.
 * If A is already sorted, output -1.
 */
public class MaximumUnsortedSubarray {
    public static void main(String[] st) {
        MaximumUnsortedSubarray q = new MaximumUnsortedSubarray();

        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(3);
        A.add(2);
        A.add(4);
        A.add(5);

        System.out.println(q.subUnsort(A));

        A = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(3);
        A.add(4);
        A.add(5);

        System.out.println(q.subUnsort(A));
    }

    public ArrayList<Integer> subUnsort(ArrayList<Integer> A) {
        ArrayList<Integer> ans = new ArrayList<>();
        ArrayList<Integer> B = new ArrayList<>(A);
        Collections.sort(B);
        int start = -1;
        int end = -1;
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i).compareTo(B.get(i)) != 0) {
                start = i;
                break;
            }
        }
        ans.add(start);
        if (start == -1) {
            return ans;
        }
        for (int i = A.size() - 1; i >= 0; i--) {
            if (A.get(i).compareTo(B.get(i)) != 0) {
                end = i;
                break;
            }
        }
        ans.add(end);
        return ans;
    }
}
