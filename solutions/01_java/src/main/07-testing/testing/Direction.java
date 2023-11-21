package testing;

public enum Direction {
    NORTH,
    EAST,
    SOUTH,
    WEST;

    public static Direction getOpposite(Direction direction) {
        switch (direction) {
            case NORTH -> {
                return SOUTH;
            }
            case EAST -> {
                return WEST;
            }
            case SOUTH -> {
                return NORTH;
            }
            case WEST -> {
                return EAST;
            }
        }
        return null;
    }
}
