package mission.application.domain.model;

import java.util.ArrayList;
import java.util.List;

public class Calendar {
    List<Reservation> reservations;

    public Calendar(){
        this.reservations = new ArrayList<>();
    }

    public void putReservation(Reservation reservation) {
        this.reservations.add(reservation);
    }

    private boolean overlaps(Reservation existingReservation, Reservation newReservation) {
        if(newReservation.getEndAt().isAfter(existingReservation.getStartAt()) && newReservation.getEndAt().isBefore(existingReservation.getEndAt())) {
            return true;
        }
        if(newReservation.getStartAt().isAfter(existingReservation.getStartAt()) && newReservation.getStartAt().isBefore(existingReservation.getEndAt())) {
            return true;
        }
        return false;
    }
}
