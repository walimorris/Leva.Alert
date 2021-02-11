package com.morris.servlets;

import com.morris.Constants;
import com.morris.SelectionConstants;
import com.morris.Models.Impl.HistoryLessonSMSImpl;
import com.twilio.twiml.MessagingResponse;
import com.twilio.twiml.messaging.Body;
import com.twilio.twiml.messaging.Message;

import static spark.Spark.post;

public class InitSMSResponseServlet {
    public void InitSMSResponseService() {
        post("/", (request, response) -> {
            StringBuilder message = new StringBuilder();
            String param = request.queryParams(Constants.REQUEST_BODY_QUERY_PARAM);
            switch (param) {
                case SelectionConstants.HISTORY:
                    HistoryLessonSMSImpl historyLessonSMS = new HistoryLessonSMSImpl();
                    message.append(historyLessonSMS.viewHistory());
                    break;
                case SelectionConstants.USD_TO_BGN:
                    USDToBGNServlet usdToBGN = new USDToBGNServlet();
                    message.append(usdToBGN.doGet());
                    break;
            }
            response.type("application/xml");
            return buildTwiSMSMessage(message).toXml();
        });
    }

    private MessagingResponse buildTwiSMSMessage(StringBuilder message) {
        Body messageBody = new Body.Builder(message.toString()).build();
        Message sms = new Message.Builder().body(messageBody).build();
        return new MessagingResponse.Builder().message(sms).build();
    }
}
