package interviewbit.binarySearch;

import java.util.List;

/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., 0 1 2 4 5 6 7  might become 4 5 6 7 0 1 2 ).
 *
 * You are given a target value to search. If found in the array, return its index, otherwise return -1.
 *
 * You may assume no duplicate exists in the array.
 *
 * Input : [4 5 6 7 0 1 2] and target = 4
 * Output : 0
 */
public class RotatedSortedArraySearch {
    // DO NOT MODIFY THE LIST
    public int search(final List<Integer> a, int b) {
        int rotInd = findRotationInd(a, 0, a.size() - 1);
        if (b == a.get(0)) return 0;
        int left = binSearch(a, 0, rotInd, b);
        if (left != -1)
            return left;
        return binSearch(a, rotInd + 1, a.size() - 1, b);
    }

    private int findRotationInd(final List<Integer> a, int from, int to) {
        if (from > to)
            return 0;
        int mid = (from + to) / 2;
        if (mid == a.size() - 1 || a.get(mid) > a.get(mid + 1))
            return mid;
        return a.get(mid) > a.get(0) ? findRotationInd(a, mid + 1, to) : findRotationInd(a, from, mid - 1);
    }

    private static int binSearch(final List<Integer> a, int from, int to, int x) {
        if (from > to)
            return -1;
        int mid = (from + to) / 2;
        if (a.get(mid) == x)
            return mid;
        return a.get(mid) < x ? binSearch(a, mid + 1, to, x) : binSearch(a, from, mid - 1, x);
    }
}
