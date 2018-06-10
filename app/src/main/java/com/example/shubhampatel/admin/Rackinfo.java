package com.example.shubhampatel.admin;

class Rackinfo {

    String rackid;
    String coordinate;

    Rackinfo(){}

    public String getRackid() {
        return rackid;
    }

    public String getCoordinate() {
        return coordinate;
    }

    public Rackinfo(String rackid, String coordinate) {
        this.coordinate = coordinate;
        this.rackid = rackid;
    }
}
