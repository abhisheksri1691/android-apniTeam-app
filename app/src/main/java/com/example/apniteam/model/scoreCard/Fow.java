
package com.example.apniteam.model.scoreCard;

import com.google.gson.annotations.SerializedName;


@SuppressWarnings("unused")
public class Fow {

    @SerializedName("id")
    private String mId;
    @SerializedName("over")
    private String mOver;
    @SerializedName("score")
    private String mScore;
    @SerializedName("wkt_nbr")
    private String mWktNbr;

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getOver() {
        return mOver;
    }

    public void setOver(String over) {
        mOver = over;
    }

    public String getScore() {
        return mScore;
    }

    public void setScore(String score) {
        mScore = score;
    }

    public String getWktNbr() {
        return mWktNbr;
    }

    public void setWktNbr(String wktNbr) {
        mWktNbr = wktNbr;
    }

}
