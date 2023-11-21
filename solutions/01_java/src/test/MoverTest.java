import org.junit.jupiter.api.Test;
import testing.Direction;
import testing.Mover;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MoverTest {
    private final Mover mover = new Mover();

    @Test
    void move() {
        mover.move(Direction.EAST);
        assertEquals(Direction.EAST, mover.getLastDirection());
        LocalDateTime lastMove = mover.getLastMovingTime();
        mover.move(Direction.EAST);
        assertEquals(lastMove.truncatedTo(ChronoUnit.SECONDS), mover.getLastMovingTime().truncatedTo(ChronoUnit.SECONDS));

        mover.move(Direction.SOUTH);
        assertEquals(Direction.SOUTH, mover.getLastDirection());

        mover.move(Direction.WEST);
        assertEquals(Direction.WEST, mover.getLastDirection());

        mover.move(Direction.NORTH);
        assertEquals(Direction.NORTH, mover.getLastDirection());
    }
}