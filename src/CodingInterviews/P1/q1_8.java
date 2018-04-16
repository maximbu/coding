package CodingInterviews.P1;

import CodingInterviews.utils.Matrix;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by max on 12/16/2016.
 */
public class q1_8 {

    public static int[][] zeroMatrix(int[][] matrix){
        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();

        for (int i=0; i< matrix.length ; i++)
            for (int j=0; j< matrix[i].length ; j++)
            {
                if(matrix[i][j] == 0)
                {
                    rows.add(i);
                    cols.add(j);
                }
            }

        for (int i=0; i< matrix.length ; i++)
            for (int j=0; j< matrix[i].length ; j++)
            {
                if(rows.contains(i)||cols.contains(j))
                {
                    matrix[i][j]=0;
                }
            }
        return matrix;
    }


    public static void main(String[] args) {
        int[][] m = Matrix.randomMatrix(4,6);
        m[1][1] = 0;
        System.out.println("rotate(\n"+ Matrix.printMatrix(m)+")\n->\n"+Matrix.printMatrix(zeroMatrix(m)));

    }
}
