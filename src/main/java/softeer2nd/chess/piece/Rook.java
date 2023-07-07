package softeer2nd.chess.piece;

import softeer2nd.chess.Position;
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

    public void verifyMovePosition(Position source, Position destination) {
        int yDist = destination.getY() - source.getY();
        int xDist = destination.getX() - source.getX();
        if ((yDist == 0 || xDist == 0) && xDist != yDist) {
            return;
        }
        throw new IllegalArgumentException("적절하지 않은 이동입니다.");
    }
}
