package softeer2nd.chess.piece;

import softeer2nd.chess.util.PieceUtils.*;

public class King extends Piece {

    private King(Color color, Type type) {
        super(color, type);
    }


    public static King createWhiteKing() {
        return new King(Color.WHITE, Type.KING);
    }

    public static King createBlackKing() {
        return new King(Color.BLACK, Type.KING);
    }
}
