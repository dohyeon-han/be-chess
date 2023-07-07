package softeer2nd.chess.piece;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.Position;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class KnightTest {

    @Test
    @DisplayName("WWS로 이동한다.")
    public void verifyMovePositionWWS() {
        //given
        Position source = new Position("d4");
        Position target = new Position("b3");
        Knight knight = spy(Knight.createWhiteKnight());

        //when, then
        verifyMove(knight, source, target);
    }

    @Test
    @DisplayName("WWN으로 이동한다.")
    public void verifyMovePositionWWN() {
        //given
        Position source = new Position("d4");
        Position target = new Position("b5");
        Knight knight = spy(Knight.createWhiteKnight());

        //when, then
        verifyMove(knight, source, target);
    }

    @Test
    @DisplayName("EES로 이동한다.")
    public void verifyMovePositionEES() {
        //given
        Position source = new Position("d4");
        Position target = new Position("f3");
        Knight knight = spy(Knight.createWhiteKnight());

        //when, then
        verifyMove(knight, source, target);
    }

    @Test
    @DisplayName("EEN으로 이동한다.")
    public void verifyMovePositionEEN() {
        //given
        Position source = new Position("d4");
        Position target = new Position("f5");
        Knight knight = spy(Knight.createWhiteKnight());

        //when, then
        verifyMove(knight, source, target);
    }

    @Test
    @DisplayName("SSW로 이동한다.")
    public void verifyMovePositionSSW() {
        //given
        Position source = new Position("d4");
        Position target = new Position("c2");
        Knight knight = spy(Knight.createWhiteKnight());

        //when, then
        verifyMove(knight, source, target);
    }

    @Test
    @DisplayName("SSE로 이동한다.")
    public void verifyMovePositionSSE() {
        //given
        Position source = new Position("d4");
        Position target = new Position("e2");
        Knight knight = spy(Knight.createWhiteKnight());

        //when, then
        verifyMove(knight, source, target);
    }

    @Test
    @DisplayName("NNW로 이동한다.")
    public void verifyMovePositionNNW() {
        //given
        Position source = new Position("d4");
        Position target = new Position("c6");
        Knight knight = spy(Knight.createWhiteKnight());

        //when, then
        verifyMove(knight, source, target);
    }

    @Test
    @DisplayName("NNE로 이동한다.")
    public void verifyMovePositionNNE() {
        //given
        Position source = new Position("d4");
        Position target = new Position("e6");
        Knight knight = spy(Knight.createWhiteKnight());

        //when, then
        verifyMove(knight, source, target);
    }

    @Test
    @DisplayName("제자리 이동은 예외가 발생한다.")
    public void moveStay() {
        //given
        Position source = new Position("d4");
        Position target = new Position("d4");
        Knight knight = spy(Knight.createWhiteKnight());

        //when, then
        assertThrows(IllegalArgumentException.class, () -> verifyMove(knight, source, target));
    }

    @Test
    @DisplayName("규칙에 맞지 않은 이동은 예외가 발생한다.")
    public void wrongMove() {
        //given
        Position source = new Position("d4");
        Position target = new Position("d5");
        Knight knight = spy(Knight.createWhiteKnight());

        //when, then
        assertThrows(IllegalArgumentException.class, () -> verifyMove(knight, source, target));
    }

    private void verifyMove(Knight knight, Position source, Position target) {
        //when
        knight.verifyMovePosition(source, target);

        //then
        verify(knight, times(1)).verifyMovePosition(source, target);
    }
}
