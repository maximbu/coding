package CodingInterviews2018.P16;

import java.util.Arrays;
import java.util.Optional;

public class q16_4 {

    private static Optional<Character> ticTacToeWinner(Character[][] board) {
        Optional<Character> rows = checkRows(board);
        if (rows.isPresent()) return rows;
        Optional<Character> cols = checkCols(board);
        if (cols.isPresent()) return cols;
        return checkDiags(board);
    }

    private static Optional<Character> checkDiags(Character[][] board) {
        Optional<Character> ans = check(board, 0, 0, 1, 1);
        if (ans.isPresent()) return ans;
        return check(board, 0, board[0].length - 1, 1, -1);
    }

    private static Optional<Character> checkCols(Character[][] board) {
        for (int i = 0; i < board[0].length; i++) {
            Optional<Character> ans = check(board, 0, i, 1, 0);
            if (ans.isPresent()) return ans;
        }
        return Optional.empty();
    }

    private static Optional<Character> checkRows(Character[][] board) {
        for (int i = 0; i < board.length; i++) {
            Optional<Character> ans = check(board, i, 0, 0, 1);
            if (ans.isPresent()) return ans;
        }
        return Optional.empty();
    }

    private static Optional<Character> check(Character[][] board, int fromRow, int fromCol, int rowJump, int colJump) {
        Character first = board[fromRow][fromCol];
        if (first.equals(' ')) return Optional.empty();
        for (int i = fromRow, j = fromCol; i < board.length && j < board[i].length; i += rowJump, j += colJump) {
            if (!board[i][j].equals(first)) return Optional.empty();
        }
        return Optional.of(first);
    }


    public static void main(String[] args) {
        Character[][] b1 = new Character[3][3];
        for (Character[] characters : b1) {
            Arrays.fill(characters, ' ');
        }
        b1[0][0] = 'X';
        b1[1][1] = 'X';
        b1[2][2] = 'X';
        System.out.println(ticTacToeWinner(b1));

        Character[][] b2 = new Character[4][4];
        for (Character[] characters : b2) {
            Arrays.fill(characters, ' ');
        }
        b2[2][0] = 'X';
        b2[2][1] = 'X';
        b2[2][2] = 'X';
        b2[2][3] = 'X';

        System.out.println(ticTacToeWinner(b2));

        Character[][] b3 = new Character[4][4];
        for (Character[] characters : b3) {
            Arrays.fill(characters, ' ');
        }
        b3[2][0] = 'X';
        b3[2][1] = 'X';
        b3[2][2] = 'X';
        b3[2][3] = '0';
        b3[3][3] = 'X';
        b3[1][1] = '0';

        System.out.println(ticTacToeWinner(b3));
    }
}
