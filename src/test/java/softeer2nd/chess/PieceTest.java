package softeer2nd.chess;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PieceTest {

    @Test
    @DisplayName("폰이 생성되어야 한다")
    public void createWhite() {
        verifyPawn(Piece.WHITE_COLOR, Piece.WHITE_REPRESENTATION);
        verifyPawn(Piece.BLACK_COLOR, Piece.BLACK_REPRESENTATION);
    }

    private void verifyPawn(final String color, final char representation){
        Piece piece = new Piece(color, representation);
        assertThat(piece.getColor()).isEqualTo(color);
        assertThat(piece.getRepresentation()).isEqualTo(representation);
    }
}