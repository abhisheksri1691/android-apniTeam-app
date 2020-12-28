
package com.example.apniteam.model.scoreCard;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Batsman {

    @SerializedName("b")
    private String mB;
    @SerializedName("id")
    private String mId;
    @SerializedName("out_desc")
    private String mOutDesc;
    @SerializedName("r")
    private String mR;
    @SerializedName("4s")
    private String mS;

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

    public String getOutDesc() {
        return mOutDesc;
    }

    public void setOutDesc(String outDesc) {
        mOutDesc = outDesc;
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

}
