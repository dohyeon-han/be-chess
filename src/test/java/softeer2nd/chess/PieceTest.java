package softeer2nd.chess;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.util.PieceUtils;
import softeer2nd.chess.util.StringUtils;

import static org.assertj.core.api.Assertions.assertThat;

class PieceTest {

    @Test
    @DisplayName("기물을 생성한다")
    public void createPiece() {
        verifyPiece(Piece.createPiece(PieceUtils.Color.WHITE, PieceUtils.Type.PAWN), PieceUtils.Color.WHITE, PieceUtils.Type.PAWN);
        verifyPiece(Piece.createPiece(PieceUtils.Color.BLACK, PieceUtils.Type.PAWN), PieceUtils.Color.BLACK, PieceUtils.Type.PAWN);

        verifyPiece(Piece.createPiece(PieceUtils.Color.WHITE, PieceUtils.Type.KNIGHT), PieceUtils.Color.WHITE, PieceUtils.Type.KNIGHT);
        verifyPiece(Piece.createPiece(PieceUtils.Color.BLACK, PieceUtils.Type.KNIGHT), PieceUtils.Color.BLACK, PieceUtils.Type.KNIGHT);

        verifyPiece(Piece.createPiece(PieceUtils.Color.WHITE, PieceUtils.Type.ROOK), PieceUtils.Color.WHITE, PieceUtils.Type.ROOK);
        verifyPiece(Piece.createPiece(PieceUtils.Color.BLACK, PieceUtils.Type.ROOK), PieceUtils.Color.BLACK, PieceUtils.Type.ROOK);

        verifyPiece(Piece.createPiece(PieceUtils.Color.WHITE, PieceUtils.Type.KING), PieceUtils.Color.WHITE, PieceUtils.Type.KING);
        verifyPiece(Piece.createPiece(PieceUtils.Color.BLACK, PieceUtils.Type.KING), PieceUtils.Color.BLACK, PieceUtils.Type.KING);

        verifyPiece(Piece.createPiece(PieceUtils.Color.WHITE, PieceUtils.Type.BISHOP), PieceUtils.Color.WHITE, PieceUtils.Type.BISHOP);
        verifyPiece(Piece.createPiece(PieceUtils.Color.BLACK, PieceUtils.Type.BISHOP), PieceUtils.Color.BLACK, PieceUtils.Type.BISHOP);

        verifyPiece(Piece.createPiece(PieceUtils.Color.WHITE, PieceUtils.Type.QUEEN), PieceUtils.Color.WHITE, PieceUtils.Type.QUEEN);
        verifyPiece(Piece.createPiece(PieceUtils.Color.BLACK, PieceUtils.Type.QUEEN), PieceUtils.Color.BLACK, PieceUtils.Type.QUEEN);
    }

    @Test
    @DisplayName("Piece의 색이 검정색인지 확인한다.")
    public void isBlack() {
        Piece black = new Piece(PieceUtils.Color.BLACK, PieceUtils.Type.KING);

        assertThat(black.isBlack()).isTrue();
        assertThat(black.isWhite()).isFalse();
    }

    @Test
    @DisplayName("Piece의 색이 하얀색인지 확인한다.")
    public void isWhite() {
        Piece white = new Piece(PieceUtils.Color.WHITE, PieceUtils.Type.KING);

        assertThat(white.isBlack()).isFalse();
        assertThat(white.isWhite()).isTrue();
    }

    private void verifyPiece(Piece piece, final PieceUtils.Color color, final PieceUtils.Type type){
        assertThat(piece.getColor()).isEqualTo(color);
        if(color.equals(PieceUtils.Color.WHITE)) {
            assertThat(piece.getRepresentation()).isEqualTo(type.getWhiteRepresentation());
        }
        else {
            assertThat(piece.getRepresentation()).isEqualTo(Character.toUpperCase(type.getBlackRepresentation()));
        }
    }

    @Test
    @DisplayName("색이 다른 같은 종류의 Piece 비교")
    public void create_piece() {
        verifyPiece(Piece.createWhitePawn(), Piece.createBlackPawn(), PieceUtils.Type.PAWN);
        verifyPiece(Piece.createWhiteKnight(), Piece.createBlackKnight(), PieceUtils.Type.KNIGHT);
        verifyPiece(Piece.createWhiteRook(), Piece.createBlackRook(), PieceUtils.Type.ROOK);
        verifyPiece(Piece.createWhiteBishop(), Piece.createBlackBishop(), PieceUtils.Type.BISHOP);
        verifyPiece(Piece.createWhiteQueen(), Piece.createBlackQueen(), PieceUtils.Type.QUEEN);
        verifyPiece(Piece.createWhiteKing(), Piece.createBlackKing(), PieceUtils.Type.KING);

        Piece blank = Piece.createBlank();
        assertThat(blank.isWhite()).isFalse();
        assertThat(blank.isBlack()).isFalse();
        assertThat(blank.getType()).isEqualTo(PieceUtils.Type.NO_PIECE);
    }

    private void verifyPiece(final Piece whitePiece, final Piece blackPiece, final PieceUtils.Type type) {
        assertThat(whitePiece.isWhite()).isTrue();
        assertThat(whitePiece.getType()).isEqualTo(type);

        assertThat(blackPiece.isBlack()).isTrue();
        assertThat(blackPiece.getType()).isEqualTo(type);
    }
}