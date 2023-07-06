package softeer2nd.chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.util.PieceUtils.Color;
import softeer2nd.chess.util.PieceUtils.Type;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static softeer2nd.chess.util.StringUtils.appendNewLine;

public class BoardTest {
    Board board;

    @BeforeEach
    public void setUp() {
        board = new Board();
        board.initialize();
    }

    @Test
    @DisplayName("폰을 출력한다.")
    public void initialize() {
        assertThat(board.getWhitePawnsResult()).isEqualTo("pppppppp");
        assertThat(board.getBlackPawnsResult()).isEqualTo("PPPPPPPP");
    }

    @Test
    @DisplayName("초기화한 체스판을 출력한다.")
    public void printInitialize() {
        // 이전의 System.out 저장
        PrintStream originalOut = System.out;

        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        board.print();
        assertThat(outputStreamCaptor.toString()).isEqualTo(getInitStatusString());

        // System.out을 이전의 PrintStream으로 복원
        System.setOut(originalOut);
    }

    @Test
    @DisplayName("체스판의 전체 상태를 확인한다.")
    public void create() {
        assertThat(32).isEqualTo(board.countPiece());
        assertThat(getInitStatusString())
                .isEqualTo(board.showBoard());
    }

    @Test
    @DisplayName("초기화한 체스판에서 흰 기물의 각 개수를 확인한다.")
    public void countWhitePiece() {
        //when
        List<Long> counts = getCountList(Color.WHITE);

        //then
        verifyPiecesCount(counts);
    }

    @Test
    @DisplayName("초기화한 체스판에서 검정 기물의 각 개수를 확인한다.")
    public void countBlackPiece() {
        //when
        List<Long> counts = getCountList(Color.BLACK);

        //then
        verifyPiecesCount(counts);
    }

    @Test
    @DisplayName("모든 룩의 위치를 확인한다.")
    public void findRook() {
        board.initialize();

        assertThat(Piece.createPiece(Color.BLACK, Type.ROOK)).isEqualToComparingFieldByFieldRecursively(board.findPiece("a8"));
        assertThat(Piece.createPiece(Color.BLACK, Type.ROOK)).isEqualToComparingFieldByFieldRecursively(board.findPiece("h8"));
        assertThat(Piece.createPiece(Color.WHITE, Type.ROOK)).isEqualToComparingFieldByFieldRecursively(board.findPiece("a1"));
        assertThat(Piece.createPiece(Color.WHITE, Type.ROOK)).isEqualToComparingFieldByFieldRecursively(board.findPiece("h1"));
    }

    @Test
    @DisplayName("기물을 찾는 인자의 길이가 3이 아니면 예외가 발생한다.")
    public void findPieceLengthException() {
        //given
        String shortPos = "a";
        String longPos = "b23";

        //when
        //then
        assertThrows(IllegalArgumentException.class, () -> board.findPiece(shortPos));
        assertThrows(IllegalArgumentException.class, () -> board.findPiece(longPos));
    }

    @Test
    @DisplayName("기물을 찾는 행 1~8이 아니면 예외가 발생한다.")
    public void findPieceRowException() {
        //given
        String pos = "a9";

        //when
        //then
        assertThrows(IllegalArgumentException.class, () -> board.findPiece(pos));
    }

    @Test
    @DisplayName("기물을 찾는 행 a~h가 아니면 예외가 발생한다.")
    public void findPieceColumnException() {
        //given
        String pos = "i2";

        //when
        //then
        assertThrows(IllegalArgumentException.class, () -> board.findPiece(pos));
    }

    @Test
    @DisplayName("빈 체스판에 검정룩을 b5에 놓는다.")
    public void move() {
        //given
        board.initializeEmpty();

        String position = "b5";
        Piece piece = Piece.createPiece(Color.BLACK, Type.ROOK);

        //when
        board.move(position, piece);

        //then
        assertThat(piece).isEqualToComparingFieldByFieldRecursively(board.findPiece(position));
        System.out.println(board.showBoard());
    }

    @Test
    @DisplayName("색깔 별로 기물 점수의 합을 구한다.")
    public void calculatePoint() throws Exception {
        //given
        addPieces();

        //then
        assertEquals(15.0, board.calculatePoint(Color.BLACK), 0.01);
        assertEquals(7.5, board.calculatePoint(Color.WHITE), 0.01);

        System.out.println(board.showBoard());
    }

    @Test
    @DisplayName("기물 점수의 합을 오름차순 정렬한다.")
    public void sumPiecesAsc() {
        //given
        addPieces();

        //when
        List<Double> whitePoints = board.getPiecePointsAsc(Color.WHITE);
        List<Double> blackPoints = board.getPiecePointsAsc(Color.BLACK);

        //then
        List<Double> expectedWhitePoints = Arrays.asList(0.0, 2.5, 5.0);
        List<Double> expectedBlackPoints = Arrays.asList(0.0, 1.0, 5.0, 9.0);
        assertThat(whitePoints).usingRecursiveFieldByFieldElementComparator().isEqualTo(expectedWhitePoints);
        assertThat(blackPoints).usingRecursiveFieldByFieldElementComparator().isEqualTo(expectedBlackPoints);
    }

    @Test
    @DisplayName("기물 점수의 합을 내림차순 정렬한다.")
    public void sumPiecesDesc() {
        //given
        addPieces();

        //when
        List<Double> whitePoints = board.getPiecePointsDesc(Color.WHITE);
        List<Double> blackPoints = board.getPiecePointsDesc(Color.BLACK);

        //then
        List<Double> expectedWhitePoints = Arrays.asList(5.0, 2.5, 0.0);
        List<Double> expectedBlackPoints = Arrays.asList(9.0, 5.0, 1.0, 0.0);
        assertThat(whitePoints).usingRecursiveFieldByFieldElementComparator().isEqualTo(expectedWhitePoints);
        assertThat(blackPoints).usingRecursiveFieldByFieldElementComparator().isEqualTo(expectedBlackPoints);
    }

    private void addPiece(String position, Piece piece) {
        board.move(position, piece);
    }

    private String getInitStatusString() {
        String blankRank = appendNewLine("........");
        return appendNewLine("RNBQKBNR") +
                appendNewLine("PPPPPPPP") +
                blankRank + blankRank + blankRank + blankRank +
                appendNewLine("pppppppp") +
                appendNewLine("rnbqkbnr");
    }

    private void addPieces() {
        board.initializeEmpty();

        addPiece("b6", Piece.createPiece(Color.BLACK, Type.PAWN));
        addPiece("e6", Piece.createPiece(Color.BLACK, Type.QUEEN));
        addPiece("b8", Piece.createPiece(Color.BLACK, Type.KING));
        addPiece("c8", Piece.createPiece(Color.BLACK, Type.ROOK));

        addPiece("g4", Piece.createPiece(Color.WHITE, Type.PAWN));
        addPiece("g3", Piece.createPiece(Color.WHITE, Type.PAWN));
        addPiece("g2", Piece.createPiece(Color.WHITE, Type.PAWN));
        addPiece("f3", Piece.createPiece(Color.WHITE, Type.PAWN));
        addPiece("f2", Piece.createPiece(Color.WHITE, Type.PAWN));
        addPiece("e1", Piece.createPiece(Color.WHITE, Type.ROOK));
        addPiece("f1", Piece.createPiece(Color.WHITE, Type.KING));

    }

    private List<Long> getCountList(Color color) {
        List<Long> counts = new ArrayList<>();
        counts.add(board.countPiece(color, Type.PAWN));
        counts.add(board.countPiece(color, Type.ROOK));
        counts.add(board.countPiece(color, Type.KNIGHT));
        counts.add(board.countPiece(color, Type.BISHOP));
        counts.add(board.countPiece(color, Type.KING));
        counts.add(board.countPiece(color, Type.QUEEN));

        return counts;
    }

    private void verifyPiecesCount(List<Long> counts) {
        final int LENGTH = 6;
        List<Long> expectedCounts = new ArrayList<>(Arrays.asList(8L, 2L, 2L, 2L, 1L, 1L));
        assertThat(counts).hasSize(LENGTH);
        for (int i = 0; i < LENGTH; i++) {
            assertThat(counts.get(i)).isEqualTo(expectedCounts.get(i));
        }
    }
}