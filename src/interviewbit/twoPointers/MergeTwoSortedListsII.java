package interviewbit.twoPointers;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 *
 *  Note: You have to modify the array A to contain the merge of A and B. Do not output anything in your code.
 * TIP: C users, please malloc the result into a new array and return the result.
 * If the number of elements initialized in A and B are m and n respectively, the resulting size of array A after your code is executed should be m + n
 *
 * Example :
 *
 * Input :
 *          A : [1 5 8]
 *          B : [6 9]
 *
 * Modified A : [1 5 6 8 9]
 */
public class MergeTwoSortedListsII {
    public void merge(ArrayList<Integer> a, ArrayList<Integer> b) {
        int ai = 0;
        int bi = 0;
        for (int i = 0; i < a.size() + b.size(); i++) {
            if (bi >= b.size())
                return;
            if (ai + bi >= a.size()) {
                a.add(b.get(bi++));
                continue;
            }
            if (a.get(ai + bi) >= b.get(bi)) {
                a.add(ai + bi, b.get(bi));
                bi++;
            } else {
                ai++;
            }
        }
    }

    public static void main(String[] st) {
        MergeTwoSortedListsII q = new MergeTwoSortedListsII();

        ArrayList<Integer> a =new ArrayList<>(Arrays.asList(1,2));
        ArrayList<Integer> b =new ArrayList<>(Arrays.asList(-1,2));
        q.merge(a,b);
        System.out.println(a);

        a =new ArrayList<>(Arrays.asList(-4,3));
        b =new ArrayList<>(Arrays.asList(-2,2));
        q.merge(a,b);
        System.out.println(a);

        a =new ArrayList<>(Arrays.asList(-4,-3,0));
        b =new ArrayList<>(Arrays.asList(2));
        q.merge(a,b);
        System.out.println(a);
    }
}
