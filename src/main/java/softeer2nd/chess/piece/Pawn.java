package softeer2nd.chess.piece;

import softeer2nd.chess.Position;
import softeer2nd.chess.util.PieceUtils.Color;
import softeer2nd.chess.util.PieceUtils.Type;

public class Pawn extends Piece {

    private Pawn(Color color, Type type) {
        super(color, type);
    }


    public static Pawn createWhitePawn() {
        return new Pawn(Color.WHITE, Type.PAWN);
    }

    public static Pawn createBlackPawn() {
        return new Pawn(Color.BLACK, Type.PAWN);
    }

    public void verifyMovePosition(Position source, Position destination) {
        int yDist = destination.getY() - source.getY();
        int xDist = destination.getX() - source.getX();
        if(this.color.equals(Color.WHITE)) {
            verifyWhiteMovePosition(yDist, xDist);
        } else {
            verifyBlackMovePosition(yDist, xDist);
        }
    }

    private void verifyWhiteMovePosition(int yDist, int xDist) {
        if(yDist != 1 || Math.abs(xDist) > 1) {
            throw new IllegalArgumentException("적절하지 않은 이동입니다.");
        }
    }

    private void verifyBlackMovePosition(int yDist, int xDist) {
        if(yDist != -1 || Math.abs(xDist) > 1) {
            throw new IllegalArgumentException("적절하지 않은 이동입니다.");
        }
    }
}
