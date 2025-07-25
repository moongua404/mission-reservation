package mission.adapter.outadapter;

import java.time.LocalDateTime;
import java.util.List;
import mission.application.domain.enums.MessageConstants;
import mission.application.domain.model.Reservation;
import mission.application.port.outport.Logger;

public class ReservationOutput implements Logger {
    public void log(MessageConstants message) {
        System.out.println(message.getMessage());
    }

    public void getCalendar(List<Reservation> reservations) {
        System.out.printf(""
                + "|예약 시간\t\t\t|시작 시간\t\t\t|종료 시간\t\t\t|예약자 명\t|\n"
                + "|-------------------|-------------------|-------------------|-----------|\n");
        reservations.forEach(reservation -> System.out.println(String.format("|%s\t|%s\t|%s\t|%s\t\t|",
                this.formatDate(reservation.getReservationTime()),
                this.formatDate(reservation.getStartAt()),
                this.formatDate(reservation.getEndAt()),
                reservation.getName())));
    }

    private String formatDate(LocalDateTime localDateTime) {
        return String.format("%04d-%02d-%02d %02d:%02d",
                localDateTime.getYear(), localDateTime.getMonthValue(), localDateTime.getDayOfMonth()
                , localDateTime.getHour(), localDateTime.getMinute());
    }
}
