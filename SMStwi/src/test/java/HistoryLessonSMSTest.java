import com.morris.Models.Impl.HistoryLessonSMSImpl;
import com.morris.SelectionConstants;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HistoryLessonSMSTest {

    @DisplayName("View History Test")
    @Test
    public void viewHistoryTest() {
        HistoryLessonSMSImpl historyLesson = new HistoryLessonSMSImpl();
        Assertions.assertNotNull(historyLesson.viewHistory());
        Assertions.assertEquals(historyLesson.viewHistory(), SelectionConstants.HISTORY_LESSON);
    }
}
