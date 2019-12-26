package interviewbit.stacksAndQueues;

import java.util.Stack;

public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] A) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int i = 0;
        while (i < A.length || !stack.isEmpty()) {
            if (stack.isEmpty() || (i < A.length && A[stack.peek()] <= A[i])) {
                stack.push(i++);
                continue;
            }
            int area = A[stack.pop()] * (stack.isEmpty() ? i : (i - stack.peek() - 1));
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

    public static void main(String[] st) {
        LargestRectangleInHistogram q = new LargestRectangleInHistogram();
        System.out.println(q.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
    }
}
