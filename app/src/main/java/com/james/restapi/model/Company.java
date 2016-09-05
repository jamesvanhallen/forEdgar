package com.james.restapi.model;

import com.google.gson.annotations.SerializedName;

public class Company {

    String inn;

    @SerializedName("shortName")
    String mShortName;

    String address;

    String okvedId;

    Company(){

    }

    public String getAddress() {
        return address;
    }

    public String getInn() {
        return inn;
    }

    public String getOkvedId() {
        return okvedId;
    }

    public String getShortName() {
        return mShortName;
    }
}
