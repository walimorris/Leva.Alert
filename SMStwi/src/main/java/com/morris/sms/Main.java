package com.morris.sms;

import com.morris.servlets.USDToBGNServlet;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import java.io.IOException;
import java.net.URI;
import java.util.Collections;

import com.morris.Constants;

public class Main {
    public static final String ACCOUNT_SID = Constants.ACCOUNT_SID;
    public static final String AUTH_TOKEN = Constants.AUTH_TOKEN;

    public static void main(String[] args) throws IOException {
        USDToBGNServlet usdToBGNServlet = new USDToBGNServlet(Constants.USD_TO_BGN_GOOGLE_FINANCE);
        String usdToBGNRate = usdToBGNServlet.doGet();
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                new PhoneNumber(Constants.TO),
                new PhoneNumber(Constants.FROM),
                usdToBGNRate)
                .setMediaUrl(
                        Collections.singletonList(URI.create(Constants.BULGARIAN_NATIONAL_PRIDE)))
                .create();
        System.out.println(message.getSid());
    }
}