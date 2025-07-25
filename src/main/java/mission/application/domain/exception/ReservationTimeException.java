package mission.application.domain.exception;

public class ReservationTimeException extends RuntimeException {
    public ReservationTimeException(String message) {
        super(message);
    }
}
