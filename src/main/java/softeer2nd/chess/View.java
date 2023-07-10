package softeer2nd.chess;

import softeer2nd.chess.piece.Piece;
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
                Piece piece = this.board.findPiece(i, j);
                builder.append(piece.getRepresentation());
            }
            builder.append("  ").append(StringUtils.appendNewLine(String.valueOf(BOARD_LENGTH - i)));
        }
        builder.append(StringUtils.NEWLINE).append(StringUtils.appendNewLine("abcdefgh"));
        return builder.toString();
    }
}
