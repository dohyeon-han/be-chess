package softeer2nd.chess;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.util.PieceUtils.*;

import static org.assertj.core.api.Assertions.assertThat;

class PieceTest {

    @Test
    @DisplayName("기물을 생성한다")
    public void createPiece() {
        verifyPiece(Piece.createPiece(Color.WHITE, Type.PAWN), Color.WHITE, Type.PAWN);
        verifyPiece(Piece.createPiece(Color.BLACK, Type.PAWN), Color.BLACK, Type.PAWN);

        verifyPiece(Piece.createPiece(Color.WHITE, Type.KNIGHT), Color.WHITE, Type.KNIGHT);
        verifyPiece(Piece.createPiece(Color.BLACK, Type.KNIGHT), Color.BLACK, Type.KNIGHT);

        verifyPiece(Piece.createPiece(Color.WHITE, Type.ROOK), Color.WHITE, Type.ROOK);
        verifyPiece(Piece.createPiece(Color.BLACK, Type.ROOK), Color.BLACK, Type.ROOK);

        verifyPiece(Piece.createPiece(Color.WHITE, Type.KING), Color.WHITE, Type.KING);
        verifyPiece(Piece.createPiece(Color.BLACK, Type.KING), Color.BLACK, Type.KING);

        verifyPiece(Piece.createPiece(Color.WHITE, Type.BISHOP), Color.WHITE, Type.BISHOP);
        verifyPiece(Piece.createPiece(Color.BLACK, Type.BISHOP), Color.BLACK, Type.BISHOP);

        verifyPiece(Piece.createPiece(Color.WHITE, Type.QUEEN), Color.WHITE, Type.QUEEN);
        verifyPiece(Piece.createPiece(Color.BLACK, Type.QUEEN), Color.BLACK, Type.QUEEN);
    }

    @Test
    @DisplayName("Piece의 색이 검정색인지 확인한다.")
    public void isBlack() {
        Piece black = new Piece(Color.BLACK, Type.KING);

        assertThat(black.isBlack()).isTrue();
        assertThat(black.isWhite()).isFalse();
    }

    @Test
    @DisplayName("Piece의 색이 하얀색인지 확인한다.")
    public void isWhite() {
        Piece white = new Piece(Color.WHITE, Type.KING);

        assertThat(white.isBlack()).isFalse();
        assertThat(white.isWhite()).isTrue();
    }

    private void verifyPiece(Piece piece, final Color color, final Type type){
        assertThat(piece.getColor()).isEqualTo(color);
        if(color.equals(Color.WHITE)) {
            assertThat(piece.getRepresentation()).isEqualTo(type.getWhiteRepresentation());
        }
        else {
            assertThat(piece.getRepresentation()).isEqualTo(Character.toUpperCase(type.getBlackRepresentation()));
        }
    }

    @Test
    @DisplayName("색이 다른 같은 종류의 Piece 비교")
    public void create_piece() {
        verifyPiece(Piece.createPiece(Color.WHITE, Type.PAWN), Piece.createPiece(Color.BLACK, Type.PAWN), Type.PAWN);
        verifyPiece(Piece.createPiece(Color.WHITE, Type.KNIGHT), Piece.createPiece(Color.BLACK, Type.KNIGHT), Type.KNIGHT);
        verifyPiece(Piece.createPiece(Color.WHITE, Type.ROOK), Piece.createPiece(Color.BLACK, Type.ROOK), Type.ROOK);
        verifyPiece(Piece.createPiece(Color.WHITE, Type.BISHOP), Piece.createPiece(Color.BLACK, Type.BISHOP), Type.BISHOP);
        verifyPiece(Piece.createPiece(Color.WHITE, Type.QUEEN), Piece.createPiece(Color.BLACK, Type.QUEEN), Type.QUEEN);
        verifyPiece(Piece.createPiece(Color.WHITE, Type.KING), Piece.createPiece(Color.BLACK, Type.KING), Type.KING);

        Piece blank = Piece.createBlank();
        assertThat(blank.isWhite()).isFalse();
        assertThat(blank.isBlack()).isFalse();
        assertThat(blank.getType()).isEqualTo(Type.NO_PIECE);
    }

    private void verifyPiece(final Piece whitePiece, final Piece blackPiece, final Type type) {
        assertThat(whitePiece.isWhite()).isTrue();
        assertThat(whitePiece.getType()).isEqualTo(type);

        assertThat(blackPiece.isBlack()).isTrue();
        assertThat(blackPiece.getType()).isEqualTo(type);
    }
}