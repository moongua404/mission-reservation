package mission.application.domain.dto;

import java.time.LocalTime;

public class DurationDto {
    LocalTime start;
    LocalTime end;

    public DurationDto(LocalTime start, LocalTime end) {
        this.start = start;
        this.end = end;
    }
}
