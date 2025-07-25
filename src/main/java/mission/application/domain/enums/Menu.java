package mission.application.domain.enums;

import java.util.Arrays;

public enum Menu {
    RESERVE("예약하기"), CHECK_STATUS("예약보기");
    private final String input;
    Menu(String input) {
        this.input = input;
    }
    public static Menu parse(String input) {
        return Arrays.stream(Menu.values())
                .filter(item -> item.input.equals(input))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }
}

