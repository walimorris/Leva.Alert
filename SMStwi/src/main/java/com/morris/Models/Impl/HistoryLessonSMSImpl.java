package com.morris.Models.Impl;

import com.morris.Models.HistoryLessonSMS;
import com.morris.SelectionConstants;

/**
 * Implementation class for {@link HistoryLessonSMS}
 *
 * @author Wali Morris<walimmorris@gmail.com>
 */
public class HistoryLessonSMSImpl implements HistoryLessonSMS {

    @Override
    public String viewHistory() {
        return SelectionConstants.HISTORY_LESSON;
    }
}
