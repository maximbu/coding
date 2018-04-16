package CodingInterviews.P10;

import CodingInterviews.utils.Matrix;

/**
 * Created by max on 12/30/2016.
 */
public class q10_9 {
    public static class Coord{
        int row;
        int col;

        public Coord(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public String toString() {
            return "Coord{" +
                    "row=" + row +
                    ", col=" + col +
                    '}';
        }
    }

    public static Coord sortedMatrixSearch(int[][] m,int x){
        int r = 0;
        int c = m[0].length-1;
        while (r<m.length && c>=0){
            if(m[r][c]==x){
                return new Coord(r,c);
            }
            if(m[r][c] > x){
                c--;
            }else {
                r++;
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
                System.out.println(v + ": " + sortedMatrixSearch(matrix, v));
            }
        }

    }
}
