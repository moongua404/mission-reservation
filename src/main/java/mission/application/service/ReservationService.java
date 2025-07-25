package mission.application.service;

import mission.application.domain.enums.Menu;
import mission.application.domain.enums.MessageConstants;
import mission.application.port.inport.Input;
import mission.application.port.outport.Logger;

public class ReservationService {
    private final Input input;
    private final Logger logger;

    public ReservationService(Input input, Logger logger) {
        this.input = input;
        this.logger = logger;
    }
    public void run(){
        while(true){
            logger.log(MessageConstants.MENU);
            Menu menu = input.getMenu();
            if(menu == Menu.TERMINATE){
                break;
            }
        }
    }

    private void underTheHood(Menu menu){
        if(menu == Menu.RESERVE){

        }
    }
}
