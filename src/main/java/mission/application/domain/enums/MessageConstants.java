package mission.application.domain.enums;

public enum MessageConstants {
    MENU("원하시는 기능을 선택해주세요.[예약하기, 예약보기, 그만하기]"),
    RESERVATION_DATE("예약할 날짜를 입력해주세요. [2025-07-21]"),
    RESERVATION_TIME("예약할 시간 범위를 입력해주세요. [11:00 - 12:00]"),
    RESERVATION_NAME("예약자명을 입력해주세요"),
    RESERVATION_COMPLETE("예약되었습니다.");

    private final String message;

    MessageConstants(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
