package softeer2nd.chess;

import softeer2nd.chess.util.PieceUtils;

public class Piece {

    private final PieceUtils.Color color;
    private final PieceUtils.Type type;

    public Piece(PieceUtils.Color color, PieceUtils.Type type) {
        this.color = color;
        this.type = type;
    }

    public static Piece createWhitePawn() {
        return new Piece(PieceUtils.Color.WHITE, PieceUtils.Type.PAWN);
    }

    public static Piece createBlackPawn() {
        return new Piece(PieceUtils.Color.BLACK, PieceUtils.Type.PAWN);
    }

    public PieceUtils.Color getColor() {
        return this.color;
    }

    public char getRepresentation() {
        if(this.color.equals(PieceUtils.Color.WHITE)){
            return this.type.getRepresentation();
        }
        return Character.toUpperCase(this.type.getRepresentation());
    }
}
