package softeer2nd.chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.util.StringUtils;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;
import static softeer2nd.chess.util.StringUtils.appendNewLine;

public class ViewTest {

    Board board;
    View view;

    @BeforeEach
    public void setUp() {
        board = new Board();
        view = new View(board);
        board.initialize();
    }

    @Test
    @DisplayName("초기화한 체스판을 출력한다.")
    public void printInitialize() {
        // 이전의 System.out 저장
        PrintStream originalOut = System.out;

        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        view.print();
        assertThat(outputStreamCaptor.toString()).isEqualTo(getInitStatusString());

        // System.out을 이전의 PrintStream으로 복원
        System.setOut(originalOut);
    }

    @Test
    @DisplayName("체스판의 전체 상태를 확인한다.")
    public void create() {
        assertThat(32).isEqualTo(board.countPiece());
        assertThat(getInitStatusString())
                .isEqualTo(view.showBoard());
    }

    private String getInitStatusString() {
        return appendNewLine("RNBQKBNR  8") +
                appendNewLine("PPPPPPPP  7") +
                getBlankRank(6) + getBlankRank(5) + getBlankRank(4) + getBlankRank(3) +
                appendNewLine("pppppppp  2") +
                appendNewLine("rnbqkbnr  1") +
                StringUtils.NEWLINE + StringUtils.appendNewLine("abcdefgh");
    }

    private String getBlankRank(int number) {
        return appendNewLine("........  " + number);
    }
}
