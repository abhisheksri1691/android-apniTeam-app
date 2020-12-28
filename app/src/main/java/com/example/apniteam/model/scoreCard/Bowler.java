
package com.example.apniteam.model.scoreCard;


import com.google.gson.annotations.SerializedName;


@SuppressWarnings("unused")
public class Bowler {

    @SerializedName("id")
    private String mId;
    @SerializedName("m")
    private String mM;
    @SerializedName("n")
    private String mN;
    @SerializedName("o")
    private String mO;
    @SerializedName("r")
    private String mR;
    @SerializedName("w")
    private String mW;
    @SerializedName("wd")
    private String mWd;

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getM() {
        return mM;
    }

    public void setM(String m) {
        mM = m;
    }

    public String getN() {
        return mN;
    }

    public void setN(String n) {
        mN = n;
    }

    public String getO() {
        return mO;
    }

    public void setO(String o) {
        mO = o;
    }

    public String getR() {
        return mR;
    }

    public void setR(String r) {
        mR = r;
    }

    public String getW() {
        return mW;
    }

    public void setW(String w) {
        mW = w;
    }

    public String getWd() {
        return mWd;
    }

    public void setWd(String wd) {
        mWd = wd;
    }

}
