package interviewbit.twoPointers;

import java.util.Arrays;
import java.util.List;

/**
 * You are given 3 arrays A, B and C. All 3 of the arrays are sorted.
 *
 * Find i, j, k such that :
 * max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i])) is minimized.
 * Return the minimum max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i]))
 *
 * **abs(x) is absolute value of x and is implemented in the following manner : **
 *
 *       if (x < 0) return -x;
 *       else return x;
 * Example :
 *
 * Input :
 *         A : [1, 4, 10]
 *         B : [2, 15, 20]
 *         C : [10, 12]
 *
 * Output : 5
 *          With 10 from A, 15 from B and 10 from C.
 */
public class ArrayThreePointers {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int minimize(final List<Integer> A, final List<Integer> B, final List<Integer> C) {
        int ans = Integer.MAX_VALUE;
        int Ai =0;
        int Bi =0;
        int Ci =0;
        while(Ai < A.size() && Bi < B.size() && Ci < C.size()) {
            int a = A.get(Ai);
            int b = B.get(Bi);
            int c = C.get(Ci);
            ans = Math.min(ans, calc(a, b, c));
            if (ans == 0)
                return 0;
            int min = Math.min(a, Math.min(b, c));
            if (min == a) {
                Ai++;
            } else if (min == b) {
                Bi++;
            } else {
                Ci++;
            }
        }
        return ans;
    }
    int calc(int a,int b, int c){
        int ans = Math.abs(a-b);
        ans = Math.max(ans,Math.abs(b-c));
        ans = Math.max(ans,Math.abs(c-a));
        return ans;
    }

    public static void main(String st[]){
        ArrayThreePointers q = new ArrayThreePointers();
        System.out.println(q.minimize(Arrays.asList(1),Arrays.asList(1),Arrays.asList(1)));
        System.out.println(q.minimize(Arrays.asList(1,4,10),Arrays.asList(2,15,20),Arrays.asList(10,12)));
    }
}
