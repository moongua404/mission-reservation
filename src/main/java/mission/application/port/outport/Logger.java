package mission.application.port.outport;

import java.util.List;
import mission.application.domain.model.Reservation;

public interface Logger {
    void log(String message);
    void getCalendar(List<Reservation> reservations);
}
