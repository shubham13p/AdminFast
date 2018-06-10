package com.example.shubhampatel.admin;

public class ProductTypeinfo {

    String producttypeid;
    String producttypename;


    public String getProducttypeid() {
        return producttypeid;
    }

    public String getProducttypename() {
        return producttypename;
    }

    public ProductTypeinfo(String producttypeid, String producttypename) {
        this.producttypeid = producttypeid;
        this.producttypename = producttypename;
    }
}
