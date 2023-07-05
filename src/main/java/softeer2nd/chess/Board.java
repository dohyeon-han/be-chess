package softeer2nd.chess;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Board {

    private final Pawn[][] board = new Pawn[8][8];

    public void initialize() {
        for (int i = 0; i < 8; i++) {
            Pawn white = new Pawn();
            board[6][i] = white;

            Pawn black = new Pawn(Pawn.BLACK_COLOR, Pawn.BLACK_REPRESENTATION);
            board[1][i] = black;
        }
    }

    public String getWhitePawnsResult() {
        return getRepresentationResult(board[6]);
    }

    public String getBlackPawnsResult() {
        return getRepresentationResult(board[1]);
    }

    private String getRepresentationResult(Pawn[] row) {
        return Arrays.stream(row)
                .map(Pawn::getRepresentation)
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
