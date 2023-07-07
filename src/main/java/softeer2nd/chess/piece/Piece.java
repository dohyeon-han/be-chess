package softeer2nd.chess.piece;

import softeer2nd.chess.util.PieceUtils.Color;
import softeer2nd.chess.util.PieceUtils.Type;

public abstract class Piece {

    protected final Color color;
    protected final Type type;

    protected Piece(Color color, Type type) {
        this.color = color;
        this.type = type;
    }

    public static Piece createPiece(Color color, Type type) {
        if (color.equals(Color.NOCOLOR)) {
            return Blank.createBlank();
        }
        boolean isWhite = color.equals(Color.WHITE);
        switch (type) {
            case PAWN:
                return isWhite ? Pawn.createWhitePawn() : Pawn.createBlackPawn();
            case ROOK:
                return isWhite ? Rook.createWhiteRook() : Rook.createBlackRook();
            case KNIGHT:
                return isWhite ? Knight.createWhiteKnight() : Knight.createBlackKnight();
            case BISHOP:
                return isWhite ? Bishop.createWhiteBishop() : Bishop.createBlackBishop();
            case KING:
                return isWhite ? King.createWhiteKing() : King.createBlackKing();
            case QUEEN:
                return isWhite ? Queen.createWhiteQueen() : Queen.createBlackQueen();
            default:
                return Blank.createBlank();
        }
    }

    public Color getColor() {
        return this.color;
    }

    public char getRepresentation() {
        if (this.color.equals(Color.WHITE)) {
            return this.type.getWhiteRepresentation();
        }
        return Character.toUpperCase(this.type.getBlackRepresentation());
    }

    public Type getType() {
        return this.type;
    }

    public boolean isWhite() {
        return this.color.equals(Color.WHITE);
    }

    public boolean isBlack() {
        return this.color.equals(Color.BLACK);
    }

    public boolean isBlank() {
        return this.color.equals(Color.NOCOLOR) || this.type.equals(Type.NO_PIECE);
    }
}
