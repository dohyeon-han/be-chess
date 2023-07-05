package softeer2nd.chess.util;

public class PieceUtils {

    public enum Type {

        PAWN('p'), KNIGHT('n'), ROOK('r'), BISHOP('b'), QUEEN('q'), KING('k');

        private final char representation;


        Type(char representation) {
            this.representation = representation;
        }

        public char getRepresentation() {
            return representation;
        }
    }

    public enum Color {
        WHITE, BLACK
    }
}
