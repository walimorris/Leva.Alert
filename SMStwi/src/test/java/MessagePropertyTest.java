import com.morris.Models.Impl.MessagePropertyImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MessagePropertyTest {
    public static final int TIME_NUMBER_COLONS = 2;
    public static final String DATE_FORMAT = "DAY MON 00";

    @DisplayName("Get Current Time Test")
    @Test
    public void currentTimeTest() {
        MessagePropertyImpl messageProperty = new MessagePropertyImpl();
        String currentTime = messageProperty.currentTime();
        Assertions.assertNotNull(currentTime);
        int numberOfColons = 0;
        for (int i = 0; i < currentTime.length(); i++) {
            numberOfColons = currentTime.charAt(i) == ':' ? numberOfColons + 1 : numberOfColons;
        }
        Assertions.assertEquals(numberOfColons, TIME_NUMBER_COLONS);
    }

    @DisplayName("Get Current Date Test")
    @Test
    public void currentDateTest() {
        MessagePropertyImpl messageProperty = new MessagePropertyImpl();
        String currentDate = messageProperty.currentDate();
        Assertions.assertEquals(currentDate.length(), DATE_FORMAT.length());
    }
}
