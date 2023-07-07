package softeer2nd.chess.piece;

import softeer2nd.chess.Position;
import softeer2nd.chess.util.PieceUtils.Color;
import softeer2nd.chess.util.PieceUtils.Type;

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

    public void verifyMovePosition(Position source, Position destination) {
        int yDist = destination.getY() - source.getY();
        int xDist = destination.getX() - source.getX();
        if ((Math.abs(yDist) == Math.abs(xDist) && yDist != 0) || (yDist == 0 || xDist == 0)) {
            return;
        }
        throw new IllegalArgumentException("적절하지 않은 이동입니다.");
    }
}
