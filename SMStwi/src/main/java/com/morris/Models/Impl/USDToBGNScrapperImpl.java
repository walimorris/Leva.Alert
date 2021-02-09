package com.morris.Models.Impl;

import com.morris.Constants;
import com.morris.Models.USDToBGNScrapper;

/**
 * Implementation class for {@link USDToBGNScrapper}
 *
 * @author Wali Morris<walimmorris@gmail.com>
 */
public class USDToBGNScrapperImpl implements USDToBGNScrapper {
    StringBuilder stringBuilder;
    String markup;
    String rate;

    public USDToBGNScrapperImpl(String markup) {
        this.markup = markup;
        this.stringBuilder = new StringBuilder();
    }

    @Override
    public double convertUSDBGNToDecimal() {
        if (rate == null) {
            return 0.0;
        }
        return Double.parseDouble(rate);
    }

    @Override
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
        rate = extendedMarkup.substring(extendedMarkupLength);
        return rate;
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
        while (contentMark < contentMarkEnd && contentMark < content.length()) {
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
