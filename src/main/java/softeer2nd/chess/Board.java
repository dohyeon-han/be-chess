package softeer2nd.chess;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Board {

    private final List<Pawn> whitePawns = new ArrayList<>();
    private final List<Pawn> blackPawns = new ArrayList<>();
    private final Pawn[][] board = new Pawn[8][8];

    public void initialize() {
        for (int i = 0; i < 8; i++) {
            Pawn white = new Pawn();
            whitePawns.add(white);
            board[1][i] = white;

            Pawn black = new Pawn(Pawn.BLACK_COLOR, Pawn.BLACK_REPRESENTATION);
            blackPawns.add(black);
            board[6][i] = black;
        }
    }

    public String getWhitePawnsResult() {
        return whitePawns.stream()
                .map(Pawn::getRepresentation)
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    public String getBlackPawnsResult() {
        return blackPawns.stream()
                .map(Pawn::getRepresentation)
                .map(String::valueOf)
                .collect(Collectors.joining());
    }
}
