package softeer2nd.chess.util;

import softeer2nd.chess.Position;

import java.util.Arrays;
import java.util.List;

public enum Direction {
    NORTH(0, -1),
    NORTHEAST(1, -1),
    EAST(1, 0),
    SOUTHEAST(1, 1),
    SOUTH(0, 1),
    SOUTHWEST(-1, 1),
    WEST(-1, 0),
    NORTHWEST(-1, -1),

    NNE(1, -2),
    NNW(-1, -2),
    SSE(1, 2),
    SSW(-1, 2),
    EEN(2, -1),
    EES(2, 1),
    WWN(-2, -1),
    WWS(-2, 1);

    private int xDegree;
    private int yDegree;

    private Direction(int xDegree, int yDegree) {
        this.xDegree = xDegree;
        this.yDegree = yDegree;
    }

    public int getXDegree() {
        return xDegree;
    }

    public int getYDegree() {
        return yDegree;
    }

    public static List<Direction> linearDirection() {
        return Arrays.asList(NORTH, EAST, SOUTH, WEST);
    }

    public static List<Direction> diagonalDirection() {
        return Arrays.asList(NORTHEAST, SOUTHEAST, SOUTHWEST, NORTHWEST);
    }

    public static List<Direction> everyDirection() {
        return Arrays.asList(NORTH, EAST, SOUTH, WEST, NORTHEAST, SOUTHEAST, SOUTHWEST, NORTHWEST);
    }

    public static List<Direction> knightDirection() {
        return Arrays.asList(NNE, NNW, SSE, SSW, EEN, EES, WWN, WWS);
    }

    public static List<Direction> whitePawnDirection() {
        return Arrays.asList(NORTH, NORTHEAST, NORTHWEST);
    }

    public static List<Direction> blackPawnDirection() {
        return Arrays.asList(SOUTH, SOUTHEAST, SOUTHWEST);
    }

    public static Direction getDirection(Position source, Position target) {
        int xDist = target.getX() - source.getX();
        int yDist = target.getY() - source.getY();

        Direction exactMatch = Arrays.stream(Direction.values())
                .filter(direction -> direction.xDegree == xDist && direction.yDegree == yDist)
                .findFirst()
                .orElseGet(() -> {
                    int xSign = Integer.signum(xDist);
                    int ySign = Integer.signum(yDist);
                    if ((xDist == 0 && yDist != 0) || (xDist != 0 && yDist == 0) || (Math.abs(xDist) == Math.abs(yDist))) {
                        return Arrays.stream(Direction.values())
                                .filter(direction -> direction.xDegree == xSign && direction.yDegree == ySign)
                                .findFirst()
                                .orElse(null);
                    }
                    return null;
                });

        if (exactMatch == null) {
            throw new IllegalArgumentException("올바르지 않은 방향입니다.");
        }

        return exactMatch;
    }
}
