package interviewbit.math;

/**
 A robot is located at the top-left corner of an A x B grid (marked ‘Start’ in the diagram below).

 Path Sum: Example 1

 The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked ‘Finish’ in the diagram below).

 How many possible unique paths are there?

 Note: A and B will be such that the resulting answer fits in a 32 bit signed integer.
 **/
public class GridUniquePaths {
    public static void main(String[] st) {
        GridUniquePaths q = new GridUniquePaths();

        int N = 2;
        int M = 2;
        System.out.println(q.uniquePaths(N, M));

        N = 5;
        M = 6;
        System.out.println(q.uniquePaths(N, M));
    }

    public int uniquePaths(int a, int b) {
        int[][] options = new int[a][b];
        for (int i = 0; i < a; i++) {
            options[i][0] = 1;
        }
        for (int i = 0; i < b; i++) {
            options[0][i] = 1;
        }
        for (int i = 1; i < a; i++) {
            for (int j = 1; j < b; j++) {
                options[i][j] = options[i - 1][j] + options[i][j - 1];
            }
        }
        return options[a - 1][b - 1];
    }
}
