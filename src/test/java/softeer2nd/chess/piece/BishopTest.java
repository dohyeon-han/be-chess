package softeer2nd.chess.piece;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.Position;

import static org.mockito.Mockito.*;

class BishopTest {

    @Test
    @DisplayName("북동쪽으로 3칸 이동한다.")
    public void verifyMovePositionNE() {
        //given
        Position source = new Position("c1");
        Position target = new Position("f4");
        Bishop bishop = spy(Bishop.createBlackBishop());

        //when, then
        verifyMove(bishop, source, target);
    }

    @Test
    @DisplayName("남동쪽으로 1칸 이동한다.")
    public void verifyMovePositionSE() {
        //given
        Position source = new Position("b6");
        Position target = new Position("c5");
        Bishop bishop = spy(Bishop.createBlackBishop());

        //when, then
        verifyMove(bishop, source, target);
    }

    @Test
    @DisplayName("북서쪽으로 4칸 이동한다.")
    public void verifyMovePositionNW() {
        //given
        Position source = new Position("f1");
        Position target = new Position("b5");
        Bishop bishop = spy(Bishop.createBlackBishop());

        //when, then
        verifyMove(bishop, source, target);
    }

    @Test
    @DisplayName("남서쪽으로 2칸 이동한다.")
    public void verifyMovePositionSW() {
        //given
        Position source = new Position("e5");
        Position target = new Position("c3");
        Bishop bishop = spy(Bishop.createBlackBishop());

        //when, then
        verifyMove(bishop, source, target);
    }

    private void verifyMove(Bishop bishop, Position source, Position target) {
        //when
        bishop.verifyMovePosition(source, target);

        //then
        verify(bishop, times(1)).verifyMovePosition(source, target);
    }

}