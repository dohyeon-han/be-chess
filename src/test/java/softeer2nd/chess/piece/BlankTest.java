package softeer2nd.chess.piece;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.Position;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class BlankTest {

    @Test
    @DisplayName("Blank는 이동할 수 없다.")
    public void cannotMove() {
        //given
        Position source = new Position("e5");
        Position target = new Position("d2");
        Blank blank = spy(Blank.createBlank());

        //when, then
        assertThrows(IllegalArgumentException.class, () -> verifyMove(blank, source, target));
    }

    private void verifyMove(Blank blank, Position source, Position target) {
        //when
        blank.verifyMovePosition(source, target);

        //then
        verify(blank, times(1)).verifyMovePosition(source, target);
    }
}
