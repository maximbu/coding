package interviewbit.twoPointers;

import java.util.ArrayList;

/**
 Given an array with n objects colored red, white or blue,
 sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

 Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

 Note: Using library sort function is not allowed.

 Example :

 Input : [0 1 2 0 1 2]
 Modify array so that it becomes : [0 0 1 1 2 2]
 **/

public class SortByColor {

    public void sortColors(ArrayList<Integer> a) {
        int[] cnt = new int[3];
        for (int x : a) {
            cnt[x]++;
        }
        a.clear();
        for (int i = 0; i < 3; i++) {
            while (cnt[i] > 0) {
                a.add(i);
                cnt[i]--;
            }
        }
    }
}
