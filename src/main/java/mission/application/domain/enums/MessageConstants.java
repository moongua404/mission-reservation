package mission.application.domain.enums;

public enum MessageConstants {
    MENU("원하시는 기능을 선택해주세요.[예약하기, 예약보기, 그만하기]"), RESERVATION_DATE("예약할 날짜를 입력해주세요.");
    private final String message;
    MessageConstants(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
}
