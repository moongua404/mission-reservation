package mission.application.domain.model;

import java.time.LocalDateTime;
import mission.application.domain.exception.ReservationTimeException;

public class Reservation {
    private LocalDateTime reservationTime;
    private LocalDateTime startAt;
    private LocalDateTime endAt;
    private String name;

    public Reservation(LocalDateTime reservationTime, LocalDateTime startAt, LocalDateTime endAt, String name) {
        if (reservationTime.isAfter(startAt) || startAt.isAfter(endAt)) {
            throw new ReservationTimeException("예약 시간을 확인해주세요!!");
        }
        this.reservationTime = reservationTime;
        this.startAt = startAt;
        this.endAt = endAt;
        this.name = name;
    }

    public LocalDateTime getReservationTime() {
        return reservationTime;
    }

    public LocalDateTime getStartAt() {
        return startAt;
    }

    public LocalDateTime getEndAt() {
        return endAt;
    }

    public String getName() {
        return name;
    }
}
