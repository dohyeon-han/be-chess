package softeer2nd;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PawnTest {

    @Test
    @DisplayName("폰이 생성되어야 한다")
    public void createWhite() {
        final String WHITE = "white";
        final String BLACK = "black";

        verifyPawn(WHITE);
        verifyPawn(BLACK);
    }

    @Test
    @DisplayName("생성자에 인자가 없으면 흰 폰이 생성된다.")
    public void create_기본생성자() {
        Pawn pawn = new Pawn();
        assertThat(pawn.getColor()).isEqualTo("white");
    }

    public void verifyPawn(final String color){
        Pawn pawn = new Pawn(color);
        assertThat(pawn.getColor()).isEqualTo(color);
    }
}