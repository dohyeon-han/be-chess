package softeer2nd.chess.board;

import softeer2nd.chess.Rank;
import softeer2nd.chess.piece.Piece;
import softeer2nd.chess.util.PieceUtils;

import java.util.*;
import java.util.stream.Collectors;

import static softeer2nd.chess.board.Board.BOARD_LENGTH;

public class BoardService {

    private final Board board;

    public BoardService(Board board) {
        this.board = board;
    }

    public long countPiece() {
        return this.board.getBoard().stream()
                .map(Rank::getRank)
                .flatMap(List::stream)
                .filter(piece -> !piece.getType().equals(PieceUtils.Type.NO_PIECE))
                .count();

    }

    public long countPiece(PieceUtils.Color color, PieceUtils.Type type) {
        return board.getBoard().stream()
                .map(Rank::getRank)
                .flatMap(List::stream)
                .filter(piece -> piece.getColor().equals(color) && piece.getType().equals(type))
                .count();
    }

    public String getWhitePawnsResult() {
        return getRepresentationResult(board.getBoard().get(6));
    }

    public String getBlackPawnsResult() {
        return getRepresentationResult(board.getBoard().get(1));
    }

    public Piece findPiece(String pos) {
        List<Integer> validPositions = getValidPositions(pos);
        return this.board.getBoard().get(validPositions.get(1))
                .getPiece(validPositions.get(0));
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

    private String getRepresentationResult(Rank rank) {
        return rank.getRank().stream().map(Piece::getRepresentation)
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    // 같은 열의 같은 색 기물을 찾는다.
    private List<Piece> getColumnPieces(int column, PieceUtils.Color color) {
        return this.board.getBoard().stream()
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

    public List<Integer> getValidPositions(String pos) {
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
