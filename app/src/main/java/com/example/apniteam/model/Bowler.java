
package com.example.apniteam.model;


import com.google.gson.annotations.SerializedName;


@SuppressWarnings("unused")
public class Bowler {

    @SerializedName("id")
    private String mId;
    @SerializedName("m")
    private String mM;
    @SerializedName("name")
    private String mName;
    @SerializedName("o")
    private String mO;
    @SerializedName("r")
    private String mR;
    @SerializedName("w")
    private String mW;

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

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
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

}
