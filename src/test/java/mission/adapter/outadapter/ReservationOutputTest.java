package mission.adapter.outadapter;

import java.time.LocalDateTime;
import java.util.List;
import mission.application.domain.model.Reservation;
import org.junit.jupiter.api.Test;

public class ReservationOutputTest {
    @Test
    void getCalendarTest() {
        ReservationOutput reservationOutput = new ReservationOutput();
        reservationOutput.getCalendar(List.of(
                new Reservation(
                        LocalDateTime.parse("2025-07-21T11:00"),
                        LocalDateTime.parse("2025-07-28T11:00"),
                        LocalDateTime.parse("2025-07-28T13:00"),
                        "박호건"
                )
        ));
    }
}
