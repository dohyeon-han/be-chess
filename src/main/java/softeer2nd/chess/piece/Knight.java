package softeer2nd.chess.piece;

import softeer2nd.chess.util.PieceUtils.*;

public class Knight extends Piece {

    private Knight(Color color, Type type) {
        super(color, type);
    }

    public static Knight createWhiteKnight() {
        return new Knight(Color.WHITE, Type.KNIGHT);
    }

    public static Knight createBlackKnight() {
        return new Knight(Color.BLACK, Type.KNIGHT);
    }
}
