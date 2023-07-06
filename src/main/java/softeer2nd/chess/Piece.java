package softeer2nd.chess;

import softeer2nd.chess.util.PieceUtils;

public class Piece {

    private final PieceUtils.Color color;
    private final PieceUtils.Type type;

    private Piece(PieceUtils.Color color, PieceUtils.Type type) {
        this.color = color;
        this.type = type;
    }

    public static Piece createPiece(PieceUtils.Color color, PieceUtils.Type type) {
        if (color.equals(PieceUtils.Color.WHITE)) {
            return createWhite(type);
        } else if (color.equals(PieceUtils.Color.BLACK)) {
            return createBlack(type);
        }
        return createBlank();
    }

    private static Piece createWhite(PieceUtils.Type type) {
        return new Piece(PieceUtils.Color.WHITE, type);
    }

    private static Piece createBlack(PieceUtils.Type type) {
        return new Piece(PieceUtils.Color.BLACK, type);
    }

    public static Piece createBlank() {
        return new Piece(PieceUtils.Color.NOCOLOR, PieceUtils.Type.NO_PIECE);
    }

    public PieceUtils.Color getColor() {
        return this.color;
    }

    public char getRepresentation() {
        if (this.color.equals(PieceUtils.Color.WHITE)) {
            return this.type.getWhiteRepresentation();
        }
        return Character.toUpperCase(this.type.getBlackRepresentation());
    }

    public PieceUtils.Type getType() {
        return this.type;
    }

    public boolean isWhite() {
        return this.color.equals(PieceUtils.Color.WHITE);
    }

    public boolean isBlack() {
        return this.color.equals(PieceUtils.Color.BLACK);
    }

    public boolean isBlank() {
        return this.color.equals(PieceUtils.Color.NOCOLOR) || this.type.equals(PieceUtils.Type.NO_PIECE);
    }
}
