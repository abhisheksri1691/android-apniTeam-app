
package com.example.apniteam.model.info;

import java.util.List;

import com.example.apniteam.model.Header;
import com.example.apniteam.model.Url;
import com.example.apniteam.model.Venue;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class MatchInfo {

    @SerializedName("ads")
    private List<Object> mAds;
    @SerializedName("apis")
    private Apis mApis;
    @SerializedName("audio")
    private List<Object> mAudio;
    @SerializedName("data_path")
    private String mDataPath;
    @SerializedName("header")
    private Header mHeader;
    @SerializedName("match_id")
    private String mMatchId;
    @SerializedName("official")
    private Official mOfficial;
    @SerializedName("players")
    private List<Player> mPlayers;
    @SerializedName("series_id")
    private String mSeriesId;
    @SerializedName("series_name")
    private String mSeriesName;
    @SerializedName("team1")
    private Team1 mTeam1;
    @SerializedName("team2")
    private Team2 mTeam2;
    @SerializedName("toss")
    private Toss mToss;
    @SerializedName("url")
    private Url mUrl;
    @SerializedName("venue")
    private Venue mVenue;

    public List<Object> getAds() {
        return mAds;
    }

    public void setAds(List<Object> ads) {
        mAds = ads;
    }

    public Apis getApis() {
        return mApis;
    }

    public void setApis(Apis apis) {
        mApis = apis;
    }

    public List<Object> getAudio() {
        return mAudio;
    }

    public void setAudio(List<Object> audio) {
        mAudio = audio;
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

    public Official getOfficial() {
        return mOfficial;
    }

    public void setOfficial(Official official) {
        mOfficial = official;
    }

    public List<Player> getPlayers() {
        return mPlayers;
    }

    public void setPlayers(List<Player> players) {
        mPlayers = players;
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

    public Toss getToss() {
        return mToss;
    }

    public void setToss(Toss toss) {
        mToss = toss;
    }

    public Url getUrl() {
        return mUrl;
    }

    public void setUrl(Url url) {
        mUrl = url;
    }

    public Venue getVenue() {
        return mVenue;
    }

    public void setVenue(Venue venue) {
        mVenue = venue;
    }

}
