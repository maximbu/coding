package interviewbit.stacksAndQueues;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
 *
 * Example :
 *
 * Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 *
 * Rain water trapped: Example 1
 *
 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
 * In this case, 6 units of rain water (blue section) are being trapped.
 */
public class RainWaterTrapped {
    public int trap(final List<Integer> A) {
        int drops = 0;
        int leftMax = 0;
        int rightMax = 0;
        int from = 0;
        int to = A.size() - 1;
        while (from <= to) {
            if (A.get(from) < A.get(to)) {
                leftMax = Math.max(leftMax, A.get(from));
                drops += leftMax - A.get(from++);
            } else {
                rightMax = Math.max(rightMax, A.get(to));
                drops += rightMax - A.get(to--);
            }
        }
        return drops;
    }

    public static void main(String[] st) {
        RainWaterTrapped q = new RainWaterTrapped();
        System.out.println(q.trap(Arrays.asList(10,4,3,6)));
        System.out.println(q.trap(Arrays.asList(56, 6, 52, 43, 23, 47, 48, 38, 96,46,30,66)));
        System.out.println(q.trap(Arrays.asList(56, 6, 52, 43, 23, 47, 48, 38, 96, 46, 30, 66, 80)));
        System.out.println(q.trap(Arrays.asList(56, 6, 52, 43, 23, 47, 48, 38, 96, 46, 30, 66, 80, 15, 62, 71, 61, 12, 98, 9, 28, 81, 70, 59, 95, 34, 9, 60, 70, 81, 71, 67, 58, 20, 22, 3, 95, 85, 20, 24, 74, 5, 23, 33, 75, 50, 38, 75, 68, 26, 46, 30, 75, 18, 4, 42, 51, 59, 8, 77)));
        System.out.println(q.trap(Arrays.asList(0,1,0,2,1,0,1,3,2,1,2,1)));
        System.out.println(q.trap(Arrays.asList(2,1,0,1,2,0,2,0,2)));
    }
}
