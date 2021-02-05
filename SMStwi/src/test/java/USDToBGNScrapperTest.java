import com.morris.Constants;
import com.morris.Models.USDToBGNScrapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class USDToBGNScrapperTest {
    public final static String MARKUP = Constants.USD_TO_BGN_GOOGLE_MARKUP;
    public final static String CONTENT = "test text" + Constants.USD_TO_BGN_GOOGLE_MARKUP + ">1.234";

    @DisplayName("USDToBGNScrapper Test Case")
    @Test
    void testGetUSDBGNRate() {
        USDToBGNScrapper usdToBGNScrapperTest = new USDToBGNScrapper(MARKUP);
        StringBuffer content = new StringBuffer();
        content.append(CONTENT);
        String rate = usdToBGNScrapperTest.getUSDBGNRate(content);
        Assertions.assertEquals(rate, "1.234");
    }
}
