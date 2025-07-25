package mission.adapter.inadapter;

import api.Console;
import java.time.LocalDate;
import java.time.LocalTime;
import mission.application.domain.dto.DurationDto;
import mission.application.domain.enums.Menu;
import mission.application.domain.exception.InvalidFormatException;
import mission.application.port.inport.Input;

public class ReservationInput implements Input {
    public LocalDate getDate() {
        try {
            return LocalDate.parse(Console.readLine());
        } catch (Exception e) {
            throw new InvalidFormatException("입력 형식이 맞지 않습니다.");
        }
    }

    public DurationDto getDuration() {
        try {
            String response = Console.readLine();
            return new DurationDto(
                    LocalTime.parse(response.split("-")[0]),
                    LocalTime.parse(response.split("-")[1])
            );
        } catch (Exception e) {
            throw new InvalidFormatException("예약 시간을 확인해주세요.");
        }
    }

    public String getName() {
        return Console.readLine();
    }

    public Menu getMenu() {
        try {
            return Menu.parse(Console.readLine().toUpperCase());
        } catch (Exception e) {
            throw new InvalidFormatException("잘못된 응답입니다.");
        }
    }
}
