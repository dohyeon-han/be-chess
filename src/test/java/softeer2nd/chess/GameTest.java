package softeer2nd.chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.piece.*;
import softeer2nd.chess.util.PieceUtils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GameTest {

    Board board;
    Game game;

    @BeforeEach
    public void setUp() {
        board = new Board();
        game = new Game(board);
        board.initialize();
    }

    @Test
    @DisplayName("폰을 b2에서 b3로 이동시킨다.")
    public void move() {
        //given
        String sourcePosition = "b2";
        String targetPosition = "b3";

        //when
        game.move(sourcePosition, targetPosition);

        //then
        assertThat(board.findPiece(sourcePosition)).isEqualToComparingFieldByFieldRecursively(Blank.createBlank());
        assertThat(board.findPiece(targetPosition)).isEqualToComparingFieldByFieldRecursively(Piece.createPiece(PieceUtils.Color.WHITE, PieceUtils.Type.PAWN));
    }

    @Test
    @DisplayName("move의 시작점이 blank이면 오류가 발생한다.")
    public void moveBlank() {
        //when
        //then
        assertThrows(IllegalArgumentException.class, () -> game.move("a4", "a5"));
    }

    @Test
    @DisplayName("퀸을 이동한다.")
    void moveQueen() {
        //given
        board.initializeEmpty();
        String source = "d3";
        String destination = "h7";
        board.replace(source, Queen.createBlackQueen());

        //when
        game.move(source, destination);

        //then
        assertThat(board.findPiece(source)).isEqualToComparingFieldByFieldRecursively(Blank.createBlank());
        assertThat(board.findPiece(destination)).isEqualToComparingFieldByFieldRecursively(Queen.createBlackQueen());
    }

    @Test
    @DisplayName("검정 폰을 이동한다.")
    void moveBlackPawn() {
        //given
        board.initializeEmpty();
        String source = "b7";
        String destination = "b5";
        board.replace(source, Pawn.createBlackPawn());

        //when
        game.move(source, destination);

        //then
        assertThat(board.findPiece(source)).isEqualToComparingFieldByFieldRecursively(Blank.createBlank());
        assertThat(board.findPiece(destination)).isEqualToComparingFieldByFieldRecursively(Pawn.createBlackPawn());
    }

    @Test
    @DisplayName("흰 폰을 이동한다.")
    void moveWhitePawn() {
        //given
        board.initializeEmpty();
        String source = "b6";
        String destination = "b7";
        board.replace(source, Pawn.createWhitePawn());

        //when
        game.move(source, destination);

        //then
        assertThat(board.findPiece(source)).isEqualToComparingFieldByFieldRecursively(Blank.createBlank());
        assertThat(board.findPiece(destination)).isEqualToComparingFieldByFieldRecursively(Pawn.createWhitePawn());
    }

    @Test
    @DisplayName("나이트를 이동한다.")
    void moveNight() {
        //given
        board.initializeEmpty();
        String source = "c3";
        String destination = "d5";
        board.replace(source, Knight.createWhiteKnight());

        //when
        game.move(source, destination);

        //then
        assertThat(board.findPiece(source)).isEqualToComparingFieldByFieldRecursively(Blank.createBlank());
        assertThat(board.findPiece(destination)).isEqualToComparingFieldByFieldRecursively(Knight.createWhiteKnight());
    }

    @Test
    @DisplayName("폰은 앞으로 이동하면서 기물을 잡을 수 없다.")
    void invalidPawnCatchForward() {
        //given
        board.initializeEmpty();
        String source = "c2";
        String destination = "c3";
        board.replace(source, Pawn.createWhitePawn());
        board.replace(destination, Pawn.createBlackPawn());

        //when, then
        assertThrows(IllegalArgumentException.class, () -> game.move(source, destination));
    }

    @Test
    @DisplayName("폰은 대각선으로 이동하면서 기물을 잡을 수 있다.")
    void pawnCatchDiagonal() {
        //given
        board.initializeEmpty();
        String source = "c3";
        String destination = "d4";
        board.replace(source, Pawn.createWhitePawn());
        board.replace(destination, King.createBlackKing());

        //when
        game.move(source, destination);

        //then
        assertThat(board.findPiece(source)).isEqualToComparingFieldByFieldRecursively(Blank.createBlank());
        assertThat(board.findPiece(destination)).isEqualToComparingFieldByFieldRecursively(Pawn.createWhitePawn());
    }

    @Test
    @DisplayName("룩 이동 경로 중간에 다른 기물이 있으면 이동할 수 없다.")
    void invalidRookMeetOtherInTheMiddle() {
        //given
        board.initializeEmpty();
        String source = "d3";
        String middle = "f3";
        String destination = "h3";
        board.replace(source, Rook.createWhiteRook());
        board.replace(middle, Rook.createBlackRook());

        //when, then
        assertThrows(IllegalArgumentException.class, () -> game.move(source, destination));
    }

    @Test
    @DisplayName("같은 편의 기물이 있는 위치로 이동할 수 없다.")
    void cannotMoveSameColor() {
        //given
        board.initializeEmpty();
        String source = "d3";
        String destination = "e2";
        board.replace(source, King.createBlackKing());
        board.replace(destination, Bishop.createBlackBishop());

        //when, then
        assertThrows(IllegalArgumentException.class, () -> game.move(source, destination));
    }

    @Test
    @DisplayName("첫 턴에 흰 기물, 둘째 턴에 검정 기물을 움직일 수 있다.")
    void moveWhite() {
        //given
        String whitePos = "a1";
        String blackPos = "a8";

        //when
        game.checkTurn(whitePos);
        game.checkTurn(blackPos);
    }

    @Test
    @DisplayName("첫 턴에 검정 기물을 움직이면 예외가 발생한다.")
    void invalidMoveBlack() {
        //given
        String pos = "a7";

        //when
        assertThrows(IllegalArgumentException.class, () -> game.checkTurn(pos));
    }
}
