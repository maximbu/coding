package CodingInterviews.utils;

/**
 * Created by max on 12/26/2016.
 */
public class Matrix {
    public static boolean[][] randomBooleanMatrix(int M) {
        boolean[][] matrix = new boolean[M][M];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                matrix[i][j] = Math.random()>0.4;
            }
        }
        return matrix;
    }

    public static int[][] randomMatrix(int M) {
        return randomMatrix(M,M);
    }

    public static int[][] randomMatrix(int M,int N) {
        int[][] matrix = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = (int) (Math.random() * 10);
            }
        }
        return matrix;
    }

    public static String printMatrix(int[][] matrix) {
        StringBuilder st = new StringBuilder();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] < 10 && matrix[i][j] > -10) {
                    st.append(" ");
                }
                if (matrix[i][j] < 100 && matrix[i][j] > -100) {
                    st.append(" ");
                }
                if (matrix[i][j] >= 0) {
                    st.append(" ");
                }
                st.append(" " + matrix[i][j]);
            }
            st.append("\n");
        }
        return st.toString();
    }

    public static void printMatrix(boolean[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j]) {
                    System.out.print("1");
                } else {
                    System.out.print("0");
                }
            }
            System.out.println();
        }
    }
}
