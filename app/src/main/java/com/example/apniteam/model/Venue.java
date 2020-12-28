
package com.example.apniteam.model;


import com.google.gson.annotations.SerializedName;


@SuppressWarnings("unused")
public class Venue {

    @SerializedName("lat")
    private String mLat;
    @SerializedName("location")
    private String mLocation;
    @SerializedName("long")
    private String mLong;
    @SerializedName("name")
    private String mName;
    @SerializedName("timezone")
    private String mTimezone;

    public String getLat() {
        return mLat;
    }

    public void setLat(String lat) {
        mLat = lat;
    }

    public String getLocation() {
        return mLocation;
    }

    public void setLocation(String location) {
        mLocation = location;
    }

    public String getLong() {
        return mLong;
    }

    public void setLong(String mmLong) {
        mLong = mmLong;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getTimezone() {
        return mTimezone;
    }

    public void setTimezone(String timezone) {
        mTimezone = timezone;
    }

}
