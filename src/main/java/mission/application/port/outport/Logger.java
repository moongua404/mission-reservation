package mission.application.port.outport;

import java.util.List;
import mission.application.domain.enums.MessageConstants;
import mission.application.domain.model.Reservation;

public interface Logger {
    void log(MessageConstants message);

    void getCalendar(List<Reservation> reservations);
}
