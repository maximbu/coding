package interviewbit.DynamicProgramming;

import java.util.ArrayList;

/**
 * Given a grid of size m * n, lets assume you are starting at (1,1) and your goal is to reach (m,n). At any instance, if you are on (x,y), you can either go to (x, y + 1) or (x + 1, y).
 *
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 *
 * Example :
 * There is one obstacle in the middle of a 3x3 grid as illustrated below.
 *
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * The total number of unique paths is 2.
 *
 *  Note: m and n will be at most 100.
 */
public class UniquePathsInAGrid {
    public int uniquePathsWithObstacles(ArrayList<ArrayList<Integer>> A) {
        int[][] m = new int[A.size()][A.get(0).size()];
        m[0][0] = 1 - A.get(0).get(0);
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (i == 0 && j == 0)
                    continue;
                if (A.get(i).get(j) == 1) {
                    m[i][j] = 0;
                    continue;
                }
                m[i][j] = (i > 0 ? m[i - 1][j] : 0) + (j > 0 ? m[i][j - 1] : 0);
            }
        }
        return m[m.length - 1][m[0].length - 1];
    }

    public static void main(String[] st) {
        UniquePathsInAGrid q = new UniquePathsInAGrid();
        ArrayList<ArrayList<Integer>> a = new ArrayList<>();
        ArrayList<Integer> a0 = new ArrayList<>();
        a0.add(0);
        a.add(a0);
        System.out.println(q.uniquePathsWithObstacles(a));
    }
}
