package softeer2nd.chess;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.util.PieceUtils;

import static org.assertj.core.api.Assertions.assertThat;

class PieceTest {

    @Test
    @DisplayName("기물이 생성되어야 한다")
    public void createPiece() {
        verifyPawn(Piece.createPiece(PieceUtils.Color.WHITE, PieceUtils.Type.PAWN), PieceUtils.Color.WHITE, PieceUtils.Type.PAWN);
        verifyPawn(Piece.createPiece(PieceUtils.Color.BLACK, PieceUtils.Type.PAWN), PieceUtils.Color.BLACK, PieceUtils.Type.PAWN);

        verifyPawn(Piece.createPiece(PieceUtils.Color.WHITE, PieceUtils.Type.KNIGHT), PieceUtils.Color.WHITE, PieceUtils.Type.KNIGHT);
        verifyPawn(Piece.createPiece(PieceUtils.Color.BLACK, PieceUtils.Type.KNIGHT), PieceUtils.Color.BLACK, PieceUtils.Type.KNIGHT);

        verifyPawn(Piece.createPiece(PieceUtils.Color.WHITE, PieceUtils.Type.ROOK), PieceUtils.Color.WHITE, PieceUtils.Type.ROOK);
        verifyPawn(Piece.createPiece(PieceUtils.Color.BLACK, PieceUtils.Type.ROOK), PieceUtils.Color.BLACK, PieceUtils.Type.ROOK);

        verifyPawn(Piece.createPiece(PieceUtils.Color.WHITE, PieceUtils.Type.KING), PieceUtils.Color.WHITE, PieceUtils.Type.KING);
        verifyPawn(Piece.createPiece(PieceUtils.Color.BLACK, PieceUtils.Type.KING), PieceUtils.Color.BLACK, PieceUtils.Type.KING);

        verifyPawn(Piece.createPiece(PieceUtils.Color.WHITE, PieceUtils.Type.BISHOP), PieceUtils.Color.WHITE, PieceUtils.Type.BISHOP);
        verifyPawn(Piece.createPiece(PieceUtils.Color.BLACK, PieceUtils.Type.BISHOP), PieceUtils.Color.BLACK, PieceUtils.Type.BISHOP);

        verifyPawn(Piece.createPiece(PieceUtils.Color.WHITE, PieceUtils.Type.QUEEN), PieceUtils.Color.WHITE, PieceUtils.Type.QUEEN);
        verifyPawn(Piece.createPiece(PieceUtils.Color.BLACK, PieceUtils.Type.QUEEN), PieceUtils.Color.BLACK, PieceUtils.Type.QUEEN);
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