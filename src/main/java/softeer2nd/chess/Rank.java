package softeer2nd.chess;

import softeer2nd.chess.util.PieceUtils;

import java.util.ArrayList;
import java.util.List;

import static softeer2nd.chess.Board.BOARD_LENGTH;

public class Rank {

    private final List<Piece> rank = new ArrayList<>(BOARD_LENGTH);

    public void initialize(PieceUtils.Color color, PieceUtils.Type type) {
        rank.clear();
        for (int i = 0; i < BOARD_LENGTH; i++) {
            this.rank.add(Piece.createPiece(color, type));
        }
    }

    public void initializeOthers(PieceUtils.Color color) {
        rank.clear();
        this.rank.add(Piece.createPiece(color, PieceUtils.Type.ROOK));
        this.rank.add(Piece.createPiece(color, PieceUtils.Type.KNIGHT));
        this.rank.add(Piece.createPiece(color, PieceUtils.Type.BISHOP));
        this.rank.add(Piece.createPiece(color, PieceUtils.Type.QUEEN));
        this.rank.add(Piece.createPiece(color, PieceUtils.Type.KING));
        this.rank.add(Piece.createPiece(color, PieceUtils.Type.BISHOP));
        this.rank.add(Piece.createPiece(color, PieceUtils.Type.KNIGHT));
        this.rank.add(Piece.createPiece(color, PieceUtils.Type.ROOK));
    }

    public List<Piece> getRank() {
        return new ArrayList<>(this.rank);
    }

    public Piece getPiece(int idx) {
        return this.rank.get(idx);
    }

    public void replace(int idx, Piece piece) {
        this.rank.set(idx, piece);
    }
}
