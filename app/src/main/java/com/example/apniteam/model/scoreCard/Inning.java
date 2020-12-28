
package com.example.apniteam.model.scoreCard;

import java.util.List;
import com.google.gson.annotations.SerializedName;


@SuppressWarnings("unused")
public class Inning {

    @SerializedName("bat_team_id")
    private String mBatTeamId;
    @SerializedName("bat_team_name")
    private String mBatTeamName;
    @SerializedName("batsmen")
    private List<Batsman> mBatsmen;
    @SerializedName("bowl_team_id")
    private String mBowlTeamId;
    @SerializedName("bowlers")
    private List<Bowler> mBowlers;
    @SerializedName("extras")
    private Extras mExtras;
    @SerializedName("fow")
    private List<Fow> mFow;
    @SerializedName("innings_id")
    private String mInningsId;
    @SerializedName("ovr")
    private String mOvr;
    @SerializedName("pplay")
    private List<Pplay> mPplay;
    @SerializedName("score")
    private String mScore;
    @SerializedName("wkts")
    private String mWkts;

    public String getBatTeamId() {
        return mBatTeamId;
    }

    public void setBatTeamId(String batTeamId) {
        mBatTeamId = batTeamId;
    }

    public String getBatTeamName() {
        return mBatTeamName;
    }

    public void setBatTeamName(String batTeamName) {
        mBatTeamName = batTeamName;
    }

    public List<Batsman> getBatsmen() {
        return mBatsmen;
    }

    public void setBatsmen(List<Batsman> batsmen) {
        mBatsmen = batsmen;
    }

    public String getBowlTeamId() {
        return mBowlTeamId;
    }

    public void setBowlTeamId(String bowlTeamId) {
        mBowlTeamId = bowlTeamId;
    }

    public List<Bowler> getBowlers() {
        return mBowlers;
    }

    public void setBowlers(List<Bowler> bowlers) {
        mBowlers = bowlers;
    }

    public Extras getExtras() {
        return mExtras;
    }

    public void setExtras(Extras extras) {
        mExtras = extras;
    }

    public List<Fow> getFow() {
        return mFow;
    }

    public void setFow(List<Fow> fow) {
        mFow = fow;
    }

    public String getInningsId() {
        return mInningsId;
    }

    public void setInningsId(String inningsId) {
        mInningsId = inningsId;
    }

    public String getOvr() {
        return mOvr;
    }

    public void setOvr(String ovr) {
        mOvr = ovr;
    }

    public List<Pplay> getPplay() {
        return mPplay;
    }

    public void setPplay(List<Pplay> pplay) {
        mPplay = pplay;
    }

    public String getScore() {
        return mScore;
    }

    public void setScore(String score) {
        mScore = score;
    }

    public String getWkts() {
        return mWkts;
    }

    public void setWkts(String wkts) {
        mWkts = wkts;
    }

}
