package softeer2nd.chess;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.util.PieceUtils;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {

    @Test
    @DisplayName("blank로 초기화한다.")
    public void initializeWithBlank() {
        //given
        Rank rank = new Rank();

        //when
        rank.initialize(PieceUtils.Color.NOCOLOR, PieceUtils.Type.NO_PIECE);

        //then
        List<Piece> list = rank.getRank();
        assertThat(list).hasSize(8);
        for (Piece blank : rank.getRank()) {
            assertThat(blank).isEqualToComparingFieldByFieldRecursively(Piece.createBlank());
        }
    }

    @Test
    @DisplayName("Rank가 흰색 폰으로 초기화된다.")
    public void initializeWithPawn() {
        //given
        Rank rank = new Rank();

        //when
        rank.initialize(PieceUtils.Color.WHITE, PieceUtils.Type.PAWN);

        //then
        List<Piece> list = rank.getRank();
        assertThat(list).hasSize(8);

        for (Piece pawn : list) {
            assertThat(pawn)
                    .isEqualToComparingFieldByFieldRecursively(Piece.createPiece(PieceUtils.Color.WHITE, PieceUtils.Type.PAWN));
        }
    }

    @Test
    @DisplayName("Rank가 pawn제외한 다른 기물들로 초기화된다.")
    public void initializeWithOthers() {
        //given
        Rank rank = new Rank();

        //when
        rank.initializeOthers(PieceUtils.Color.BLACK);

        //then
        List<Piece> list = rank.getRank();
        assertThat(list).hasSize(8);

        assertThat(list.get(0))
                .isEqualToComparingFieldByFieldRecursively(Piece.createPiece(PieceUtils.Color.BLACK, PieceUtils.Type.ROOK));
        assertThat(list.get(1))
                .isEqualToComparingFieldByFieldRecursively(Piece.createPiece(PieceUtils.Color.BLACK, PieceUtils.Type.KNIGHT));
        assertThat(list.get(2))
                .isEqualToComparingFieldByFieldRecursively(Piece.createPiece(PieceUtils.Color.BLACK, PieceUtils.Type.BISHOP));
        assertThat(list.get(3))
                .isEqualToComparingFieldByFieldRecursively(Piece.createPiece(PieceUtils.Color.BLACK, PieceUtils.Type.QUEEN));
        assertThat(list.get(4))
                .isEqualToComparingFieldByFieldRecursively(Piece.createPiece(PieceUtils.Color.BLACK, PieceUtils.Type.KING));
        assertThat(list.get(5))
                .isEqualToComparingFieldByFieldRecursively(Piece.createPiece(PieceUtils.Color.BLACK, PieceUtils.Type.BISHOP));
        assertThat(list.get(6))
                .isEqualToComparingFieldByFieldRecursively(Piece.createPiece(PieceUtils.Color.BLACK, PieceUtils.Type.KNIGHT));
        assertThat(list.get(7))
                .isEqualToComparingFieldByFieldRecursively(Piece.createPiece(PieceUtils.Color.BLACK, PieceUtils.Type.ROOK));
    }
}
