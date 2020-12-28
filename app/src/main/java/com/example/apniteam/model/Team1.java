
package com.example.apniteam.model;

import com.google.gson.annotations.SerializedName;


@SuppressWarnings("unused")
public class Team1 {

    @SerializedName("flag")
    private String mFlag;
    @SerializedName("id")
    private String mId;
    @SerializedName("name")
    private String mName;
    @SerializedName("s_name")
    private String mSName;

    public String getFlag() {
        return mFlag;
    }

    public void setFlag(String flag) {
        mFlag = flag;
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

    public String getSName() {
        return mSName;
    }

    public void setSName(String sName) {
        mSName = sName;
    }

}
