package softeer2nd.chess.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.Position;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class DirectionTest {

    @Test
    @DisplayName("NORTHEAST 방향을 판별한다.")
    void getDirectionNORTHEAST() {
        //given
        Position source = new Position("a1");
        Position target = new Position("c3");

        //when
        Direction direction = Direction.getDirection(source, target);

        //then
        assertThat(direction).isEqualTo(Direction.NORTHEAST);
    }

    @Test
    @DisplayName("SOUTHWEST 방향을 판별한다.")
    void getDirectionSOUTHWEST() {
        //given
        Position source = new Position("c3");
        Position target = new Position("a1");

        //when
        Direction direction = Direction.getDirection(source, target);

        //then
        assertThat(direction).isEqualTo(Direction.SOUTHWEST);
    }

    @Test
    @DisplayName("NNW 방향을 판별한다.")
    void getDirectionNNW() {
        //given
        Position source = new Position("b1");
        Position target = new Position("a3");

        //when
        Direction direction = Direction.getDirection(source, target);

        //then
        assertThat(direction).isEqualTo(Direction.NNW);
    }

    @Test
    @DisplayName("SSE 방향을 판별한다.")
    void getDirectionSSE() {
        //given
        Position source = new Position("c3");
        Position target = new Position("d1");

        //when
        Direction direction = Direction.getDirection(source, target);

        //then
        assertThat(direction).isEqualTo(Direction.SSE);
    }

    @Test
    @DisplayName("올바르지 않은 방향은 예외가 발생한다.")
    void invalidDirection() {
        //given
        Position source = new Position("c3");
        Position target = new Position("d7");

        //when
        //then
        assertThrows(IllegalArgumentException.class, () -> Direction.getDirection(source, target));
    }
}