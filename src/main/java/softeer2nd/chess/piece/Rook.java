package softeer2nd.chess.piece;

import softeer2nd.chess.util.PieceUtils.*;

public class Rook extends Piece {

    private Rook(Color color, Type type) {
        super(color, type);
    }

    public static Rook createWhiteRook() {
        return new Rook(Color.WHITE, Type.ROOK);
    }

    public static Rook createBlackRook() {
        return new Rook(Color.BLACK, Type.ROOK);
    }
}
