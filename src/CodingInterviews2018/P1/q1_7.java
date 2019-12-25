package CodingInterviews2018.P1;

import CodingInterviews.utils.Matrix;

public class q1_7 {

  private static int[][] rotate(int[][] matrix) {
    int tmp;
    int halfLen = matrix.length / 2;
    for (int i = 0; i < halfLen; i++) {
      int flipI = matrix.length - 1 - i;
      for (int j = i; j < flipI; j++) {
        int flipJ = matrix.length - 1 - j;
        tmp = matrix[i][j];
        matrix[i][j] = matrix[flipJ][i];
        matrix[flipJ][i] = matrix[flipI][flipJ];
        matrix[flipI][flipJ] = matrix[j][flipI];
        matrix[j][flipI] = tmp;
      }
    }
    return matrix;
  }

  public static void main(String[] args) {
    int[][] m = Matrix.randomMatrix(5);
    System.out
            .println("rotate(\n" + Matrix.printMatrix(m) + ")\n->\n" + Matrix.printMatrix(rotate(m)));
  }
}
