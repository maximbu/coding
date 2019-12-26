package interviewbit.DynamicProgramming;

import java.util.Arrays;

/**
 * The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon. The dungeon consists of M x N rooms laid out in a 2D grid. Our valiant knight (K) was initially positioned in the top-left room and must fight his way through the dungeon to rescue the princess.
 *
 * The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, he dies immediately.
 *
 * Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms; other rooms are either empty (0’s) or contain magic orbs that increase the knight’s health (positive integers).
 *
 * In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.
 *
 * Write a function to determine the knight’s minimum initial health so that he is able to rescue the princess.
 *
 * For example, given the dungeon below, the initial health of the knight must be at least 7 if he follows the optimal path
 *
 * RIGHT-> RIGHT -> DOWN -> DOWN.
 *
 * Dungeon Princess: Example 1
 *
 *
 *
 * Input arguments to function:
 * Your function will get an M*N matrix (2-D array) as input which represents the 2D grid as described in the question. Your function should return an integer corresponding to the knight’s minimum initial health required.
 *
 *
 *
 *  Note:
 * The knight’s health has no upper bound.
 * Any room can contain threats or power-ups, even the first room the knight enters and the bottom-right room where the princess is imprisoned.
 */
public class DungeonPrincess {
    public int calculateMinimumHP(int[][] A) {
        long[] curr = new long[A[0].length];
        for (int i = A.length - 1; i >= 0; i--) {
            long[] prev = Arrays.copyOf(curr, curr.length);
            curr = new long[A[0].length];
            for (int j = A[0].length - 1; j >= 0; j--) {
                if (i == A.length - 1 && j == A[0].length - 1) {
                    curr[j] = A[i][j];
                    continue;
                }
                if (i < A.length - 1 && j < A[0].length - 1) {
                    curr[j] += Math.max(prev[j], curr[j + 1]);
                }
                if (i == A.length - 1) {
                    curr[j] += curr[j + 1];
                }
                if (j == A[0].length - 1) {
                    curr[j] += prev[j];
                }
                curr[j] += A[i][j];
                curr[j] = Math.min(curr[j], A[i][j]);
            }
        }
        return Math.max((int) (-1 * (curr[0] - 1)), 1);
    }

    public static void main(String[] st) {
        DungeonPrincess q = new DungeonPrincess();
        int[][] a = {{0, 0, 0}, {-1, -1, -1}, {-1, -1, 100}};
        System.out.println(q.calculateMinimumHP(a));
    }
}
