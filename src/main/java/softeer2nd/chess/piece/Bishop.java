package softeer2nd.chess.piece;

import softeer2nd.chess.Position;
import softeer2nd.chess.util.PieceUtils.Color;
import softeer2nd.chess.util.PieceUtils.Type;

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

    public void verifyMovePosition(Position source, Position destination) {
        int yDist = destination.getY() - source.getY();
        int xDist = destination.getX() - source.getX();
        if(Math.abs(yDist) != Math.abs(xDist)) {
            throw new IllegalArgumentException("적절하지 않은 이동입니다.");
        }
    }
}
