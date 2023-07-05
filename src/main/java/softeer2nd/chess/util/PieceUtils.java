package softeer2nd.chess.util;

public class PieceUtils {

    private PieceUtils() {
    }

    public enum Type {

        PAWN('p'), KNIGHT('n'), ROOK('r'), BISHOP('b'),
        QUEEN('q'), KING('k'), NO_PIECE('x');

        private final char representation;


        Type(char representation) {
            this.representation = representation;
        }

        public char getWhiteRepresentation() {
            return this.representation;
        }

        public char getBlackRepresentation() {
            return Character.toUpperCase(this.representation);
        }
    }

    public enum Color {
        WHITE, BLACK, NOCOLOR
    }
}
