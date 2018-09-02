package CodingInterviews2018.P1;

import CodingInterviews.utils.Matrix;
import java.util.Arrays;
import java.util.stream.IntStream;

public class q1_8 {

  private static int[][] zero(int[][] matrix) {
    boolean firstRowZero = IntStream.range(0, matrix[0].length).
        anyMatch(i -> matrix[0][i] == 0);
    boolean firstColZero = Arrays.stream(matrix).
        anyMatch(aMatrix -> aMatrix[0] == 0);

    for (int i = 1; i < matrix.length; i++) {
      for (int j = 1; j < matrix[i].length; j++) {
        if (matrix[i][j] == 0) {
          matrix[0][j] = matrix[i][0] = 0;
        }
      }
    }
    for (int i = 1; i < matrix[0].length; i++) {
      if (matrix[0][i] == 0) {
        for (int j = 1; j < matrix.length; j++) {
          matrix[j][i] = 0;
        }
      }
    }
    for (int i = 1; i < matrix.length; i++) {
      if (matrix[i][0] == 0) {
        for (int j = 1; j < matrix[i].length; j++) {
          matrix[i][j] = 0;
        }
      }
    }
    if (firstRowZero) {
      for (int j = 0; j < matrix[0].length; j++) {
        matrix[0][j] = 0;
      }
    }
    if (firstColZero) {
      for (int j = 0; j < matrix.length; j++) {
        matrix[j][0] = 0;
      }
    }
    return matrix;
  }

  public static void main(String[] args) {
    int[][] m = Matrix.randomMatrix(4, 6);
    m[1][1] = 0;
    System.out.println(
        "rotate(\n" + Matrix.printMatrix(m) + ")\n->\n" + Matrix.printMatrix(zero(m)));

  }

}
