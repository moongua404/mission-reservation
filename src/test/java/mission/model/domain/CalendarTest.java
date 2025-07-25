package mission.model.domain;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDateTime;
import mission.application.domain.exception.ReservationConflictException;
import mission.application.domain.model.Calendar;
import mission.application.domain.model.Reservation;
import org.junit.jupiter.api.Test;

public class CalendarTest {
    @Test
    public void normal() {
        Calendar calendar = new Calendar();
        calendar.putReservation(new Reservation(
                LocalDateTime.parse("2025-07-20T10:00"),
                LocalDateTime.parse("2025-07-28T09:00"),
                LocalDateTime.parse("2025-07-28T12:00"),
                "A"
        ));
        calendar.putReservation(new Reservation(
                LocalDateTime.parse("2025-07-20T10:00"),
                LocalDateTime.parse("2025-07-28T13:00"),
                LocalDateTime.parse("2025-07-28T14:00"),
                "A"
        ));
    }

    @Test
    public void WhenTrappedBetween() {
        assertThrows(ReservationConflictException.class, () -> {
            Calendar calendar = new Calendar();
            calendar.putReservation(new Reservation(
                    LocalDateTime.parse("2025-07-20T10:00"),
                    LocalDateTime.parse("2025-07-28T09:00"),
                    LocalDateTime.parse("2025-07-28T12:00"),
                    "A"
            ));

            calendar.putReservation(new Reservation(
                    LocalDateTime.parse("2025-07-20T10:00"),
                    LocalDateTime.parse("2025-07-28T10:00"),
                    LocalDateTime.parse("2025-07-28T11:00"),
                    "A"
            ));
        });
    }

    @Test
    public void WhenOverlap1() {
        assertThrows(ReservationConflictException.class, () -> {
            Calendar calendar = new Calendar();
            calendar.putReservation(new Reservation(
                    LocalDateTime.parse("2025-07-20T10:00"),
                    LocalDateTime.parse("2025-07-28T09:00"),
                    LocalDateTime.parse("2025-07-28T12:00"),
                    "A"
            ));

            calendar.putReservation(new Reservation(
                    LocalDateTime.parse("2025-07-20T10:00"),
                    LocalDateTime.parse("2025-07-28T10:00"),
                    LocalDateTime.parse("2025-07-28T13:00"),
                    "A"
            ));
        });
    }

    @Test
    public void WhenOverlap2() {
        assertThrows(ReservationConflictException.class, () -> {
            Calendar calendar = new Calendar();
            calendar.putReservation(new Reservation(
                    LocalDateTime.parse("2025-07-20T10:00"),
                    LocalDateTime.parse("2025-07-28T09:00"),
                    LocalDateTime.parse("2025-07-28T12:00"),
                    "A"
            ));

            calendar.putReservation(new Reservation(
                    LocalDateTime.parse("2025-07-20T10:00"),
                    LocalDateTime.parse("2025-07-28T08:00"),
                    LocalDateTime.parse("2025-07-28T11:00"),
                    "A"
            ));
        });
    }
}
