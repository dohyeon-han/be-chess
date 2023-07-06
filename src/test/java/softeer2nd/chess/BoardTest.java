package softeer2nd.chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.util.PieceUtils;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
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
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        board.print();
        assertThat(outputStreamCaptor.toString()).isEqualTo(getInitStatusString());

        System.setOut(new PrintStream(System.out));
    }

    @Test
    @DisplayName("체스판의 전체 상태를 확인한다.")
    public void create() {
        assertThat(32).isEqualTo(board.pieceCount());
        assertThat(getInitStatusString())
                .isEqualTo(board.showBoard());
    }

    @Test
    @DisplayName("초기화한 체스판에서 흰 기물의 각 개수를 확인한다.")
    public void countWhitePiece() {
        //when
        List<Long> counts = getCountList(PieceUtils.Color.WHITE);

        //then
        verifyPiecesCount(counts);
    }

    @Test
    @DisplayName("초기화한 체스판에서 검정 기물의 각 개수를 확인한다.")
    public void countBlackPiece() {
        //when
        List<Long> counts = getCountList(PieceUtils.Color.BLACK);

        //then
        verifyPiecesCount(counts);
    }


    private String getInitStatusString() {
        String blankRank = appendNewLine("........");
        return appendNewLine("RNBQKBNR") +
                appendNewLine("PPPPPPPP") +
                blankRank + blankRank + blankRank + blankRank +
                appendNewLine("pppppppp") +
                appendNewLine("rnbqkbnr");
    }

    private List<Long> getCountList(PieceUtils.Color color) {
        List<Long> counts = new ArrayList<>();
        counts.add(board.countPiece(color, PieceUtils.Type.PAWN));
        counts.add(board.countPiece(color, PieceUtils.Type.ROOK));
        counts.add(board.countPiece(color, PieceUtils.Type.KNIGHT));
        counts.add(board.countPiece(color, PieceUtils.Type.BISHOP));
        counts.add(board.countPiece(color, PieceUtils.Type.KING));
        counts.add(board.countPiece(color, PieceUtils.Type.QUEEN));

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