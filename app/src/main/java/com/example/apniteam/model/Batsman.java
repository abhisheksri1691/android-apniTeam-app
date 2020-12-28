
package com.example.apniteam.model;


import com.google.gson.annotations.SerializedName;


@SuppressWarnings("unused")
public class Batsman {

    @SerializedName("b")
    private String mB;
    @SerializedName("id")
    private String mId;
    @SerializedName("name")
    private String mName;
    @SerializedName("r")
    private String mR;
    @SerializedName("4s")
    private String mS;
    @SerializedName("strike")
    private String mStrike;

    public String getB() {
        return mB;
    }

    public void setB(String b) {
        mB = b;
    }

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getR() {
        return mR;
    }

    public void setR(String r) {
        mR = r;
    }

    public String getS() {
        return mS;
    }

    public void setS(String s) {
        mS = s;
    }

    public String getStrike() {
        return mStrike;
    }

    public void setStrike(String strike) {
        mStrike = strike;
    }

}
