
package com.example.apniteam.model.scoreCard;

import com.google.gson.annotations.SerializedName;


@SuppressWarnings("unused")
public class Extras {

    @SerializedName("b")
    private String mB;
    @SerializedName("lb")
    private String mLb;
    @SerializedName("nb")
    private String mNb;
    @SerializedName("p")
    private String mP;
    @SerializedName("t")
    private String mT;
    @SerializedName("wd")
    private String mWd;

    public String getB() {
        return mB;
    }

    public void setB(String b) {
        mB = b;
    }

    public String getLb() {
        return mLb;
    }

    public void setLb(String lb) {
        mLb = lb;
    }

    public String getNb() {
        return mNb;
    }

    public void setNb(String nb) {
        mNb = nb;
    }

    public String getP() {
        return mP;
    }

    public void setP(String p) {
        mP = p;
    }

    public String getT() {
        return mT;
    }

    public void setT(String t) {
        mT = t;
    }

    public String getWd() {
        return mWd;
    }

    public void setWd(String wd) {
        mWd = wd;
    }

}
