package softeer2nd.chess;

import softeer2nd.chess.util.PieceUtils;

public class Piece {

    private final PieceUtils.Color color;
    private final PieceUtils.Type type;

    public Piece(PieceUtils.Color color, PieceUtils.Type type) {
        this.color = color;
        this.type = type;
    }

    public static Piece createPiece(PieceUtils.Color color, PieceUtils.Type type) {
        if(color.equals(PieceUtils.Color.WHITE)){
            if(type.equals(PieceUtils.Type.PAWN)){
                return createWhitePawn();
            } else if(type.equals(PieceUtils.Type.KNIGHT)){
                return createWhiteKnight();
            } else if(type.equals(PieceUtils.Type.ROOK)) {
                return createWhiteRook();
            } else if(type.equals(PieceUtils.Type.BISHOP)) {
                return createWhiteBishop();
            } else if(type.equals(PieceUtils.Type.KING)) {
                return createWhiteKing();
            } else if(type.equals(PieceUtils.Type.QUEEN)) {
                return createWhiteQueen();
            }
        } else {
            if(type.equals(PieceUtils.Type.PAWN)){
                return createBlackPawn();
            } else if(type.equals(PieceUtils.Type.KNIGHT)){
                return createBlackKnight();
            } else if(type.equals(PieceUtils.Type.ROOK)) {
                return createBlackRook();
            } else if(type.equals(PieceUtils.Type.BISHOP)) {
                return createBlackBishop();
            } else if(type.equals(PieceUtils.Type.KING)) {
                return createBlackKing();
            } else if(type.equals(PieceUtils.Type.QUEEN)) {
                return createBlackQueen();
            }
        }
        throw new IllegalArgumentException("적절하지 않은 인자입니다.");
    }

    public static Piece createWhitePawn() {
        return new Piece(PieceUtils.Color.WHITE, PieceUtils.Type.PAWN);
    }

    public static Piece createBlackPawn() {
        return new Piece(PieceUtils.Color.BLACK, PieceUtils.Type.PAWN);
    }

    public static Piece createWhiteKnight() {
        return new Piece(PieceUtils.Color.WHITE, PieceUtils.Type.KNIGHT);
    }

    public static Piece createBlackKnight() {
        return new Piece(PieceUtils.Color.BLACK, PieceUtils.Type.KNIGHT);
    }

    public static Piece createWhiteRook() {
        return new Piece(PieceUtils.Color.WHITE, PieceUtils.Type.ROOK);
    }

    public static Piece createBlackRook() {
        return new Piece(PieceUtils.Color.BLACK, PieceUtils.Type.ROOK);
    }

    public static Piece createWhiteBishop() {
        return new Piece(PieceUtils.Color.WHITE, PieceUtils.Type.BISHOP);
    }

    public static Piece createBlackBishop() {
        return new Piece(PieceUtils.Color.BLACK, PieceUtils.Type.BISHOP);
    }

    public static Piece createWhiteKing() {
        return new Piece(PieceUtils.Color.WHITE, PieceUtils.Type.KING);
    }

    public static Piece createBlackKing() {
        return new Piece(PieceUtils.Color.BLACK, PieceUtils.Type.KING);
    }

    public static Piece createWhiteQueen() {
        return new Piece(PieceUtils.Color.WHITE, PieceUtils.Type.QUEEN);
    }

    public static Piece createBlackQueen() {
        return new Piece(PieceUtils.Color.BLACK, PieceUtils.Type.QUEEN);
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

    public boolean isWhite() {
        return this.color.equals(PieceUtils.Color.WHITE);
    }

    public boolean isBlack() {
        return this.color.equals(PieceUtils.Color.BLACK);
    }
}
