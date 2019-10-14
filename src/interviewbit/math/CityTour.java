package interviewbit.math;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * There are A cities numbered from 1 to A. You have already visited M cities, the indices of which are given in an array B of M integers.
 *
 * If a city with index i is visited, you can visit either the city with index i-1 (i >= 2) or the city with index i+1 (i < A) if they are not already visited.
 * Eg: if N = 5 and array M consists of [3, 4], then in the first level of moves, you can either visit 2 or 5.
 *
 * You keep visiting cities in this fashion until all the cities are not visited.
 * Find the number of ways in which you can visit all the cities modulo 10^9+7.
 *
 * Input Format
 *
 * The 1st argument given is an integer A, i.e total number of cities.
 * The 2nd argument given is an integer array B, where B[i] denotes ith city you already visited.
 * Output Format
 *
 * Return an Integer X % (1e9 + 7), number of ways in which you can visit all the cities.
 * Constraints
 *
 * 1 <= A <= 1000
 * 1 <= M <= A
 * 1 <= B[i] <= A
 * For Example
 *
 * Input:
 *     A = 5
 *     B = [2, 5]
 * Output:
 *     6
 *
 * Explanation:
 *     All possible ways to visit remaining cities are :
 *     1. 1 -> 3 -> 4
 *     2. 1 -> 4 -> 3
 *     3. 3 -> 1 -> 4
 *     4. 3 -> 4 -> 1
 *     5. 4 -> 1 -> 3
 *     6. 4 -> 3 -> 1
 */
public class CityTour {
    public static void main(String[] st) {
        CityTour q = new CityTour();

        int A = 6;
        ArrayList<Integer> B = new ArrayList<>(Arrays.asList(2,5));
        System.out.println(q.solve(A,B));

        A = 3;
        B = new ArrayList<>(Arrays.asList(1));
        System.out.println(q.solve(A,B));
    }

    public int solve2(int A, ArrayList<Integer> B) {
        int options = options(A,B);
        int ans = fact2(options).mod(new BigInteger("1000000007")).intValue();
        return ans;
    }

    private int options(int a, ArrayList<Integer> b) {
        b.sort(Integer::compareTo);
        int mul = 1;
        for (int i = 0; i < b.size(); i++) {
            int visited = b.get(i);
            if (visited == 1 || visited == a) continue;
            boolean canGoLeft = (i == 0 || b.get(i - 1) + 1 != visited);
            boolean canGoRight = (i == b.size() - 1 || b.get(i + 1) - 1 != visited);
            if (canGoLeft && canGoRight) {
                mul *= 2;
            }
        }
        return mul-1;
    }
    int MOD = 1000000007;

    public int solve(int a, ArrayList<Integer> b) {
        b.sort(Integer::compareTo);
        long comb = 1;
        int len = b.get(0) - 1;
        for (int i = 1; i < b.size(); i++) {
            int l = b.get(i) - b.get(i - 1) - 1;
            if (l > 0) {
                int c = 1 << (l - 1);
                comb = calc(len, comb, l, c) % MOD;
                len += l;
            }
        }
        return (int) calc(len, comb, a - b.get(b.size() - 1), 1) % MOD;
    }

    private long calc(int l1, long c1, int l2, int c2) {
        return (c1 * c2 * fact(l1 + l2)) / (fact(l1) * fact(l2)) % MOD;
    }

    HashMap<Long,Long> map = new HashMap<>();
    private long fact(long i) {
        if (map.containsKey(i)) return map.get(i);
        long f = 1;
        long orig = i;
        while (i > 1) {
            f = (f * i--) % MOD;
        }
        map.put(orig, f);
        return f;
    }


    public static BigInteger fact2(int x) {
        BigInteger temp = BigInteger.ONE;
        for (int i = 1; i <=x ; i++) {
            temp = temp.multiply(BigInteger.valueOf(i));
        }
        return temp;
    }
}
