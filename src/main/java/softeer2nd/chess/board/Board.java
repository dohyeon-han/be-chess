package softeer2nd.chess.board;

import softeer2nd.chess.Rank;
import softeer2nd.chess.util.PieceUtils;

import java.util.ArrayList;
import java.util.List;

public class Board {
    public static final int BOARD_LENGTH = 8;
    private final List<Rank> board = new ArrayList<>(BOARD_LENGTH);

    public Board() {
        initialize();
    }

    public void initialize() {
        board.clear();
        for (int i = 0; i < BOARD_LENGTH; i++) {
            board.add(new Rank());
        }
        initializeByColor(PieceUtils.Color.WHITE);
        initializeByColor(PieceUtils.Color.BLACK);
        for (int i = 2; i < 6; i++) {
            board.get(i).initialize(PieceUtils.Color.NOCOLOR, PieceUtils.Type.NO_PIECE);
        }
    }

    public void initializeEmpty() {
        board.clear();
        for (int i = 0; i < BOARD_LENGTH; i++) {
            board.add(new Rank());
        }
        for (int i = 0; i < 8; i++) {
            board.get(i).initialize(PieceUtils.Color.NOCOLOR, PieceUtils.Type.NO_PIECE);
        }
    }

    private void initializeByColor(PieceUtils.Color color) {
        int pawnRow = color.equals(PieceUtils.Color.BLACK) ? 1 : 6;
        int otherRow = color.equals(PieceUtils.Color.BLACK) ? 0 : 7;

        board.get(pawnRow).initialize(color, PieceUtils.Type.PAWN);
        board.get(otherRow).initializeOthers(color);
    }

    public List<Rank> getBoard() {
        return new ArrayList<>(this.board);
    }
}
