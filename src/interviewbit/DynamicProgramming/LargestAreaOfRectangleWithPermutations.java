package interviewbit.DynamicProgramming;

/**
 * Given a binary grid i.e. a 2D grid only consisting of 0’s and 1’s, find the area of the largest rectangle inside the grid such that all the cells inside the chosen rectangle should have 1 in them. You are allowed to permutate the columns matrix i.e. you can arrange each of the column in any order in the final grid. Please follow the below example for more clarity.
 *
 * Lets say we are given a binary grid of 3 * 3 size.
 *
 * 1 0 1
 *
 * 0 1 0
 *
 * 1 0 0
 *
 * At present we can see that max rectangle satisfying the criteria mentioned in the problem is of 1 * 1 = 1 area i.e either of the 4 cells which contain 1 in it. Now since we are allowed to permutate the columns of the given matrix, we can take column 1 and column 3 and make them neighbours. One of the possible configuration of the grid can be:
 *
 * 1 1 0
 *
 * 0 0 1
 *
 * 1 0 0
 *
 * Now In this grid, first column is column 1, second column is column 3 and third column is column 2 from the original given grid. Now, we can see that if we calculate the max area rectangle, we get max area as 1 * 2 = 2 which is bigger than the earlier case. Hence 2 will be the answer in this case.
 */
public class LargestAreaOfRectangleWithPermutations {

    public int solve(int[][] A) {
        int[][] B = createSumArray(A);
        int max = 0;
        for (int[] aB : B) {
            sort(aB, A.length);
            max = Math.max(max, maxArea(aB));
        }
        return max;
    }

    private int[][] createSumArray(int[][] A) {
        int[][] B = new int[A.length][A[0].length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                B[i][j] = A[i][j];
                if (A[i][j] != 0 && i != 0) {
                    B[i][j] += B[i - 1][j];
                }
            }
        }
        return B;
    }

    private void sort(int[] A, int max) {
        int[] cnt = new int[max + 1];
        for (int x : A) {
            cnt[x]++;
        }

        int cntInd = 0;
        for (int ind = A.length - 1; ind >= 0; ind--) {
            while (cnt[cntInd] == 0) {
                cntInd++;
            }
            A[ind] = cntInd;
            cnt[cntInd]--;
        }
    }

    private int maxArea(int[] A) {
        int maxArea = 0;
        for (int i = 0; i < A.length; i++) {
            maxArea = Math.max(maxArea, (i + 1) * A[i]);
        }
        return maxArea;
    }

    public static void main(String[] st) {
        LargestAreaOfRectangleWithPermutations q = new LargestAreaOfRectangleWithPermutations();
        int[][] A = {{1, 0, 1}, {1, 0, 1}, {1, 0, 1}};
        System.out.println(q.solve(A));
        int[][] B = {{1, 1, 0}, {1, 0, 1}};
        System.out.println(q.solve(B));
    }
}
