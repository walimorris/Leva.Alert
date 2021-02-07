package com.morris.Models;

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
