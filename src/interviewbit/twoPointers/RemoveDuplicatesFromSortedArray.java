package interviewbit.twoPointers;

import java.util.ArrayList;

/**
 * Remove duplicates from Sorted Array
 * Given a sorted array, remove the duplicates in place such that each element appears only once and return the new length.
 *
 * Note that even though we want you to return the new length, make sure to change the original array as well in place
 *
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 *
 *  Example:
 * Given input array A = [1,1,2],
 * Your function should return length = 2, and A is now [1,2].
 */
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(ArrayList<Integer> a) {
        int newLen = 0;
        int prev = Integer.MAX_VALUE;
        for(int x:a){
            if(x!=prev){
                a.set(newLen++,x);
            }
            prev = x;
        }
        return newLen;
    }
}
