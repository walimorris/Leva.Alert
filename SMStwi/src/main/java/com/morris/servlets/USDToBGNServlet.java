package com.morris.servlets;

import com.morris.Constants;
import com.morris.Models.Impl.USDToBGNScrapperImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class USDToBGNServlet {
    String url;

    public USDToBGNServlet() {
        this.url = Constants.USD_TO_BGN_GOOGLE_FINANCE;
    }

    public String doGet() throws IOException {
        URL url = new URL(this.url);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Content-Type", "application/json");
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        USDToBGNScrapperImpl scrapper = new USDToBGNScrapperImpl(Constants.USD_TO_BGN_GOOGLE_MARKUP);
        String response = scrapper.getUSDBGNRate(content);
        in.close();
        connection.disconnect();
        return "USD to BGN Currency exchange rate = $" + response;
    }
}