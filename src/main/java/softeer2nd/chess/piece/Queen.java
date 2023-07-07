package softeer2nd.chess.piece;

import softeer2nd.chess.util.PieceUtils.*;

public class Queen extends Piece {

    private Queen(Color color, Type type) {
        super(color, type);
    }


    public static Queen createWhiteQueen() {
        return new Queen(Color.WHITE, Type.QUEEN);
    }

    public static Queen createBlackQueen() {
        return new Queen(Color.BLACK, Type.QUEEN);
    }
}
