package interviewbit.math;

import java.util.ArrayList;

/**
 * Created by max on 7/16/2017.
 * Given a number N, find all factors of N.
 * Make sure the returned array is sorted.
 */
public class AllFactors {
    public static void main(String[] st) {
        AllFactors q = new AllFactors();

        int N = 6;
        System.out.println(q.allFactors(N));
    }

    public ArrayList<Integer> allFactors(int a) {
        ArrayList<Integer> ans = new ArrayList<>();
        int k = 0;
        for (int i = 1; i * i <= a; i++) {
            if (a % i == 0) {
                ans.add(k, i);
                if (i != a / i) {
                    ans.add(k + 1, a / i);
                }
                k++;
            }
        }
        return ans;
    }
}
