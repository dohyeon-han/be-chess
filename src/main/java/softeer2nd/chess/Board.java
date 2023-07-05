package softeer2nd.chess;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Board {

    private final Piece[][] board = new Piece[8][8];

    public void initialize() {
        for (int i = 0; i < 8; i++) {
            Piece white = new Piece(Piece.WHITE_COLOR, Piece.WHITE_REPRESENTATION);
            board[6][i] = white;

            Piece black = new Piece(Piece.BLACK_COLOR, Piece.BLACK_REPRESENTATION);
            board[1][i] = black;
        }
    }

    public String getWhitePawnsResult() {
        return getRepresentationResult(board[6]);
    }

    public String getBlackPawnsResult() {
        return getRepresentationResult(board[1]);
    }

    private String getRepresentationResult(Piece[] row) {
        return Arrays.stream(row)
                .map(Piece::getRepresentation)
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    public void print() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == null) {
                    builder.append('.');
                } else {
                    builder.append(board[i][j].getRepresentation());
                }
            }
            builder.append('\n');
        }
        System.out.println(builder);
    }
}
