package interviewbit.arrays;

import java.util.ArrayList;
import java.util.Stack;
import java.util.stream.IntStream;

/**
 * You are given an array A containing N integers. The special product of each ith integer in this array is defined as the product of the following:<ul>
 *
 * LeftSpecialValue: For an index i, it is defined as the index j such that A[j]>A[i] (i>j). If multiple A[j]’s are present in multiple positions, the LeftSpecialValue is the maximum value of j.
 *
 * RightSpecialValue: For an index i, it is defined as the index j such that A[j]>A[i] (j>i). If multiple A[j]s are present in multiple positions, the RightSpecialValue is the minimum value of j.
 *
 * Write a program to find the maximum special product of any integer in the array.
 *
 * Input: You will receive array of integers as argument to function.
 *
 * Return: Maximum special product of any integer in the array modulo 1000000007.
 *
 * Note: If j does not exist, the LeftSpecialValue and RightSpecialValue are considered to be 0.
 *
 * Constraints 1 <= N <= 10^5 1 <= A[i] <= 10^9
 */
public class Maxspprod {
    public int maxSpecialProduct(ArrayList<Integer> A) {
        int n = A.size();
        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> q = new Stack<>();
        q.push(0);
        for (int i = 1; i < n; i++) {
            updateSpecial(A, left, q, i);
        }
        q.clear();
        q.push(n - 1);
        for (int i = n - 2; i >= 0; i--) {
            updateSpecial(A, right, q, i);
        }

        long mx = -1;
        for (int i = 0; i < n; i++) {
            mx = Long.max(mx, (long) left[i] * right[i]);
        }
        return (int) (mx % 1000000007);
    }

    private void updateSpecial(ArrayList<Integer> A, int[] special, Stack<Integer> q, int i) {
        while (!q.isEmpty()) {
            if (A.get(q.peek()) > A.get(i))
                break;
            q.pop();
        }
        special[i] = q.isEmpty() ? 0 : q.peek();
        q.push(i);
    }

    public int maxSpecialProductNaive(ArrayList<Integer> A) {
        long max = 0;
        for (int i = 1; i < A.size() - 1; i++) {
            int ind = i;
            int left = IntStream.iterate(i - 1, j -> j >= 0, j -> j - 1).filter(j -> A.get(j) > A.get(ind)).findFirst().orElse(0);
            int right = IntStream.range(i + 1, A.size()).filter(j -> A.get(j) > A.get(ind)).findFirst().orElse(0);
            long mul = left * right;
            max = Math.max(max, mul);
        }
        return (int) (max % 1000000007);
    }

}
