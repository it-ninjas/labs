package testing;

import java.time.LocalDateTime;

public class Mover {
    private LocalDateTime lastMovingTime;
    private Direction lastDirection;

    public void move(Direction direction) {
        if (Direction.getOpposite(direction) != this.lastDirection) {
            this.lastDirection = direction;
            this.lastMovingTime = LocalDateTime.now();
        }
    }

    public LocalDateTime getLastMovingTime() {
        return lastMovingTime;
    }

    public Direction getLastDirection() {
        return lastDirection;
    }

}

