package softeer2nd.chess.piece;

import softeer2nd.chess.util.PieceUtils.Color;
import softeer2nd.chess.util.PieceUtils.Type;

public class Blank extends Piece {

    private Blank(Color color, Type type) {
        super(color, type);
    }

    public static Blank createBlank() {
        return new Blank(Color.NOCOLOR, Type.NO_PIECE);
    }
}
