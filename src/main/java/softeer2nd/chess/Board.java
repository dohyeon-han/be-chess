package softeer2nd.chess;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Board {

    private final Pawn[][] board = new Pawn[8][8];

    public void initialize() {
        for (int i = 0; i < 8; i++) {
            Pawn white = new Pawn();
            board[1][i] = white;

            Pawn black = new Pawn(Pawn.BLACK_COLOR, Pawn.BLACK_REPRESENTATION);
            board[6][i] = black;
        }
    }

    public String getWhitePawnsResult() {
        return Arrays.stream(board[1])
                .map(Pawn::getRepresentation)
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    public String getBlackPawnsResult() {
        return Arrays.stream(board[6])
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
