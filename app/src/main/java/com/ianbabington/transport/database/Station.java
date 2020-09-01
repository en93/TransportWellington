package com.ianbabington.transport.database;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class Station extends RealmObject {

    @PrimaryKey
    private int stationID;
    @Required
    private String stationNumber;
    @Required
    private String stationName;

    public Station() { }

    public Station(int id, String number, String name){
        stationID = id;
        stationNumber = number;
        stationName = name;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public int getStationID() {
        return stationID;
    }

    public void setStationID(int stationID) {
        this.stationID = stationID;
    }

    public String getStationNumber() {
        return stationNumber;
    }

    public void setStationNumber(String stationNumber) {
        this.stationNumber = stationNumber;
    }

}
