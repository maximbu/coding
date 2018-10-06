package interviewbit.DynamicProgramming;

import java.util.Arrays;

/**
 * On a N * M chessboard, where rows are numbered from 1 to N and columns from 1 to M, there are queens at some cells. Return a N * M array A, where A[i][j] is number of queens that can attack cell (i, j). While calculating answer for cell (i, j), assume there is no queen at that cell.
 *
 * Notes:
 *
 * Queen is able to move any number of squares vertically, horizontally or diagonally on a chessboard. A queen cannot jump over another queen to attack a position.
 * You are given an array of N strings, each of size M. Each character is either a 1 or 0 denoting if there is a queen at that position or not, respectively.
 * Expected time complexity is worst case O(N*M).
 * For example,
 *
 * Let chessboard be,
 * [0 1 0]
 * [1 0 0]
 * [0 0 1]
 *
 * where a 1 denotes a queen at that position.
 *
 * Cell (1, 1) is attacked by queens at (2, 1), (1,2) and (3,3).
 * Cell (1, 2) is attacked by queen at (2, 1). Note that while calculating this, we assume that there is no queen at (1, 2).
 * Cell (1, 3) is attacked by queens at (3, 3) and (1, 2).
 * and so on...
 *
 * Finally, we return matrix
 * [3, 1, 2]
 * [1, 3, 3]
 * [2, 3, 0]
 */
public class QueenAttack {
    public int[][] queenAttack(String[] A) {
        int[][] ans = new int[A.length][A[0].length()];
        int[][] rowsLeft = rowsLeft(A);
        int[][] rowsRight = rowsRight(A);
        int[][] colsUp = colsUp(A);
        int[][] colsDown = colsDown(A);
        int[][] diag1Up = diag1Up(A);
        int[][] diag1Down = diag1Down(A);
        int[][] diag2Up = diag2Up(A);
        int[][] diag2Down = diag2Down(A);

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length(); j++) {
                ans[i][j] = rowsLeft[i][j] + rowsRight[i][j] + colsUp[i][j] + colsDown[i][j] + diag1Up[i][j] + diag1Down[i][j]+diag2Up[i][j]+diag2Down[i][j];
            }
        }
        return ans;
    }

    private int[][] diag2Down(String[] A) {
        int[][] tmp = new int[A.length][A[0].length()];
        for (int i = A.length - 1; i > 0; i--) {
            for (int j = 0; j < A[0].length() - 1; j++) {
                tmp[i-1][j+1] = A[i].charAt(j) == '1' ? 1 : tmp[i][j];
            }
        }
        return tmp;
    }

    private int[][] diag2Up(String[] A) {
        int[][] tmp = new int[A.length][A[0].length()];
        for (int i = 0; i < A.length-1; i++) {
            for (int j = A[0].length() - 1; j > 0; j--) {
                tmp[i+1][j-1] = A[i].charAt(j) == '1' ? 1 : tmp[i][j];
            }
        }
        return tmp;
    }

    private int[][] diag1Down(String[] A) {
        int[][] tmp = new int[A.length][A[0].length()];
        for (int i = A.length - 1; i > 0; i--) {
            for (int j = A[0].length() - 1; j > 0; j--) {
                tmp[i-1][j-1] = A[i].charAt(j) == '1' ? 1 : tmp[i][j];
            }
        }
        return tmp;
    }

    private int[][] diag1Up(String[] A) {
        int[][] tmp = new int[A.length][A[0].length()];
        for (int i = 0; i < A.length-1; i++) {
            for (int j = 0; j < A[0].length()-1; j++) {
                tmp[i+1][j+1] = A[i].charAt(j) == '1' ? 1 : tmp[i][j];
            }
        }
        return tmp;
    }

    private int[][] colsDown(String[] A) {
        int[][] tmp = new int[A.length][A[0].length()];
        for (int j = A[0].length() - 1; j > 0; j--) {
            for (int i = A.length - 1; i >= 0; i--) {
                tmp[i][j - 1] = A[i].charAt(j) == '1' ? 1 : tmp[i][j];
            }
        }
        return tmp;
    }

    private int[][] colsUp(String[] A) {
        int[][] tmp = new int[A.length][A[0].length()];
        for (int j = 0; j < A[0].length()-1; j++) {
            for (int i = 0; i < A.length; i++) {
                tmp[i][j + 1] = A[i].charAt(j) == '1' ? 1 : tmp[i][j];
            }
        }
        return tmp;
    }

    private int[][] rowsRight(String[] A) {
        int[][] tmp = new int[A.length][A[0].length()];
        for (int i = A.length - 1; i > 0; i--) {
            for (int j = A[0].length() - 1; j >= 0; j--) {
                tmp[i - 1][j] = A[i].charAt(j) == '1' ? 1 : tmp[i][j];
            }
        }
        return tmp;
    }

    private int[][] rowsLeft(String[] A) {
        int[][] tmp = new int[A.length][A[0].length()];
        for (int i = 0; i < A.length-1; i++) {
            for (int j = 0; j < A[0].length(); j++) {
                tmp[i + 1][j] = A[i].charAt(j) == '1' ? 1 : tmp[i][j];
            }
        }
        return tmp;
    }

    public static void main(String[] st){
        QueenAttack q = new QueenAttack();
        String[] a = {"111","111","111"};
        System.out.println(Arrays.deepToString(q.queenAttack(a)));
    }
}
