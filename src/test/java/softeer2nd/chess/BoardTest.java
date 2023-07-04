package softeer2nd.chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

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
        String init = "........\npppppppp\n........\n........\n........\n........\nPPPPPPPP\n........";
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        board.print();
        assertThat(outputStreamCaptor.toString().trim()).isEqualTo(init);

        System.setOut(new PrintStream(System.out));
    }
}