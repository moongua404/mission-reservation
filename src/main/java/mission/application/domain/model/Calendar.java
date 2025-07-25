package mission.application.domain.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import mission.application.domain.exception.ConflictPeriodException;
import mission.application.domain.exception.ReservationConflictException;

public class Calendar {
    List<Reservation> reservations;

    public Calendar() {
        this.reservations = new ArrayList<>();
    }

    public void putReservation(Reservation reservation) {
        if (reservation.getStartAt().isBefore(LocalDateTime.parse("2025-07-28T00:00"))
                && reservation.getEndAt().isBefore(LocalDateTime.parse("2025-08-04T00:00"))) {
            throw new ConflictPeriodException("유효한 범위가 아닙니다.");
        }

        if (reservations.stream().anyMatch(existing -> overlaps(existing, reservation))) {
            throw new ReservationConflictException("이미 예약된 시간입니다.");
        }

        reservations.add(reservation);
    }

    private boolean overlaps(Reservation existingReservation, Reservation newReservation) {
        if (newReservation.getEndAt().isAfter(existingReservation.getStartAt()) && newReservation.getEndAt()
                .isBefore(existingReservation.getEndAt())) {
            return true;
        }
        if (newReservation.getStartAt().isAfter(existingReservation.getStartAt()) && newReservation.getStartAt()
                .isBefore(existingReservation.getEndAt())) {
            return true;
        }
        return false;
    }

    public List<Reservation> getReservations() {
        return List.copyOf(reservations);
    }
}
