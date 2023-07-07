package softeer2nd.chess.piece;

import softeer2nd.chess.util.PieceUtils.*;

public class Bishop extends Piece {

    private Bishop(Color color, Type type) {
        super(color, type);
    }

    public static Bishop createWhiteBishop() {
        return new Bishop(Color.WHITE, Type.BISHOP);
    }

    public static Bishop createBlackBishop() {
        return new Bishop(Color.BLACK, Type.BISHOP);
    }
}
