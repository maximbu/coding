package CodingInterviews2018.P16;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class q16_19 {

    private static List<Integer> ponds(int[][] board) {
        List<Integer> ans = new LinkedList<>();
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int lakeSize = exploreLake(board,i,j,visited);
                if(lakeSize > 0) {
                    ans.add(lakeSize);
                }
            }

        }
        return ans;
    }

    private static int exploreLake(int[][] board, int i, int j, boolean[][] visited) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length || visited[i][j] || board[i][j] > 0) return 0;
        visited[i][j] = true;
        int size = 1;
        for (int k = -1; k < 2; k++) {
            for (int l = -1; l < 2; l++) {
                size += exploreLake(board, i + k, j + l, visited);
            }
        }
        return size;
    }

    private static String printBoard(int[][] board) {
        StringBuilder sb = new StringBuilder();
        for (int[] ints : board) {
            sb.append(Arrays.toString(ints)).append(System.lineSeparator());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int[][] board ={{0,2,1,0},{0,1,0,1},{1,1,0,1},{0,1,0,1}};
        System.out.printf("Board:%n%shas lakes of sizes:%s%n", printBoard(board), ponds(board));
    }
}
