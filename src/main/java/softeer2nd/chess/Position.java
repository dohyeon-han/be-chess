package softeer2nd.chess;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Position {
    private int y;
    private int x;

    public Position(String pos) {
        List<Integer> validPositions = getValidPositions(pos);
        this.x = validPositions.get(0);
        this.y = validPositions.get(1);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    private List<Integer> getValidPositions(String pos) {
        if (pos.length() != 2) {
            throw new IllegalArgumentException("위치값의 길이는 2입니다.");
        }
        char column = pos.charAt(0);
        char row = pos.charAt(1);

        if (column < 'a' || column > 'h') {
            throw new IllegalArgumentException("열 값은 a~h입니다.");
        }
        if (row < '1' || row > '8') {
            throw new IllegalArgumentException("열 값은 1~8입니다.");
        }
        return new ArrayList<>(Arrays.asList(column - 'a', 7 - (row - '1')));
    }
}
