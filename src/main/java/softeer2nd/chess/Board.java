package softeer2nd.chess;

import java.util.ArrayList;
import java.util.List;


public class Board {

    private final List<Pawn> pieces = new ArrayList<>();
    private final List<StringBuilder> board = new ArrayList<>();

    public void initialize() {
        board.add(new StringBuilder("........"));
        board.add(new StringBuilder("PPPPPPPP"));
        board.add(new StringBuilder("........"));
        board.add(new StringBuilder("........"));
        board.add(new StringBuilder("........"));
        board.add(new StringBuilder("........"));
        board.add(new StringBuilder("pppppppp"));
        board.add(new StringBuilder("........"));
    }

    public void add(Pawn pawn){
        pieces.add(pawn);
    }

    public int size() {
        return pieces.size();
    }

    public Pawn findPawn(int idx) {
        return pieces.get(idx);
    }

    public String getWhitePawnsResult() {
        return this.board.get(6).toString();
    }

    public String getBlackPawnsResult() {
        return this.board.get(1).toString();
    }
}
