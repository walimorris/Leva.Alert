import com.morris.Constants;
import com.morris.Models.Impl.USDToBGNScrapperImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class USDToBGNScrapperTest {
    public final static String MARKUP = Constants.USD_TO_BGN_GOOGLE_MARKUP;
    public final static String CONTENT = "test text" + Constants.USD_TO_BGN_GOOGLE_MARKUP + ">1.234";
    public final static String RATE = "1.234";
    public final static double RATE_AS_DECIMAL = 1.234;

    @DisplayName("USD To BGN rate Test Case")
    @Test
    void testGetUSDBGNRate() {
        USDToBGNScrapperImpl usdToBGNScrapperTest = new USDToBGNScrapperImpl(MARKUP);
        StringBuffer content = new StringBuffer();
        content.append(CONTENT);
        String rate = usdToBGNScrapperTest.getUSDBGNRate(content);
        Assertions.assertEquals(rate, RATE);
    }

    @DisplayName("Convert USD to BGN rate to Decimal Test Case 1")
    @Test
    void testConvertUSDBGNToDecimal() {
        USDToBGNScrapperImpl usdToBGNScrapperTest = new USDToBGNScrapperImpl(MARKUP);
        StringBuffer content = new StringBuffer();
        content.append(CONTENT);
        String rate = usdToBGNScrapperTest.getUSDBGNRate(content);
        Assertions.assertEquals(rate, RATE);
        double rateInDecimal = usdToBGNScrapperTest.convertUSDBGNToDecimal();
        Assertions.assertEquals(rateInDecimal, RATE_AS_DECIMAL);
    }

    @DisplayName("Convert USD to BGN rate to Decimal Test Case 2")
    @Test
    void testConvertUSDBGNToDecimal2() {
        USDToBGNScrapperImpl usdToBGNScrapperTest = new USDToBGNScrapperImpl(MARKUP);
        double rateInDecimal = usdToBGNScrapperTest.convertUSDBGNToDecimal();
        Assertions.assertEquals(0.0, rateInDecimal);
    }
}
