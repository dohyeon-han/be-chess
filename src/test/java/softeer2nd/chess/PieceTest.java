package softeer2nd.chess;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.util.PieceUtils;

import static org.assertj.core.api.Assertions.assertThat;

class PieceTest {

    @Test
    @DisplayName("폰이 생성되어야 한다")
    public void createWhite() {
        verifyPawn(Piece.createWhitePawn(), PieceUtils.Color.WHITE, PieceUtils.Type.PAWN);
        verifyPawn(Piece.createBlackPawn(), PieceUtils.Color.BLACK, PieceUtils.Type.PAWN);
    }

    private void verifyPawn(Piece piece, final PieceUtils.Color color, final PieceUtils.Type type){
        assertThat(piece.getColor()).isEqualTo(color);
        if(color.equals(PieceUtils.Color.WHITE)) {
            assertThat(piece.getRepresentation()).isEqualTo(type.getRepresentation());
        }
        else {
            assertThat(piece.getRepresentation()).isEqualTo(Character.toUpperCase(type.getRepresentation()));
        }
    }
}