package interviewbit.twoPointers;

import java.util.ArrayList;

/**
 * Remove Duplicates from Sorted Array
 *
 * Given a sorted array, remove the duplicates in place such that each element can appear atmost twice and return the new length.
 *
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 *
 * Note that even though we want you to return the new length, make sure to change the original array as well in place
 *
 * For example,
 * Given input array A = [1,1,1,2],
 *
 * Your function should return length = 3, and A is now [1,1,2].
 */
public class RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(ArrayList<Integer> a) {
        int newLen = 0;
        int prev = Integer.MAX_VALUE;
        boolean firstOcc = true;
        for (int x : a) {
            if (x != prev || firstOcc) {
                a.set(newLen++, x);
                firstOcc = (x != prev);
            }
            prev = x;
        }
        return newLen;
    }
}
