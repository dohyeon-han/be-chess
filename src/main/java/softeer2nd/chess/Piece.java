package softeer2nd.chess;

import softeer2nd.chess.util.PieceUtils;

public class Piece {
    public static final char WHITE_PAWN_REPRESENTATION = 'p';
    public static final char BLACK_PAWN_REPRESENTATION = 'P';

    private final PieceUtils.Color color;
    private final char representation;

    public Piece(PieceUtils.Color color, char representation) {
        this.color = color;
        this.representation = representation;
    }

    public static Piece createWhitePawn() {
        return new Piece(PieceUtils.Color.WHITE, WHITE_PAWN_REPRESENTATION);
    }

    public static Piece createBlackPawn() {
        return new Piece(PieceUtils.Color.BLACK, BLACK_PAWN_REPRESENTATION);
    }

    public PieceUtils.Color getColor() {
        return this.color;
    }

    public char getRepresentation() {
        return this.representation;
    }
}
