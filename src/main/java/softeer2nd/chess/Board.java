package softeer2nd.chess;

import softeer2nd.chess.util.PieceUtils;
import softeer2nd.chess.util.StringUtils;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Board {

    private final Piece[][] board = new Piece[8][8];

    public void initialize() {
        initializeByColor(PieceUtils.Color.WHITE);
        initializeByColor(PieceUtils.Color.BLACK);
    }

    private void initializeByColor(PieceUtils.Color color) {
        int pawnRow = color.equals(PieceUtils.Color.BLACK) ? 1 : 6;
        int otherRow = color.equals(PieceUtils.Color.BLACK) ? 0 : 7;

        for (int i = 0; i < 8; i++) {
            board[pawnRow][i] = Piece.createPiece(color, PieceUtils.Type.PAWN);
        }

        board[otherRow][0] = Piece.createPiece(color, PieceUtils.Type.ROOK);
        board[otherRow][7] = Piece.createPiece(color, PieceUtils.Type.ROOK);

        board[otherRow][1] = Piece.createPiece(color, PieceUtils.Type.KNIGHT);
        board[otherRow][6] = Piece.createPiece(color, PieceUtils.Type.KNIGHT);

        board[otherRow][2] = Piece.createPiece(color, PieceUtils.Type.BISHOP);
        board[otherRow][5] = Piece.createPiece(color, PieceUtils.Type.BISHOP);

        board[otherRow][3] = Piece.createPiece(color, PieceUtils.Type.QUEEN);

        board[otherRow][4] = Piece.createPiece(color, PieceUtils.Type.KING);
    }

    public String getWhitePawnsResult() {
        return getRepresentationResult(board[6]);
    }

    public String getBlackPawnsResult() {
        return getRepresentationResult(board[1]);
    }

    private String getRepresentationResult(Piece[] row) {
        return Arrays.stream(row)
                .map(Piece::getRepresentation)
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    public void print() {
        System.out.print(showBoard());
    }

    public int pieceCount() {
        int count = 0;
        for (Piece[] row : board) {
            for (Piece piece : row) {
                if (piece == null) continue;
                count++;
            }
        }
        return count;
    }

    public String showBoard() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == null) {
                    builder.append('.');
                } else {
                    builder.append(board[i][j].getRepresentation());
                }
            }
            builder.append(StringUtils.NEWLINE);
        }
        return builder.toString();
    }
}
