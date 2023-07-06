package softeer2nd.chess;

import softeer2nd.chess.piece.Piece;
import softeer2nd.chess.util.PieceUtils;
import softeer2nd.chess.util.StringUtils;

import static softeer2nd.chess.Board.BOARD_LENGTH;

public class Game {

    private final Board board;

    public Game(Board board) {
        this.board = board;
    }

    public void print() {
        System.out.print(showBoard());
    }

    public void initializeBoard() {
        board.initialize();
    }

    public String showBoard() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < BOARD_LENGTH; i++) {
            for (int j = 0; j < BOARD_LENGTH; j++) {
                if (board.getBoard().get(i).getPiece(j).getType().equals(PieceUtils.Type.NO_PIECE)) {
                    builder.append('.');
                } else {
                    builder.append(board.getBoard().get(i).getPiece(j).getRepresentation());
                }
            }
            builder.append(StringUtils.NEWLINE);
        }
        return builder.toString();
    }

    public void move(String pos, Piece piece) {
        Position position = new Position(pos);
        this.board.getBoard().get(position.getY())
                .replace(position.getX(), piece);
    }

    public void move(String source, String target) {
        Position sourcePosition = new Position(source);
        Position targetPosition = new Position(target);

        Piece sourcePiece = this.board.getBoard().get(sourcePosition.getY()).getPiece(sourcePosition.getX());
        Piece targetPiece = this.board.getBoard().get(targetPosition.getY()).getPiece(targetPosition.getX());

        if (sourcePiece.isBlank()) {
            throw new IllegalArgumentException("이동할 수 있는 말이 없습니다.");
        }

        this.board.getBoard().get(sourcePosition.getY()).replace(sourcePosition.getX(), targetPiece);
        this.board.getBoard().get(targetPosition.getY()).replace(targetPosition.getX(), sourcePiece);
    }
}
