package com.morris.servlets;

import com.morris.Constants;
import static spark.Spark.get;

/**
 * Initiates SMS Web Services for Leva Alert.
 *
 * @author Wali Morris<walimmorris@gmail.com>
 */
public class InitSMSServlet {
    public void initSMSService() {
        get("/", (request, response) -> Constants.GET_REQUEST_TEXT);
    }
}
