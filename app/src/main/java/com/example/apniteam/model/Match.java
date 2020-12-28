
package com.example.apniteam.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;


@SuppressWarnings("unused")
public class Match {

    @SerializedName("bat_team")
    private BatTeam mBatTeam;
    @SerializedName("batsman")
    private List<Batsman> mBatsman;
    @SerializedName("bow_team")
    private BowTeam mBowTeam;
    @SerializedName("bowler")
    private List<Bowler> mBowler;
    @SerializedName("data_path")
    private String mDataPath;
    @SerializedName("header")
    private Header mHeader;
    @SerializedName("match_id")
    private String mMatchId;
    @SerializedName("series_id")
    private String mSeriesId;
    @SerializedName("series_name")
    private String mSeriesName;
    @SerializedName("srs_category")
    private List<Long> mSrsCategory;
    @SerializedName("team1")
    private Team1 mTeam1;
    @SerializedName("team2")
    private Team2 mTeam2;
    @SerializedName("venue")
    private Venue mVenue;

    public BatTeam getBatTeam() {
        return mBatTeam;
    }

    public void setBatTeam(BatTeam batTeam) {
        mBatTeam = batTeam;
    }

    public List<Batsman> getBatsman() {
        return mBatsman;
    }

    public void setBatsman(List<Batsman> batsman) {
        mBatsman = batsman;
    }

    public BowTeam getBowTeam() {
        return mBowTeam;
    }

    public void setBowTeam(BowTeam bowTeam) {
        mBowTeam = bowTeam;
    }

    public List<Bowler> getBowler() {
        return mBowler;
    }

    public void setBowler(List<Bowler> bowler) {
        mBowler = bowler;
    }

    public String getDataPath() {
        return mDataPath;
    }

    public void setDataPath(String dataPath) {
        mDataPath = dataPath;
    }

    public Header getHeader() {
        return mHeader;
    }

    public void setHeader(Header header) {
        mHeader = header;
    }

    public String getMatchId() {
        return mMatchId;
    }

    public void setMatchId(String matchId) {
        mMatchId = matchId;
    }

    public String getSeriesId() {
        return mSeriesId;
    }

    public void setSeriesId(String seriesId) {
        mSeriesId = seriesId;
    }

    public String getSeriesName() {
        return mSeriesName;
    }

    public void setSeriesName(String seriesName) {
        mSeriesName = seriesName;
    }

    public List<Long> getSrsCategory() {
        return mSrsCategory;
    }

    public void setSrsCategory(List<Long> srsCategory) {
        mSrsCategory = srsCategory;
    }

    public Team1 getTeam1() {
        return mTeam1;
    }

    public void setTeam1(Team1 team1) {
        mTeam1 = team1;
    }

    public Team2 getTeam2() {
        return mTeam2;
    }

    public void setTeam2(Team2 team2) {
        mTeam2 = team2;
    }

    public Venue getVenue() {
        return mVenue;
    }

    public void setVenue(Venue venue) {
        mVenue = venue;
    }

}
