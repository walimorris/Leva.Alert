package com.morris.Models.Impl;

import com.morris.Models.MessageProperty;
import java.util.Date;

public class MessagePropertyImpl implements MessageProperty {
    public MessagePropertyImpl() { }

    @Override
    public String currentDate() {
        Date currentDate = java.util.Calendar.getInstance().getTime();
        return currentDate.toString().substring(0, 10);
    }

    @Override
    public String currentTime() {
        String currentTime = java.time.LocalDateTime.now().toString();
        return convertFromMilitaryTime(currentTime.substring(11, 19));
    }

    /**
     * Parses time from {@link java.util.Date} to standard time format.
     * @param currentTime : current time from {@link java.util.Date}
     * @return {@link String}
     */
    private String convertFromMilitaryTime(String currentTime) {
        String timeOfDay;
        String time = currentTime.substring(2);
        if (Character.getNumericValue(currentTime.charAt(0)) < 2 ) {
            timeOfDay = "AM";
        } else {
            timeOfDay = "PM";
        }
        String subtime = currentTime.substring(0, 2);
        switch (subtime) {
            case "00" :
            case "12" :
                time = "12" + time + " " + timeOfDay;
                break;
            case "01" :
            case "13" :
                time = "1" + time + " " + timeOfDay;
                break;
            case "02" :
            case "14" :
                time = "2" + time + " " + timeOfDay;
                break;
            case "03" :
            case "15" :
                time = "3" + time + " " + timeOfDay;
                break;
            case "04" :
            case "16" :
                time = "4" + time + " " + timeOfDay;
                break;
            case "05" :
            case "17" :
                time = "5" + time + " " + timeOfDay;
                break;
            case "06" :
            case "18" :
                time = "6" + time + " " + timeOfDay;
                break;
            case "07" :
            case "19" :
                time = "7" + time + " " + timeOfDay;
                break;
            case "08" :
            case "20" :
                time = "8" + time + " " + timeOfDay;
                break;
            case "09" :
            case "21" :
                time = "9" + time + " " + timeOfDay;
                break;
            case "10" :
            case "22" :
                time = "10" + time + " " + timeOfDay;
                break;
            default :
                time = "11" + time + " " + timeOfDay;
                break;
        }
        return time;
    }
}
