import org.junit.Test;
import testing.TimeOfDay;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TimeOfDayTest {
    private final TimeOfDay timeOfDay = new TimeOfDay();
    private final LocalDate fixDate = LocalDate.of(2023, 12, 1);

    @Test
    public void getTimeOfDayNight() {
        LocalDateTime night = LocalDateTime.of(fixDate, LocalTime.of(5, 0));
        String result = timeOfDay.getTimeOfDay(night);
        assertEquals("Night", result);
    }

    @Test
    public void getTimeOfDayMorning() {
        LocalDateTime night = LocalDateTime.of(fixDate, LocalTime.of(5, 0));
        LocalDateTime morning = LocalDateTime.of(fixDate, LocalTime.of(11, 0));
        LocalDateTime afternoon = LocalDateTime.of(fixDate, LocalTime.of(18, 0));
        String result = timeOfDay.getTimeOfDay(morning);
        assertEquals("Morning", result);
    }

    @Test
    public void getTimeOfDayAfternoon() {
        LocalDateTime afternoon = LocalDateTime.of(fixDate, LocalTime.of(17, 0));
        String result = timeOfDay.getTimeOfDay(afternoon);
        assertEquals("Afternoon", result);
    }

    @Test
    public void getTimeOfDayEvening() {
        LocalDateTime evening = LocalDateTime.of(fixDate, LocalTime.of(18, 0));
        String result = timeOfDay.getTimeOfDay(evening);
        assertEquals("Evening", result);
    }

}