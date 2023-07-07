package softeer2nd.chess.piece;

import softeer2nd.chess.Position;
import softeer2nd.chess.util.Direction;
import softeer2nd.chess.util.PieceUtils.Color;
import softeer2nd.chess.util.PieceUtils.Type;

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

    public void verifyMovePosition(Position source, Position destination) {
        int yDist = destination.getY() - source.getY();
        int xDist = destination.getX() - source.getX();
        for (Direction direction : Direction.knightDirection()) {
            if (yDist == direction.getYDegree() && xDist == direction.getXDegree()) {
                return;
            }
        }
        throw new IllegalArgumentException("적절하지 않은 이동입니다.");
    }
}
