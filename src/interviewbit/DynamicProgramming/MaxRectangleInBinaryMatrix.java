package interviewbit.DynamicProgramming;

import Algo.Stack;
import java.util.Arrays;

/**
 * Given a 2D binary matrix filled with 0’s and 1’s, find the largest rectangle containing all ones and return its area.
 *
 * Bonus if you can solve it in O(n^2) or less.
 *
 * Example :
 *
 * A : [  1 1 1
 *        0 1 1
 *        1 0 0
 *     ]
 *
 * Output : 4
 *
 * As the max area rectangle is created by the 2x2 rectangle created by (0,1), (0,2), (1,1) and (1,2)
 *
 */
public class MaxRectangleInBinaryMatrix {

    public int maximalRectangle(int[][] A) {
        int[][] height = new int[A.length][A[0].length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] != 0) {
                    if (i > 0) {
                        height[i][j] = height[i - 1][j] + 1;
                    } else {
                        height[i][j] = 1;
                    }
                }
            }
        }
        return Arrays.stream(height).map(this::largestArea).max(Integer::compareTo).get();
    }

    private Integer largestArea(int[] input) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int i = 0;
        while (i < input.length || !stack.isEmpty()) {
            if (stack.isEmpty() || (i < input.length && input[stack.peek()] <= input[i])) {
                stack.push(i++);
                continue;
            }
            int area = input[stack.pop()] * (stack.isEmpty() ? i : (i - stack.peek() - 1));
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

    public static void main(String[] st) {
        MaxRectangleInBinaryMatrix q = new MaxRectangleInBinaryMatrix();
        int[][] A = new int[3][3];
        A[0] = new int[]{1, 1, 1};
        A[1] = new int[]{0, 1, 1};
        A[2] = new int[]{1, 0, 0};
        System.out.println(q.maximalRectangle(A));

        int[][] T = new int[3][3];
        T[0] = new int[]{1, 1, 1};
        T[1] = new int[]{1, 0, 1};
        T[2] = new int[]{1, 1, 1};
        System.out.println(q.maximalRectangle(T));

        int[][] B = new int[5][4];
        B[0] = new int[]{1, 1, 1, 1};
        B[1] = new int[]{0, 1, 1, 1};
        B[2] = new int[]{0, 1, 1, 1};
        B[3] = new int[]{1, 0, 1, 1};
        B[4] = new int[]{1, 0, 1, 1};
        System.out.println(q.maximalRectangle(B));

        int[][] C = {
                {1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1},
                {1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1},
                {1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 0},
                {1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1},
                {1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1},
        };
        System.out.println(q.maximalRectangle(C));
    }
}
