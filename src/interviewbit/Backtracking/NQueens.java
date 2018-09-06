package interviewbit.Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 *
 * N Queens: Example 1
 *
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 *
 * Each solution contains a distinct board configuration of the n-queens’ placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
 *
 * For example,
 * There exist two distinct solutions to the 4-queens puzzle:
 *
 * [
 *  [".Q..",  // Solution 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // Solution 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 */

public class NQueens {
    public ArrayList<ArrayList<String>> solveNQueens(int a) {
        int [] cols = new int[a];
        List<int[]> solutions = new ArrayList<>();
        solveQueens(cols,0,a,solutions);
        return printSolutions(solutions);
    }


    private  void solveQueens(int[] cols , int row , int n , List<int []> sol){
        if(row == n){
            sol.add(cols.clone());
            return;
        }
        for(int i=0;i<n;i++){
            if(canPlace(cols , row, i)){
                cols[row] = i;
                solveQueens(cols , row +1 , n , sol);
            }
        }
    }

    private boolean canPlace(int [] ans, int row, int col) {
        for (int r = 0; r < row; r++) {
            if (ans[r] == col || Math.abs(row - r) == Math.abs(col - ans[r])) {
                return false;
            }
        }
        return true;
    }

    private ArrayList<ArrayList<String>> printSolutions(List<int[]> solutions) {
        ArrayList<ArrayList<String>> arrayLists = new ArrayList<>();
        for (int[] solution : solutions) {
            ArrayList<String> strings = printSolution(solution);
            arrayLists.add(strings);
        }
        return arrayLists;
    }

    private ArrayList<String> printSolution(int[] s){
        ArrayList<String> arr = new ArrayList<>();
        int n =s.length;
        for (int value : s) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                String x = (value == j) ? "Q" : ".";
                sb.append(x);
            }
            arr.add(sb.toString());
        }
        return arr;
    }
}
