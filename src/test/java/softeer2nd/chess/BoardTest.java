package softeer2nd.chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.util.PieceUtils;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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
        long pawn = board.countPiece(PieceUtils.Color.WHITE, PieceUtils.Type.PAWN);
        long rook = board.countPiece(PieceUtils.Color.WHITE, PieceUtils.Type.ROOK);
        long knight = board.countPiece(PieceUtils.Color.WHITE, PieceUtils.Type.KNIGHT);
        long bishop = board.countPiece(PieceUtils.Color.WHITE, PieceUtils.Type.BISHOP);
        long king = board.countPiece(PieceUtils.Color.WHITE, PieceUtils.Type.KING);
        long queen = board.countPiece(PieceUtils.Color.WHITE, PieceUtils.Type.QUEEN);

        //then
        assertThat(pawn).isEqualTo(8);
        assertThat(rook).isEqualTo(2);
        assertThat(knight).isEqualTo(2);
        assertThat(bishop).isEqualTo(2);
        assertThat(king).isEqualTo(1);
        assertThat(queen).isEqualTo(1);
    }

    @Test
    @DisplayName("초기화한 체스판에서 검정 기물의 각 개수를 확인한다.")
    public void countBlackPiece() {
        //when
        long pawn = board.countPiece(PieceUtils.Color.WHITE, PieceUtils.Type.PAWN);
        long rook = board.countPiece(PieceUtils.Color.WHITE, PieceUtils.Type.ROOK);
        long knight = board.countPiece(PieceUtils.Color.WHITE, PieceUtils.Type.KNIGHT);
        long bishop = board.countPiece(PieceUtils.Color.WHITE, PieceUtils.Type.BISHOP);
        long king = board.countPiece(PieceUtils.Color.WHITE, PieceUtils.Type.KING);
        long queen = board.countPiece(PieceUtils.Color.WHITE, PieceUtils.Type.QUEEN);

        //then
        assertThat(pawn).isEqualTo(8);
        assertThat(rook).isEqualTo(2);
        assertThat(knight).isEqualTo(2);
        assertThat(bishop).isEqualTo(2);
        assertThat(king).isEqualTo(1);
        assertThat(queen).isEqualTo(1);
    }


    private String getInitStatusString() {
        String blankRank = appendNewLine("........");
        return appendNewLine("RNBQKBNR") +
                appendNewLine("PPPPPPPP") +
                blankRank + blankRank + blankRank + blankRank +
                appendNewLine("pppppppp") +
                appendNewLine("rnbqkbnr");
    }
}