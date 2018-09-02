package CodingInterviews2018.P10;

import CodingInterviews.utils.Matrix;
import java.awt.Point;

public class q10_9 {
    private static Point findInMatrix(int[][] arr,int x) {
        int i=0 , j=arr[i].length-1;
        while(i<arr.length && j >=0){
            if(arr[i][j] == x) {
                return new Point(i,j);
            }
            if(arr[i][j]<x){
                i++;
            }
            else{
                j--;
            }
        }
        return null;
    }


    public static void main(String[] args) {
        int M = 10;
        int N = 5;
        int[][] matrix = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = 10 * i + j;
            }
        }

        System.out.println(Matrix.printMatrix(matrix));



        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                int v = 10 * i + j;
                System.out.println(v + ": " + findInMatrix(matrix, v));
            }
        }

    }
}
