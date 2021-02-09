package com.morris.sms;

import com.morris.servlets.InitSMSResponseServlet;
import com.morris.servlets.InitSMSServlet;
import com.twilio.Twilio;
import com.morris.Constants;

public class Main {
    public static final String ACCOUNT_SID = Constants.ACCOUNT_SID;
    public static final String AUTH_TOKEN = Constants.AUTH_TOKEN;

    public static void main(String[] args) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        new InitSMSServlet().initSMSService();
        new InitSMSResponseServlet().InitSMSResponseService();
    }
}