package mission.application.port.inport;

import java.time.LocalDate;
import mission.application.domain.dto.DurationDto;
import mission.application.domain.enums.Menu;

public interface Input {
    LocalDate getDate();
    DurationDto getDuration();
    String getName();
    Menu getMenu();
}
