package com.example.stang.logproject.data;

import org.parceler.Parcel;
import org.parceler.ParcelConstructor;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by Stang on 5/31/2017.
 */
@Parcel
public class Day implements Serializable {

    ArrayList<Log> logList ;
    String date;

    @ParcelConstructor
    public Day ( ){

        DateFormat df = new SimpleDateFormat("EEE, MMM d, ''yy");
        date = df.format(Calendar.getInstance().getTime());
        logList = new ArrayList<Log>();

    }

    public String toString(){return date;}

    public void addLog(Log e){logList.add(e);}

    public ArrayList<Log> getLogList(){return logList;}

}
