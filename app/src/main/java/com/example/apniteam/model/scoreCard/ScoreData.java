
package com.example.apniteam.model.scoreCard;

import java.util.List;
import com.google.gson.annotations.SerializedName;


@SuppressWarnings("unused")
public class ScoreData {

    @SerializedName("Innings")
    private List<Inning> mInnings;
    @SerializedName("state")
    private String mState;
    @SerializedName("status")
    private String mStatus;

    public List<Inning> getInnings() {
        return mInnings;
    }

    public void setInnings(List<Inning> innings) {
        mInnings = innings;
    }

    public String getState() {
        return mState;
    }

    public void setState(String state) {
        mState = state;
    }

    public String getStatus() {
        return mStatus;
    }

    public void setStatus(String status) {
        mStatus = status;
    }

}
