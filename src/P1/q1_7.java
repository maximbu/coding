package P1;

import utils.Matrix;

/**
 * Created by max on 12/16/2016.
 */
public class q1_7 {
    //      A|B
    //      ---
    //      C|D
    public static int[][] rotate(int[][] matrix){
        int halfLen =matrix.length/2;
        for (int i = 0; i < halfLen; i++) {
            int last = matrix.length - 1 - i;
            for (int j = i;  j< last; j++) {
                int rotated = matrix.length - 1 - j;
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[rotated][i];
                matrix[rotated][i] = matrix[last][rotated];
                matrix[last][rotated] = matrix[j][last];
                matrix[j][last] = tmp;
            }
        }
        return matrix;
    }




    public static void main(String[] args) {
        int[][] m = Matrix.randomMatrix(3);
        System.out.println("rotate(\n"+Matrix.printMatrix(m)+")\n->\n"+ Matrix.printMatrix(rotate(m)));

    }
}
