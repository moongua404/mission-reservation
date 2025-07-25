package mission.application.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import mission.application.domain.dto.DurationDto;
import mission.application.domain.enums.Menu;
import mission.application.domain.enums.MessageConstants;
import mission.application.domain.model.Calendar;
import mission.application.domain.model.Reservation;
import mission.application.port.inport.Input;
import mission.application.port.outport.Logger;

public class ReservationService {
    private final Input input;
    private final Logger logger;
    private final Calendar calendar;

    public ReservationService(Input input, Logger logger) {
        this.input = input;
        this.logger = logger;
        this.calendar = new Calendar();
    }

    public void run() {
        while (true) {
            try {
                logger.log(MessageConstants.MENU);
                Menu menu = input.getMenu();
                if (menu == Menu.TERMINATE) {
                    break;
                }
                underTheHood(menu);
            } catch (Exception e) {
                logger.log(e.getMessage());
            }
        }
    }

    private void underTheHood(Menu menu) {
        if (menu == Menu.RESERVE) {
            logger.log(MessageConstants.RESERVATION_DATE);
            LocalDate date = input.getDate();
            logger.log(MessageConstants.RESERVATION_TIME);
            DurationDto duration = input.getDuration();
            logger.log(MessageConstants.RESERVATION_NAME);
            String name = input.getName();

            calendar.putReservation(new Reservation(
                    LocalDateTime.now(),
                    date.atTime(duration.getStart()),
                    date.atTime(duration.getEnd()),
                    name
            ));

            logger.log(MessageConstants.RESERVATION_COMPLETE);
            return;
        }

        if (menu == Menu.CHECK_STATUS) {
            logger.getCalendar(calendar.getReservations());
        }
    }
}
