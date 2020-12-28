
package com.example.apniteam.model;


import com.google.gson.annotations.SerializedName;


@SuppressWarnings("unused")
public class Inning {

    @SerializedName("id")
    private String mId;
    @SerializedName("overs")
    private String mOvers;
    @SerializedName("score")
    private String mScore;
    @SerializedName("wkts")
    private String mWkts;

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getOvers() {
        return mOvers;
    }

    public void setOvers(String overs) {
        mOvers = overs;
    }

    public String getScore() {
        return mScore;
    }

    public void setScore(String score) {
        mScore = score;
    }

    public String getWkts() {
        return mWkts;
    }

    public void setWkts(String wkts) {
        mWkts = wkts;
    }

}
