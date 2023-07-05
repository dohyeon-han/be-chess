package softeer2nd.chess;

import softeer2nd.chess.util.PieceUtils;
import softeer2nd.chess.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Board {

    public final int BOARD_LENGTH = 8;
    private final List<List<Piece>> board = new ArrayList<>(BOARD_LENGTH);

    public void initialize() {
        for (int i = 0; i < BOARD_LENGTH; i++) {
            List<Piece> row = new ArrayList<>(BOARD_LENGTH);
            board.add(row);
        }
        initializeByColor(PieceUtils.Color.WHITE);
        initializeByColor(PieceUtils.Color.BLACK);
        initializeBlank();
    }


    private void initializeByColor(PieceUtils.Color color) {
        int pawnRow = color.equals(PieceUtils.Color.BLACK) ? 1 : 6;
        int otherRow = color.equals(PieceUtils.Color.BLACK) ? 0 : 7;

        for (int i = 0; i < 8; i++) {
            board.get(pawnRow).add(Piece.createPiece(color, PieceUtils.Type.PAWN));
        }

        board.get(otherRow).add(Piece.createPiece(color, PieceUtils.Type.ROOK));
        board.get(otherRow).add(Piece.createPiece(color, PieceUtils.Type.KNIGHT));
        board.get(otherRow).add(Piece.createPiece(color, PieceUtils.Type.BISHOP));
        board.get(otherRow).add(Piece.createPiece(color, PieceUtils.Type.QUEEN));
        board.get(otherRow).add(Piece.createPiece(color, PieceUtils.Type.KING));
        board.get(otherRow).add(Piece.createPiece(color, PieceUtils.Type.BISHOP));
        board.get(otherRow).add(Piece.createPiece(color, PieceUtils.Type.KNIGHT));
        board.get(otherRow).add(Piece.createPiece(color, PieceUtils.Type.ROOK));
    }

    private void initializeBlank() {
        for (int i = 2; i < 6; i++) {
            for (int j = 0; j < BOARD_LENGTH; j++) {
                board.get(i).add(Piece.createBlank());
            }
        }
    }

    public String getWhitePawnsResult() {
        return getRepresentationResult(board.get(6));
    }

    public String getBlackPawnsResult() {
        return getRepresentationResult(board.get(1));
    }

    private String getRepresentationResult(List<Piece> row) {
        return row.stream().map(Piece::getRepresentation)
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    public void print() {
        System.out.print(showBoard());
    }

    public long pieceCount() {
        return this.board.stream()
                .flatMap(List::stream)
                .filter(piece -> !piece.getType().equals(PieceUtils.Type.NO_PIECE))
                .count();

    }

    public String showBoard() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board.get(i).get(j).getType().equals(PieceUtils.Type.NO_PIECE)) {
                    builder.append('.');
                } else {
                    builder.append(board.get(i).get(j).getRepresentation());
                }
            }
            builder.append(StringUtils.NEWLINE);
        }
        return builder.toString();
    }
}
