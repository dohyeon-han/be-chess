package softeer2nd.chess.piece;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.Position;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class KingTest {
    @Test
    @DisplayName("북동쪽으로 1칸 이동한다.")
    public void verifyMovePositionNE() {
        //given
        Position source = new Position("c1");
        Position target = new Position("d2");
        King king = spy(King.createBlackKing());

        //when, then
        verifyMove(king, source, target);
    }

    @Test
    @DisplayName("남동쪽으로 1칸 이동한다.")
    public void verifyMovePositionSE() {
        //given
        Position source = new Position("b6");
        Position target = new Position("c5");
        King king = spy(King.createBlackKing());

        //when, then
        verifyMove(king, source, target);
    }

    @Test
    @DisplayName("북서쪽으로 1칸 이동한다.")
    public void verifyMovePositionNW() {
        //given
        Position source = new Position("f1");
        Position target = new Position("e2");
        King king = spy(King.createBlackKing());

        //when, then
        verifyMove(king, source, target);
    }

    @Test
    @DisplayName("동쪽으로 1칸 이동한다.")
    public void verifyMovePositionE() {
        //given
        Position source = new Position("e5");
        Position target = new Position("f5");
        King king = spy(King.createBlackKing());

        //when, then
        verifyMove(king, source, target);
    }

    @Test
    @DisplayName("서쪽으로 1칸 이동한다.")
    public void verifyMovePositionW() {
        //given
        Position source = new Position("e5");
        Position target = new Position("d5");
        King king = spy(King.createBlackKing());

        //when, then
        verifyMove(king, source, target);
    }

    @Test
    @DisplayName("남쪽으로 1칸 이동한다.")
    public void verifyMovePositionS() {
        //given
        Position source = new Position("e5");
        Position target = new Position("e4");
        King king = spy(King.createBlackKing());

        //when, then
        verifyMove(king, source, target);
    }

    @Test
    @DisplayName("북쪽으로 1칸 이동한다.")
    public void verifyMovePositionN() {
        //given
        Position source = new Position("e5");
        Position target = new Position("e6");
        King king = spy(King.createBlackKing());

        //when, then
        verifyMove(king, source, target);
    }

    @Test
    @DisplayName("남서쪽으로 1칸 이동한다.")
    public void verifyMovePositionSW() {
        //given
        Position source = new Position("e5");
        Position target = new Position("d4");
        King king = spy(King.createBlackKing());

        //when, then
        verifyMove(king, source, target);
    }

    @Test
    @DisplayName("규칙에 맞지 않은 이동은 예외가 발생한다.")
    public void wrongMove() {
        //given
        Position source = new Position("e3");
        Position target = new Position("c5");
        King king = spy(King.createBlackKing());

        //when, then
        assertThrows(IllegalArgumentException.class, () -> verifyMove(king, source, target));
    }

    private void verifyMove(King king, Position source, Position target) {
        //when
        king.verifyMovePosition(source, target);

        //then
        verify(king, times(1)).verifyMovePosition(source, target);
    }
}
