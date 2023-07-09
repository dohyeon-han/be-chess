package softeer2nd.chess;

import softeer2nd.chess.piece.Blank;
import softeer2nd.chess.piece.Piece;
import softeer2nd.chess.util.Direction;
import softeer2nd.chess.util.PieceUtils;

public class Game {

    private final Board board;
    private final Turn turn;

    public Game(Board board) {
        this.board = board;
        this.turn = new Turn();
    }

    public void initializeBoard() {
        board.initialize();
    }

    public void move(String pos, Piece piece) {
        this.board.replace(pos, piece);
    }

    public void move(String source, String target) {
        Position start = new Position(source);
        Position end = new Position(target);
        Piece sourcePiece = this.board.findPiece(start.getY(), start.getX());
        Piece targetPiece = this.board.findPiece(end.getY(), end.getX());

        if (sourcePiece.isBlank()) {
            throw new IllegalArgumentException("이동할 수 있는 말이 없습니다.");
        }

        if (!targetPiece.isBlank() && sourcePiece.getColor().equals(targetPiece.getColor())) {
            throw new IllegalArgumentException("같은 색의 기물을 잡을 수 없습니다.");
        }

        sourcePiece.verifyMovePosition(start, end);
        Direction requestDirection = Direction.getDirection(start, end);

        while (!start.equals(end)) {
            start.add(requestDirection.getXDegree(), requestDirection.getYDegree());

            // 경로 가운데에 다른 기물이 존재
            if (!start.equals(end) && !this.board.findPiece(start.getY(), start.getX()).isBlank()) {
                throw new IllegalArgumentException("해당 위치로 이동할 수 없습니다.");
            }
        }

        if (sourcePiece.getType().equals(PieceUtils.Type.PAWN)) {
            boolean isDiagonal = Direction.diagonalDirection().stream().anyMatch(direction -> direction.equals(requestDirection));
            // 폰은 빈 곳으로 대각선 이동할 수 없다.
            if (targetPiece.isBlank() && isDiagonal) {
                throw new IllegalArgumentException("해당 위치로 이동할 수 없습니다.");
            }
            // 폰은 기물이 있는 곳으로 직선 이동할 수 없다.
            if (!targetPiece.isBlank() && !isDiagonal) {
                throw new IllegalArgumentException("해당 위치로 이동할 수 없습니다.");
            }
        }

        this.board.replace(source, Blank.createBlank());
        this.board.replace(target, sourcePiece);
    }

    private static class Turn {
        boolean isWhite = true;

        public boolean isWhiteTurn() {
            return isWhite;
        }

        public boolean isBlackTurn() {
            return !isWhite;
        }

        public void change() {
            isWhite = !isWhite;
        }
    }

    public void checkTurn(String pos) {
        Piece piece = board.findPiece(pos);
        if((piece.isWhite() && turn.isWhiteTurn()) || (piece.isBlack() && turn.isBlackTurn())) {
            turn.change();
            return;
        }
        throw new IllegalArgumentException((turn.isBlackTurn() ? "흰" : "검정") + " 기물을 움직일 차례입니다.");
    }
}
