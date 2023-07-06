package softeer2nd.chess;

import softeer2nd.chess.util.PieceUtils;
import softeer2nd.chess.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Board {

    public static final int BOARD_LENGTH = 8;
    private final List<Rank> board = new ArrayList<>(BOARD_LENGTH);

    public void initialize() {
        for (int i = 0; i < BOARD_LENGTH; i++) {
            board.add(new Rank());
        }
        initializeByColor(PieceUtils.Color.WHITE);
        initializeByColor(PieceUtils.Color.BLACK);
        for (int i = 2; i < 6; i++) {
            board.get(i).initialize(PieceUtils.Color.NOCOLOR, PieceUtils.Type.NO_PIECE);
        }
    }

    public void initializeEmpty() {
        for (int i = 0; i < BOARD_LENGTH; i++) {
            board.add(new Rank());
        }
        for (int i = 0; i < 8; i++) {
            board.get(i).initialize(PieceUtils.Color.NOCOLOR, PieceUtils.Type.NO_PIECE);
        }
    }

    private void initializeByColor(PieceUtils.Color color) {
        int pawnRow = color.equals(PieceUtils.Color.BLACK) ? 1 : 6;
        int otherRow = color.equals(PieceUtils.Color.BLACK) ? 0 : 7;

        board.get(pawnRow).initialize(color, PieceUtils.Type.PAWN);
        board.get(otherRow).initializeOthers(color);
    }

    public String getWhitePawnsResult() {
        return getRepresentationResult(board.get(6));
    }

    public String getBlackPawnsResult() {
        return getRepresentationResult(board.get(1));
    }

    private String getRepresentationResult(Rank rank) {
        return rank.getRank().stream().map(Piece::getRepresentation)
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    public Piece findPiece(String pos) {
        List<Integer> validPositions = getValidPositions(pos);
        return this.board.get(validPositions.get(1))
                .getPiece(validPositions.get(0));
    }

    public void print() {
        System.out.print(showBoard());
    }

    public long pieceCount() {
        return this.board.stream()
                .map(Rank::getRank)
                .flatMap(List::stream)
                .filter(piece -> !piece.getType().equals(PieceUtils.Type.NO_PIECE))
                .count();

    }

    public String showBoard() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board.get(i).getPiece(j).getType().equals(PieceUtils.Type.NO_PIECE)) {
                    builder.append('.');
                } else {
                    builder.append(board.get(i).getPiece(j).getRepresentation());
                }
            }
            builder.append(StringUtils.NEWLINE);
        }
        return builder.toString();
    }

    public long countPiece(PieceUtils.Color color, PieceUtils.Type type) {
        return board.stream()
                .map(Rank::getRank)
                .flatMap(List::stream)
                .filter(piece -> piece.getColor().equals(color) && piece.getType().equals(type))
                .count();
    }

    public void move(String pos, Piece piece) {
        List<Integer> validPositions = getValidPositions(pos);
        this.board.get(validPositions.get(1))
                .replace(validPositions.get(0), piece);
    }

    private List<Integer> getValidPositions(String pos) {
        if (pos.length() != 2) {
            throw new IllegalArgumentException("위치값의 길이는 2입니다.");
        }
        char column = pos.charAt(0);
        char row = pos.charAt(1);

        if (column < 'a' || column > 'h') {
            throw new IllegalArgumentException("열 값은 a~h입니다.");
        }
        if (row < '1' || row > '8') {
            throw new IllegalArgumentException("열 값은 1~8입니다.");
        }
        return new ArrayList<>(Arrays.asList(column - 'a', 7 - (row - '1')));
    }
}
