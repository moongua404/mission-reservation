package mission.application.port.inport;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface Input {
    LocalDate getDate();
    String getName();
}
