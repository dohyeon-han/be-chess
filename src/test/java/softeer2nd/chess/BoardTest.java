package softeer2nd.chess;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BoardTest {

    @Test
    @DisplayName("흰 폰과 검정 폰이 체스판에 추가된다.")
    public void create() {
        Board board = new Board();

        Pawn white = addPawn(board, Pawn.WHITE_COLOR, Pawn.WHITE_REPRESENTATION);
        verifyBoard(board, white, 1, 0);

        Pawn black = addPawn(board, Pawn.BLACK_COLOR, Pawn.BLACK_REPRESENTATION);
        verifyBoard(board, black, 2, 1);
    }

    public Pawn addPawn(Board board, String color, char representation) {
        Pawn pawn = new Pawn(color, representation);
        board.add(pawn);
        return pawn;
    }

    public void verifyBoard(Board board, Pawn pawn, int size, int idx) {
        assertThat(size).isEqualTo(board.size());
        assertThat(pawn).isEqualTo(board.findPawn(idx));
    }
}