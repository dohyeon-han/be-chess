package softeer2nd.chess;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.util.PieceUtils;

import static org.assertj.core.api.Assertions.assertThat;

class PieceTest {

    @Test
    @DisplayName("폰이 생성되어야 한다")
    public void createWhite() {
        verifyPawn(Piece.createWhitePawn(), PieceUtils.Color.WHITE, Piece.WHITE_PAWN_REPRESENTATION);
        verifyPawn(Piece.createBlackPawn(), PieceUtils.Color.BLACK, Piece.BLACK_PAWN_REPRESENTATION);
    }

    private void verifyPawn(Piece piece, final PieceUtils.Color color, final char representation){
        assertThat(piece.getColor()).isEqualTo(color);
        assertThat(piece.getRepresentation()).isEqualTo(representation);
    }
}