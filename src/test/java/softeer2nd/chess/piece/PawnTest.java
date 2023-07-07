package softeer2nd.chess.piece;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.Position;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class PawnTest {

    @Test
    @DisplayName("흰 폰은 아래로 1칸 이동할 수 있다.")
    public void moveDownWhitePawn() {
        //given
        Position source = new Position("g7");
        Position target = new Position("g6");
        Pawn pawn = spy(Pawn.createWhitePawn());

        //when, then
        verifyMove(pawn, source, target);
    }

    @Test
    @DisplayName("흰 폰은 왼쪽 대각선 아래로 이동할 수 있다.")
    public void moveDownLeftWhitePawn() {
        //given
        Position source = new Position("g7");
        Position target = new Position("f6");
        Pawn pawn = spy(Pawn.createWhitePawn());

        //when, then
        verifyMove(pawn, source, target);
    }

    @Test
    @DisplayName("흰 폰은 오른쪽 대각선 아래로 이동할 수 있다.")
    public void moveDownRightWhitePawn() {
        //given
        Position source = new Position("f7");
        Position target = new Position("g6");
        Pawn pawn = spy(Pawn.createWhitePawn());

        //when, then
        verifyMove(pawn, source, target);
    }

    @Test
    @DisplayName("검정 폰은 위로 1칸 이동할 수 있다.")
    public void moveUpWhitePawn() {
        //given
        Position source = new Position("a2");
        Position target = new Position("a3");
        Pawn pawn = spy(Pawn.createBlackPawn());

        //when, then
        verifyMove(pawn, source, target);
    }

    @Test
    @DisplayName("검정 폰은 왼쪽 대각선 위로 이동할 수 있다.")
    public void moveUpLeftWhitePawn() {
        //given
        Position source = new Position("b2");
        Position target = new Position("a3");
        Pawn pawn = spy(Pawn.createBlackPawn());

        //when, then
        verifyMove(pawn, source, target);
    }

    @Test
    @DisplayName("검정 폰은 오른쪽 대각선 위로 이동할 수 있다.")
    public void moveUpRightWhitePawn() {
        //given
        Position source = new Position("a2");
        Position target = new Position("b3");
        Pawn pawn = spy(Pawn.createBlackPawn());

        //when, then
        verifyMove(pawn, source, target);
    }

    @Test
    @DisplayName("흰 폰의 잘못된 이동은 예외가 발생한다.")
    public void moveWhiteWrong() {
        //given
        Position source = new Position("a1");
        Position target = new Position("a2");
        Pawn pawn = spy(Pawn.createWhitePawn());

        //when, then
        assertThrows(IllegalArgumentException.class, () -> verifyMove(pawn, source, target));
    }

    @Test
    @DisplayName("검정 폰의 잘못된 이동은 예외가 발생한다.")
    public void moveBlackWrong() {
        //given
        Position source = new Position("g2");
        Position target = new Position("g1");
        Pawn pawn = spy(Pawn.createBlackPawn());

        //when, then
        assertThrows(IllegalArgumentException.class, () -> verifyMove(pawn, source, target));
    }

    private void verifyMove(Pawn pawn, Position source, Position target) {
        //when
        pawn.verifyMovePosition(source, target);

        //then
        verify(pawn, times(1)).verifyMovePosition(source, target);
    }
}
