
package com.example.apniteam.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;


@SuppressWarnings("unused")
public class Header {

    @SerializedName("end_time")
    private String mEndTime;
    @SerializedName("match_desc")
    private String mMatchDesc;
    @SerializedName("mom")
    private List<Long> mMom;
    @SerializedName("momNames")
    private List<String> mMomNames;
    @SerializedName("start_time")
    private String mStartTime;
    @SerializedName("state")
    private String mState;
    @SerializedName("state_title")
    private String mStateTitle;
    @SerializedName("status")
    private String mStatus;
    @SerializedName("toss")
    private String mToss;
    @SerializedName("type")
    private String mType;
    @SerializedName("winning_team_id")
    private Long mWinningTeamId;

    public String getEndTime() {
        return mEndTime;
    }

    public void setEndTime(String endTime) {
        mEndTime = endTime;
    }

    public String getMatchDesc() {
        return mMatchDesc;
    }

    public void setMatchDesc(String matchDesc) {
        mMatchDesc = matchDesc;
    }

    public List<Long> getMom() {
        return mMom;
    }

    public void setMom(List<Long> mom) {
        mMom = mom;
    }

    public List<String> getMomNames() {
        return mMomNames;
    }

    public void setMomNames(List<String> momNames) {
        mMomNames = momNames;
    }

    public String getStartTime() {
        return mStartTime;
    }

    public void setStartTime(String startTime) {
        mStartTime = startTime;
    }

    public String getState() {
        return mState;
    }

    public void setState(String state) {
        mState = state;
    }

    public String getStateTitle() {
        return mStateTitle;
    }

    public void setStateTitle(String stateTitle) {
        mStateTitle = stateTitle;
    }

    public String getStatus() {
        return mStatus;
    }

    public void setStatus(String status) {
        mStatus = status;
    }

    public String getToss() {
        return mToss;
    }

    public void setToss(String toss) {
        mToss = toss;
    }

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }

    public Long getWinningTeamId() {
        return mWinningTeamId;
    }

    public void setWinningTeamId(Long winningTeamId) {
        mWinningTeamId = winningTeamId;
    }

}
