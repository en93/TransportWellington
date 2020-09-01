package com.ianbabington.transport.database;

import com.ianbabington.transport.TransportMode;

import java.util.Date;
import io.realm.annotations.Required;

public class Departure {

    @Required
    private int serviceID;
    @Required
    private String destination;
    @Required
    private boolean hasLowFloor;
    @Required
    private Date departure;
    //Should I change to unix timestamp??
    @Required
    private int secondsTillDeparture;
    private int minutesTillDeparture;
    @Required
    private TransportMode transportMode;

    public Departure(int serviceID, String destination, boolean hasLowFloor, Date departure, int secondsTillDeparture, TransportMode transportMode) {
        this.serviceID = serviceID;
        this.destination = destination;
        this.hasLowFloor = hasLowFloor;
        this.departure = departure;
        this.secondsTillDeparture = secondsTillDeparture;
        this.transportMode = transportMode;
    }


    public int getServiceID() {
        return serviceID;
    }

    public void setServiceID(int serviceID) {
        this.serviceID = serviceID;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public boolean isHasLowFloor() {
        return hasLowFloor;
    }

    public void setHasLowFloor(boolean hasLowFloor) {
        this.hasLowFloor = hasLowFloor;
    }

    public Date getDeparture() {
        return departure;
    }

    public void setDeparture(Date departure) {
        this.departure = departure;
    }

    public int getSecondsTillDeparture() {
        return secondsTillDeparture;
    }

    public void setSecondsTillDeparture(int secondsTillDeparture) {
        this.secondsTillDeparture = secondsTillDeparture;
    }

    public int getMinutesTillDeparture() {
        return minutesTillDeparture;
    }

    public void setMinutesTillDeparture(int minutesTillDeparture) {
        this.minutesTillDeparture = minutesTillDeparture;
    }

    public TransportMode getTransportMode() {
        return transportMode;
    }

    public void setTransportMode(TransportMode transportMode) {
        this.transportMode = transportMode;
    }




}
