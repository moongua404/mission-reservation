package mission;

import mission.adapter.inadapter.ReservationInput;
import mission.adapter.outadapter.ReservationOutput;
import mission.application.service.ReservationService;

public class Application {
    public static void main(String[] args) {
        //TODO: 미션 구현
        ReservationService reservationService = new ReservationService(
                new ReservationInput(),
                new ReservationOutput()
        );

        reservationService.run();
    }
}