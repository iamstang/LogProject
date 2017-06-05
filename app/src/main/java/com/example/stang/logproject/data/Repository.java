package com.example.stang.logproject.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Stang on 6/5/2017.
 */

public class Repository implements Serializable,Observer{

    ArrayList<Day> list = new ArrayList<Day>();

    public Repository(){
        list.add(new Day());


    }

    public ArrayList<Day> getList() { return list; }


    /**
     * This method is called whenever the observed object is changed. An
     * application calls an <tt>Observable</tt> object's
     * <code>notifyObservers</code> method to have all the object's
     * observers notified of the change.
     *
     * @param o   the observable object.
     * @param arg an argument passed to the <code>notifyObservers</code>
     */
    @Override
    public void update(Observable o, Object arg) {
        
    }
}
