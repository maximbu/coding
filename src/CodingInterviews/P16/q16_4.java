package CodingInterviews.P16;

/**
 * Created by max on 1/21/2017.
 */
public class q16_4 {
    public enum Piece {X, O, EMPTY}

    public Piece whoWon(Piece[][] board) {
        if (board == null) return Piece.EMPTY;
        int size = board.length;
        if (board[0].length != size) return Piece.EMPTY;

        for (Piece[] row : board) {
            Piece winner = whoWon(row);
            if (winner != Piece.EMPTY) return winner;
        }
        Piece[] option = new Piece[size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                option[j] = board[j][i];
            }
            Piece winner = whoWon(option);
            if (winner != Piece.EMPTY) return winner;
        }

        for (int i = 0; i < size; i++) {
            option[i] = board[i][i];
        }
        Piece winner = whoWon(option);
        if (winner != Piece.EMPTY) return winner;

        for (int i = 0; i < size; i++) {
            option[i] = board[i][size - i - 1];
        }
        winner = whoWon(option);
        if (winner != Piece.EMPTY) return winner;

        return Piece.EMPTY;
    }

    private Piece whoWon(Piece[] option) {
        Piece p = option[0];
        if (p == Piece.EMPTY) return Piece.EMPTY;
        for (int i = 1; i < option.length; i++) {
            if (p != option[i] || option[i] == Piece.EMPTY) return Piece.EMPTY;
        }
        return p;
    }
}
