package softeer2nd.chess.piece;

import softeer2nd.chess.Position;
import softeer2nd.chess.util.PieceUtils.Color;
import softeer2nd.chess.util.PieceUtils.Type;

import static softeer2nd.chess.Board.BOARD_LENGTH;

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
        if (this.color.equals(Color.WHITE)) {
            verifyWhiteMovePosition(source, destination);
        } else {
            verifyBlackMovePosition(source, destination);
        }
    }

    private void verifyWhiteMovePosition(Position source, Position destination) {
        int yDist = destination.getY() - source.getY();
        int xDist = destination.getX() - source.getX();
        System.out.println(source.getY());
        System.out.println(yDist);
        System.out.println(xDist);
        if (source.getY() == 1 && yDist == 2 && xDist == 0) {
            return;
        }
        if (yDist != 1 || Math.abs(xDist) > 1) {
            throw new IllegalArgumentException("적절하지 않은 이동입니다.");
        }
    }

    private void verifyBlackMovePosition(Position source, Position destination) {
        int yDist = destination.getY() - source.getY();
        int xDist = destination.getX() - source.getX();
        System.out.println(source.getY());
        System.out.println(yDist);
        System.out.println(xDist);
        if (source.getY() == BOARD_LENGTH - 2 && yDist == -2 && xDist == 0) {
            return;
        }
        if (yDist != -1 || Math.abs(xDist) > 1) {
            throw new IllegalArgumentException("적절하지 않은 이동입니다.");
        }
    }
}
