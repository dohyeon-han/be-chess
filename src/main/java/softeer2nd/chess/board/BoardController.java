package softeer2nd.chess.board;

import softeer2nd.chess.piece.Piece;
import softeer2nd.chess.util.PieceUtils;
import softeer2nd.chess.util.StringUtils;

import java.util.List;

public class BoardController {

    private final Board board;
    private final BoardService boardService;

    public BoardController(Board board, BoardService boardService) {
        this.board = board;
        this.boardService = boardService;
    }

    public void print() {
        System.out.print(showBoard());
    }

    public String showBoard() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
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
        List<Integer> validPositions = boardService.getValidPositions(pos);
        this.board.getBoard().get(validPositions.get(1))
                .replace(validPositions.get(0), piece);
    }

    public void move(String source, String target) {
        List<Integer> sourcePosition = boardService.getValidPositions(source);
        List<Integer> targetPosition = boardService.getValidPositions(target);

        Piece sourcePiece = this.board.getBoard().get(sourcePosition.get(1)).getPiece(sourcePosition.get(0));
        Piece targetPiece = this.board.getBoard().get(targetPosition.get(1)).getPiece(targetPosition.get(0));

        if (sourcePiece.isBlank()) {
            throw new IllegalArgumentException("이동할 수 있는 말이 없습니다.");
        }

        this.board.getBoard().get(sourcePosition.get(1)).replace(sourcePosition.get(0), targetPiece);
        this.board.getBoard().get(targetPosition.get(1)).replace(targetPosition.get(0), sourcePiece);
    }
}
