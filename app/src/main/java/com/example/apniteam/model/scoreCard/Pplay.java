
package com.example.apniteam.model.scoreCard;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Pplay {

    @SerializedName("from")
    private String mFrom;
    @SerializedName("runs")
    private String mRuns;
    @SerializedName("to")
    private String mTo;
    @SerializedName("type")
    private String mType;
    @SerializedName("Wickets")
    private String mWickets;

    public String getFrom() {
        return mFrom;
    }

    public void setFrom(String from) {
        mFrom = from;
    }

    public String getRuns() {
        return mRuns;
    }

    public void setRuns(String runs) {
        mRuns = runs;
    }

    public String getTo() {
        return mTo;
    }

    public void setTo(String to) {
        mTo = to;
    }

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }

    public String getWickets() {
        return mWickets;
    }

    public void setWickets(String wickets) {
        mWickets = wickets;
    }

}
