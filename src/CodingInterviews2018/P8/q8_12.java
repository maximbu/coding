package CodingInterviews2018.P8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class q8_12 {
    private static List<int []> eightQueens(){
        int [] cols = new int[8];
        List<int[]> solutions = new ArrayList<>();
        solveQueens(cols,0,8,solutions);
        return solutions;
    }



    private static void solveQueens(int[] cols , int row , int n , List<int []> sol){
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

    private static boolean canPlace(int [] ans, int row, int col) {
        return IntStream.range(0, row).noneMatch(r -> ans[r] == col || Math.abs(row - r) == Math.abs(col - ans[r]));
    }


    private static void printSolutions(List<int[]> s){
        s.forEach(q8_12::printSolution);
    }

    private static void printSolution(int[] s){
        int n =s.length;
        for (int value : s) {
            IntStream.range(0, n).mapToObj(j -> (value == j) ? "Q" : "x").forEach(System.out::print);
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] st){
        printSolutions(eightQueens());
    }
}
