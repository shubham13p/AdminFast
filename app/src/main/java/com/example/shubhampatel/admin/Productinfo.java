package com.example.shubhampatel.admin;

class Productinfo {

    String pid;
    String pname;
    String rid;
    String partid;
    String ptid;
    String longi;
    String lati;

    public String getLongi() {        return longi;    }

    public String getLati() {        return lati;    }

    public Productinfo() {
    }

    public String getPid() {
        return pid;
    }

    public String getPname() {
        return pname;
    }

    public String getRid() {
        return rid;
    }

    public String getPartid() {
        return partid;
    }

    public String getPtid() {
        return ptid;
    }

    public Productinfo(String pid, String pname, String rid, String partid, String ptid, String longi, String lati) {
        this.pid = pid;
        this.pname = pname;
        this.rid = rid;
        this.partid = partid;
        this.ptid = ptid;
        this.longi = longi;
        this.lati = lati;
    }
}
