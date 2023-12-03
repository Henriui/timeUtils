import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.timeutil.TimeUtils;

public class Test {

    @ParameterizedTest(name = "{index} => time={0}, expected={1}")
    @CsvSource({
            "00:00:01, 1", // Sekuntti
            "00:01:00, 60", // Minuutti
            "01:00:00, 3600", // Tunti
            "00:01:01, 61", // Minuutti ja sekuntti
            "01:00:01, 3601", // Tunti ja sekuntti
            "01:01:00, 3660", // Tunti ja minuutti
            "01:01:01, 3661", // Tunti, minuutti ja sekuntti
            "23:59:59, 86399", // Suurin mahdollinen aika
            "00:00:00, 0", // Alaraja
            "01:00:00:00, 3600", // Kielletty arvo
    })
    public void testTimeToSec(String test, int expected) {
        assertEquals(expected, TimeUtils.timeToSec(test));
    }

    @ParameterizedTest(name = "{index} => test={0}, expected={1}")
    @CsvSource({
            "1, 0:00:01", // Sekuntti
            "60, 0:01:00", // Minuutti
            "3600, 1:00:00", // Tunti
            "61, 0:01:01", // Minuutti ja sekuntti
            "3601, 1:00:01", // Tunti ja sekuntti
            "3660, 1:01:00", // Tunti ja minuutti
            "3661, 1:01:01", // Tunti, minuutti ja sekuntti
            "0, 0:00:00", // Alaraja
            "86399, 23:59:59", // Max aika
            "-1, -1", // Kielletty arvo
            "86400, -1", // 23:59:59 max aika päivässä
    })
    public void testSecToTime(int test, String expected) {
        assertEquals(expected, TimeUtils.secToTime(test));
    }

}
