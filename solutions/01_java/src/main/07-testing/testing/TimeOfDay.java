package testing;

import java.time.LocalDateTime;

public class TimeOfDay {
    public String getTimeOfDay(LocalDateTime time) {
        if (time.getHour() < 6) {
            return "Night";
        }
        if (time.getHour() < 12) {
            return "Morning";
        }
        if (time.getHour() < 18) {
            return "Afternoon";
        }
        return "Evening";
    }
}