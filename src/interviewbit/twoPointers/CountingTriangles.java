package interviewbit.twoPointers;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * You are given an array of N non-negative integers, A0, A1 ,…, AN-1.
 * Considering each array element Ai as the edge length of some line segment, count the number of triangles which you can form using these array values.
 *
 * Notes:
 *
 * You can use any value only once while forming each triangle. Order of choosing the edge lengths doesn’t matter. Any triangle formed should have a positive area.
 *
 * Return answer modulo 109 + 7.
 *
 * For example,
 *
 * A = [1, 1, 1, 2, 2]
 *
 * Return: 4
 */
public class CountingTriangles {
    public int nTriang(ArrayList<Integer> A) {
        int ans = 0;
        A.sort(Integer::compareTo);
        for (int i = A.size() - 1; i > 1; i--) {
            for (int from = i - 1; from > 0 && (long) A.get(from) + A.get(from - 1) > A.get(i); from--) {
                for (int to = 0; to < from; to++) {
                    if ((long) A.get(from) + A.get(to) > A.get(i)) {
                        ans = (ans + from - to) % 1000000007;
                        break;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] st){
        CountingTriangles q = new CountingTriangles();
        System.out.println(q.nTriang(new ArrayList<>(Arrays.asList( 1, 1, 1, 2, 2))));

    }
}
