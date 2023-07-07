package softeer2nd.chess.piece;

import softeer2nd.chess.util.PieceUtils.Color;
import softeer2nd.chess.util.PieceUtils.Type;

public class Pawn extends Piece {

    private Pawn(Color color, Type type) {
        super(color, type);
    }


    public static Pawn createWhitePawn() {
        return new Pawn(Color.WHITE, Type.PAWN);
    }

    public static Pawn createBlackPawn() {
        return new Pawn(Color.BLACK, Type.PAWN);
    }
}
