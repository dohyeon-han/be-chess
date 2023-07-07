package softeer2nd.chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.piece.Blank;
import softeer2nd.chess.piece.Piece;
import softeer2nd.chess.util.PieceUtils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GameTest {

    Board board;
    Game game;

    @BeforeEach
    public void setUp() {
        board = new Board();
        game = new Game(board);
        board.initialize();
    }

    @Test
    @DisplayName("폰을 b2에서 b3로 이동시킨다.")
    public void move() {
        //given
        String sourcePosition = "b2";
        String targetPosition = "b3";

        //when
        game.move(sourcePosition, targetPosition);

        //then
        assertThat(board.findPiece(sourcePosition)).isEqualToComparingFieldByFieldRecursively(Blank.createBlank());
        assertThat(board.findPiece(targetPosition)).isEqualToComparingFieldByFieldRecursively(Piece.createPiece(PieceUtils.Color.WHITE, PieceUtils.Type.PAWN));
    }

    @Test
    @DisplayName("move의 시작점이 blank이면 오류가 발생한다.")
    public void moveBlank() {
        //when
        //then
        assertThrows(IllegalArgumentException.class, () -> game.move("a4", "a5"));
    }

}
