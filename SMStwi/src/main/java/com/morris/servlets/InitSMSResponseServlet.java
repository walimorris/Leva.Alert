package com.morris.servlets;

import com.morris.Constants;
import com.morris.Models.Impl.HistoryLessonSMSImpl;
import com.twilio.twiml.MessagingResponse;
import com.twilio.twiml.messaging.Body;
import com.twilio.twiml.messaging.Message;

import static spark.Spark.post;

/**
 * The SMS Response Servlet receives post requests from user SMS messages to Leva Alert Web server.
 * {@link InitSMSResponseServlet} looks for the body request parameter, which value holds the user
 * SMS selection. See {@link com.morris.SelectionConstants} to update selection options as well as
 * view each selection value. This selection is read and matched, a SMS response is sent back to
 * the user based on selection value.
 *
 * @author Wali Morris<walimmorris@gmail.com>
 */
public class InitSMSResponseServlet {
    public static final String HISTORY = "History";
    public static final String USD_TO_BGN = "usd to bgn";

    public void InitSMSResponseService() {
        post("/", (request, response) -> {
            StringBuilder message = new StringBuilder();
            StringBuilder messageType = new StringBuilder();
            MessagingResponse twiml = null; 
            String param = request.queryParams(Constants.REQUEST_BODY_QUERY_PARAM);
            switch ( param ) {
                case HISTORY:
                    HistoryLessonSMSImpl historyLessonSMS = new HistoryLessonSMSImpl();
                    message.append(historyLessonSMS.viewHistory());
                    messageType.append(Constants.TYPE_SMS); 
                    break;

                case USD_TO_BGN:
                    USDToBGNServlet usdToBGNServlet = new USDToBGNServlet(Constants.USD_TO_BGN_GOOGLE_FINANCE);
                    message.append(usdToBGNServlet.doGet());
                    messageType.append(Constants.TYPE_SMS);
                    break;
            }
            if (messageType.toString().equals(Constants.TYPE_SMS)) {
                twiml = buildSMS(message);
            }
            response.type("application/xml");
            assert twiml != null;
            return twiml.toXml();
        });
    }

    /**
     * Builds SMS message type.
     * @param message : message request from user.
     * @return {@link MessagingResponse}
     */
    private MessagingResponse buildSMS(StringBuilder message) {
        Body messageBody = new Body.Builder(message.toString()).build();
        Message sms = new Message.Builder().body(messageBody).build();
        return new MessagingResponse.Builder().message(sms).build();
    }
}
