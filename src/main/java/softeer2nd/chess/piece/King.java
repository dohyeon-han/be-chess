package softeer2nd.chess.piece;

import softeer2nd.chess.Position;
import softeer2nd.chess.util.Direction;
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

    public void verifyMovePosition(Position source, Position destination) {
        int yDist = destination.getY() - source.getY();
        int xDist = destination.getX() - source.getX();
        boolean isValidMove = false;
        for (Direction direction : Direction.everyDirection()) {
            if (xDist == direction.getXDegree() && yDist == direction.getYDegree()) {
                isValidMove = true;
                break;
            }
        }
        if(!isValidMove) {
            throw new IllegalArgumentException("적절하지 않은 이동입니다.");
        }
    }
}
