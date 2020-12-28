
package com.example.apniteam.model.info;


import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Toss {

    @SerializedName("decision")
    private String mDecision;
    @SerializedName("winner")
    private String mWinner;

    public String getDecision() {
        return mDecision;
    }

    public void setDecision(String decision) {
        mDecision = decision;
    }

    public String getWinner() {
        return mWinner;
    }

    public void setWinner(String winner) {
        mWinner = winner;
    }

}
