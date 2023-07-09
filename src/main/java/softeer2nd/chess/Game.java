package softeer2nd.chess;

import softeer2nd.chess.piece.Piece;

public class Game {

    private final Board board;

    public Game(Board board) {
        this.board = board;
    }

    public void initializeBoard() {
        board.initialize();
    }

    public void move(String pos, Piece piece) {
        this.board.replace(pos, piece);
    }

    public void move(String source, String target) {
        Piece sourcePiece = this.board.findPiece(source);
        Piece targetPiece = this.board.findPiece(target);

        if (sourcePiece.isBlank()) {
            throw new IllegalArgumentException("이동할 수 있는 말이 없습니다.");
        }

        // 기물 잡기
//        if(!targetPiece.isBlank()) {
//            if(sourcePiece.getColor().equals(targetPiece.getColor())){
//                throw new IllegalArgumentException("색이 같은 기물이 있는 칸으로 이동할 수 없습니다.");
//            }
//            if(sourcePiece.getType().equals())
//        }

        this.board.replace(source, targetPiece);
        this.board.replace(target, sourcePiece);
    }


}
