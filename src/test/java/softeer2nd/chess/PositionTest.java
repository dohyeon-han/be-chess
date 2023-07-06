package softeer2nd.chess;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PositionTest {

    @Test
    @DisplayName("Position 객체를 생성한다.")
    public void createPosition() {
        //given
        String pos = "f2";

        //when
        Position position = new Position(pos);

        //then
        assertThat(position.getX()).isEqualTo(5);
        assertThat(position.getY()).isEqualTo(6);
    }

    @Test
    @DisplayName("행 값이 1~8이 아니면 예외가 발생한다.")
    public void findPieceRowException() {
        //given
        String pos = "a9";

        //when
        //then
        assertThrows(IllegalArgumentException.class, () -> new Position(pos));
    }

    @Test
    @DisplayName("열 값이 a~h가 아니면 예외가 발생한다.")
    public void findPieceColumnException() {
        //given
        String pos = "i2";

        //when
        //then
        assertThrows(IllegalArgumentException.class, () -> new Position(pos));
    }
}