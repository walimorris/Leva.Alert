package com.morris.Models;

/**
 * The USD to BGN Scrapper is a simplified scrapping tool that has one specific purpose; to scrape
 * the Google United States Dollar to Bulgarian Leva Finance page for the USD to BGN Leva conversion
 * rate. You can visit the exact website here: "https://www.google.com/finance/quote/USD-BGN". The
 * USD to BGN Scrapper uses the {@link com.morris.servlets.USDToBGNServlet} that receives a lengthy
 * {@link StringBuilder} content composed of the Google Finance's page markup and searches for an
 * exact class(MAwwx) which contains the conversion information we seek. Once this markup is matched
 * by the {@link USDToBGNScrapper} the search is extended to approximately 180 characters. The reason
 * for this extension: to find the exact conversion rate. Once this decimal is found, our scrapping
 * tool can then return the found rate. Follow the code in the implementation class here :
 * {@link com.morris.Models.Impl.USDToBGNScrapperImpl}.
 *
 * @author Wali Morris<walimmorris@gmail.com>
 */
public interface USDToBGNScrapper {

    /**
     * Gets United States Dollar to Bulgarian Leva exchange rate from content.
     * @param content : content from request in form {@link StringBuffer}
     * @return {@link String} USD to BGN exchange rate - ex: 1.6231
     */
    String getUSDBGNRate(StringBuffer content);

    /**
     * converts scrapped USD to BGN rate to decimal.
     * @return USD to BGN rate as {@link Double}
     */
    double convertUSDBGNToDecimal();
}
