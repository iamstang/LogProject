package com.example.stang.logproject.data;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Stang on 5/31/2017.
 */

public class Log implements Serializable {

    String string ;
    String time;

    public Log (String s){

        DateFormat df = new SimpleDateFormat("HH:mm");
        time = df.format(Calendar.getInstance().getTime());
        string = s;
    }

    public void setString(String s){
        string = s;
    }

    public String toString(){
        return string + "\n                                                                        " + time;
    }

    public String getTime(){
        return time;
    }
}
