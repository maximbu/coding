package interviewbit.stacksAndQueues;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Given an array, find the nearest smaller element G[i] for every element A[i] in the array such that the element has an index smaller than i.
 *
 * More formally,
 *
 * G[i] for an element A[i] = an element A[j] such that
 *     j is maximum possible AND
 *     j < i AND
 *     A[j] < A[i]
 * Elements for which no smaller element exist, consider next smaller element as -1.
 *
 * Example:
 *
 * Input : A : [4, 5, 2, 10, 8]
 * Return : [-1, 4, -1, 2, 2]
 *
 * Example 2:
 *
 * Input : A : [3, 2, 1]
 * Return : [-1, -1, -1]
 *
 */
public class NearestSmallerElement {
    public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        if (A == null || A.size() == 0) {
            throw new IllegalArgumentException();
        }
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for (Integer currElement : A) {
            while (!stack.isEmpty() && stack.peek() >= currElement) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                ans.add(-1);
                stack.push(currElement);
            } else {
                ans.add(stack.peek());
                if (currElement < stack.peek()) {
                    stack.pop();
                }
                stack.push(currElement);
            }

        }
        return ans;
    }
}
