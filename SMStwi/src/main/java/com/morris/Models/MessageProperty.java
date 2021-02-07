package com.morris.Models;

/**
 * Interface for {@link com.morris.Models.Impl.MessagePropertyImpl} that builds current Time and Date
 * properties for sent SMS, MMS messages.
 *
 * @author Wali Morris<walimmorris@gmail.com>
 */
public interface MessageProperty {

    /**
     * return current time parsed from military time format to standard format.
     * @return {@link String}
     */
    String currentTime();

    /**
     * return current date, in format DAY MON 00.
     * @return {@link String}
     */
    String currentDate();
}
