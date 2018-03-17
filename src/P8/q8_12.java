package P8;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by max on 12/28/2016.
 */
public class q8_12 {
    public static List<int []> eightQueens(){
        int [] cols = new int[8];
        List<int[]> solutions = new ArrayList<>();
        return solveQueens(cols,0,8,solutions);
    }

    public static void printSolutions(List<int[]> s){
        for(int[] sol :s){
            printSolution(sol);
            System.out.println();
        }
    }

    private static void printSolution(int[] s){
        int n =s.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++) {
                System.out.print((s[i] == j) ? "Q" : "x");
            }
            System.out.println();
        }
    }

    private static List<int[]> solveQueens(int [] cols,int i, int n,List<int[]> solutions){
        if(i==n){
            solutions.add(cols.clone());
            return solutions;
        }

        for(int j=0;j<n;j++){
            if(canPlace(cols,i,j)){
                cols[i]=j;
                solveQueens(cols,i+1,n,solutions);
            }
        }
        return solutions;
    }

    private static boolean canPlace(int [] ans, int i, int j) {
        for(int row=0;row<i;row++){
            if(ans[row] == j) return false;
            if(Math.abs(i-row)==Math.abs(j-ans[row])) return false;
        }
        return true;
    }

    public static void main(String[] st){
        printSolutions(eightQueens());
    }

}
