
package com.example.apniteam.model;


import com.google.gson.annotations.SerializedName;


@SuppressWarnings("unused")
public class Url {

    @SerializedName("match")
    private String mMatch;

    public String getMatch() {
        return mMatch;
    }

    public void setMatch(String match) {
        mMatch = match;
    }

}
