package com.morris.Models;

/**
 * Interface for {@link com.morris.Models.Impl.HistoryLessonSMSImpl} which provides historical
 * Bulgarian facts. Facts can be upgraded in {@link com.morris.SelectionConstants}. Be aware
 * this feature will continue to be upgraded, most likely providing multiple historical facts
 * that will be dynamically chosen for users.
 *
 * @author Wali Morris<walimmorris@gmail.com>
 */
public interface HistoryLessonSMS {

    String viewHistory();
}
