package softeer2nd.chess.piece;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.Position;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class RookTest {

    @Test
    @DisplayName("동쪽으로 2칸 이동한다.")
    public void verifyMovePositionE() {
        //given
        Position source = new Position("e5");
        Position target = new Position("g5");
        Rook rook = spy(Rook.createBlackRook());

        //when, then
        verifyMove(rook, source, target);
    }

    @Test
    @DisplayName("서쪽으로 3칸 이동한다.")
    public void verifyMovePositionW() {
        //given
        Position source = new Position("e5");
        Position target = new Position("b5");
        Rook rook = spy(Rook.createBlackRook());

        //when, then
        verifyMove(rook, source, target);
    }

    @Test
    @DisplayName("남쪽으로 4칸 이동한다.")
    public void verifyMovePositionS() {
        //given
        Position source = new Position("e5");
        Position target = new Position("e1");
        Rook rook = spy(Rook.createBlackRook());

        //when, then
        verifyMove(rook, source, target);
    }

    @Test
    @DisplayName("북쪽으로 2칸 이동한다.")
    public void verifyMovePositionN() {
        //given
        Position source = new Position("e5");
        Position target = new Position("e7");
        Rook rook = spy(Rook.createBlackRook());

        //when, then
        verifyMove(rook, source, target);
    }

    @Test
    @DisplayName("규칙에 맞지 않은 이동은 예외가 발생한다.")
    public void wrongMove() {
        //given
        Position source = new Position("e3");
        Position target = new Position("d5");
        Rook rook = spy(Rook.createBlackRook());

        //when, then
        assertThrows(IllegalArgumentException.class, () -> verifyMove(rook, source, target));
    }

    @Test
    @DisplayName("같은 자리로 이동하면 예외가 발생한다.")
    public void noMove() {
        //given
        Position source = new Position("e3");
        Position target = new Position("e3");
        Rook rook = spy(Rook.createBlackRook());

        //when, then
        assertThrows(IllegalArgumentException.class, () -> verifyMove(rook, source, target));
    }

    private void verifyMove(Rook rook, Position source, Position target) {
        //when
        rook.verifyMovePosition(source, target);

        //then
        verify(rook, times(1)).verifyMovePosition(source, target);
    }
}
