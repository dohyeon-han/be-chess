package softeer2nd.chess;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BoardTest {

    @Test
    @DisplayName("흰 폰과 검정 폰이 체스판에 추가된다.")
    public void create() {
        Board board = new Board();

        verifyBoard(board, Pawn.WHITE_COLOR, Pawn.WHITE_REPRESENTATION, 1, 0);
        verifyBoard(board, Pawn.BLACK_COLOR, Pawn.BLACK_REPRESENTATION, 2, 1);
    }

    public void verifyBoard(Board board, String color, char representation, int size, int idx) {
        Pawn pawn = new Pawn(color, representation);
        board.add(pawn);
        assertThat(size).isEqualTo(board.size());
        assertThat(pawn).isEqualTo(board.findPawn(idx));
    }
}