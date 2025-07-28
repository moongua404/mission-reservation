package mission;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import api.TestEnvironment;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

public class ApplicationTest extends TestEnvironment {
    @Test
    @Timeout(10)
    void testApplication() {
        run(List.of("예약하기", "2025-07-29", "11:00-12:00", "w","예약보기", "그만하기"));
        assertTrue(output().contains("|2025-07-29 11:00\t|2025-07-29 12:00\t|w         |"));
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}