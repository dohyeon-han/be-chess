package softeer2nd.chess;

import softeer2nd.chess.piece.Piece;
import softeer2nd.chess.util.PieceUtils;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Board {
    public static final int BOARD_LENGTH = 8;
    private final List<Rank> board = new ArrayList<>(BOARD_LENGTH);

    public void initialize() {
        board.clear();
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
        board.clear();
        for (int i = 0; i < BOARD_LENGTH; i++) {
            board.add(new Rank());
        }
        for (int i = 0; i < BOARD_LENGTH; i++) {
            board.get(i).initialize(PieceUtils.Color.NOCOLOR, PieceUtils.Type.NO_PIECE);
        }
    }

    private void initializeByColor(PieceUtils.Color color) {
        int pawnRow = color.equals(PieceUtils.Color.BLACK) ? 1 : 6;
        int otherRow = color.equals(PieceUtils.Color.BLACK) ? 0 : 7;

        board.get(pawnRow).initialize(color, PieceUtils.Type.PAWN);
        board.get(otherRow).initializeOthers(color);
    }

    public List<Rank> getBoard() {
        return new ArrayList<>(this.board);
    }

    public long countPiece() {
        return getFlatMap()
                .filter(piece -> !piece.getType().equals(PieceUtils.Type.NO_PIECE))
                .count();
    }

    public long countPiece(PieceUtils.Color color, PieceUtils.Type type) {
        return getFlatMap()
                .filter(piece -> piece.getColor().equals(color) && piece.getType().equals(type))
                .count();
    }

    public String getWhitePawnsResult() {
        return getRepresentationResult(board.get(6));
    }

    public String getBlackPawnsResult() {
        return getRepresentationResult(board.get(1));
    }

    public Piece findPiece(String pos) {
        Position position = new Position(pos);
        return this.board.get(position.getY())
                .getPiece(position.getX());
    }

    public double calculatePoint(PieceUtils.Color color) {
        Map<PieceUtils.Type, Double> typeDoubleMap = calculatePiecePointsByColumn(color);
        return typeDoubleMap.values().stream()
                .mapToDouble(Double::doubleValue)
                .sum();
    }

    public List<Double> getPiecePointsDesc(PieceUtils.Color color) {
        Map<PieceUtils.Type, Double> pointMap = calculatePiecePointsByColumn(color);
        return pointMap.values().stream()
                .mapToDouble(Double::doubleValue).boxed()
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());
    }

    public List<Double> getPiecePointsAsc(PieceUtils.Color color) {
        return getPiecePointsDesc(color).stream().sorted().collect(Collectors.toList());
    }

    private Stream<Piece> getFlatMap() {
        return this.board.stream()
                .map(Rank::getRank)
                .flatMap(List::stream);
    }

    private String getRepresentationResult(Rank rank) {
        return rank.getRank().stream().map(Piece::getRepresentation)
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    // 같은 열의 같은 색 기물을 찾는다.
    private List<Piece> getColumnPieces(int column, PieceUtils.Color color) {
        return this.board.stream()
                .map(rank -> rank.getPiece(column))
                .filter(piece -> piece.getColor().equals(color) && !piece.getType().equals(PieceUtils.Type.NO_PIECE))
                .collect(Collectors.toList());
    }

    // 같은 색의 기물을 기물 별로 map에 점수로 저장한다.
    private Map<PieceUtils.Type, Double> calculatePiecePointsByColumn(PieceUtils.Color color) {
        Map<PieceUtils.Type, Double> points = new HashMap<>();

        // 열 별로 기물 점수 계산
        for (int i = 0; i < BOARD_LENGTH; i++) {
            List<Piece> pieces = getColumnPieces(i, color);
            long countPawn = pieces.stream().filter(piece -> piece.getType().equals(PieceUtils.Type.PAWN)).count();

            // 해당 열에 pawn이 2개 이상 있으면, pawn을 더할 때 반으로 값을 더한다.
            pieces.forEach(piece -> {
                double value = piece.getType().getDefaultPoint();
                if (countPawn > 1 && piece.getType().equals(PieceUtils.Type.PAWN)) {
                    value /= 2;
                }
                points.merge(piece.getType(), value, Double::sum);
            });
        }
        return points;
    }
}
