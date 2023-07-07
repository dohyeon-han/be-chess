package softeer2nd.chess;

import softeer2nd.chess.util.PieceUtils;
import softeer2nd.chess.util.StringUtils;

import static softeer2nd.chess.Board.BOARD_LENGTH;

public class View {

    private final Board board;

    public View(Board board) {
        this.board = board;
    }

    public void print() {
        System.out.print(showBoard());
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
}
