/**
 * @author Wali Morris
 */
package com.morris.Models;

import com.morris.Constants;

public class USDToBGNScrapper {
    StringBuilder stringBuilder;
    String markup;

    public USDToBGNScrapper(String markup) {
        this.markup = markup;
        this.stringBuilder = new StringBuilder();
    }

    /**
     * Gets United States Dollar to Bulgarian Leva exchange rate from content.
     * @param content : content from request
     * @return USD to BGN exchange rate
     */
    public String getUSDBGNRate(StringBuffer content) {
        String extendedMarkup = extendMarkupMatch(content);
        if (extendedMarkup == null) {
            return null;
        }
        int extendedMarkupLength = extendedMarkup.length();
        while (extendedMarkupLength > 0) {
            if (extendedMarkup.charAt(extendedMarkupLength - 1) == '>') {
                break;
            }
            extendedMarkupLength = extendedMarkupLength - 1;
        }
        return extendedMarkup.substring(extendedMarkupLength);
    }

    /**
     * Extends markup until the USD to BGN amount is found.
     * @param content : request content
     * @return String included full markup until dollar amount.
     */
    private String extendMarkupMatch(StringBuffer content) {
        int contentMark = scrapeMatch(content);
        if (contentMark == -1) {
            return null;
        }
        int contentMarkEnd = contentMark + Constants.USD_TO_BGN_MARKUP_EXTENSION_COUNT;
        while (contentMark < contentMarkEnd) {
            stringBuilder.append(content.charAt(contentMark));
            contentMark++;
        }
        return stringBuilder.toString();
    }

    /**
     * Takes a StringBuffer containing GET request markup content and scrapes for a match
     * containing exact markup.
     * @param content : {@link StringBuilder} content
     * @return String of exact match or null if none exists
     */
    private int scrapeMatch(StringBuffer content) {
        int contentMark = 0;
        int markupMark = 0;
        while (contentMark < content.length()) {
            if (markup.charAt(markupMark) == content.charAt(contentMark)) {
                stringBuilder.append(markup.charAt(markupMark));
                markupMark++;
            } else {
                if (stringBuilder.length() > 0 ) {
                    stringBuilder.setLength(0);
                    markupMark = 0;
                }
            }
            if (stringBuilder.toString().equals(markup)) {
                return contentMark;
            }
            contentMark++;
        }
        // reset stringBuilder, it does not match markup
        stringBuilder.setLength(0);
        return -1;
    }
}
