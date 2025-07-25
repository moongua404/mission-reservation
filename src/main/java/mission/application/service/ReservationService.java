package mission.application.service;

import mission.application.port.inport.Input;
import mission.application.port.outport.Logger;

public class ReservationService {

    private final Input input;
    private final Logger logger;

    public ReservationService(Input input, Logger logger) {
        this.input = input;
        this.logger = logger;
    }
}
