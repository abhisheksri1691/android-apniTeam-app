
package com.example.apniteam.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;


@SuppressWarnings("unused")
public class Data {

    @SerializedName("matches")
    private List<Match> mMatches;
    @SerializedName("srs_category")
    private List<SrsCategory> mSrsCategory;
    @SerializedName("url")
    private Url mUrl;

    public List<Match> getMatches() {
        return mMatches;
    }

    public void setMatches(List<Match> matches) {
        mMatches = matches;
    }

    public List<SrsCategory> getSrsCategory() {
        return mSrsCategory;
    }

    public void setSrsCategory(List<SrsCategory> srsCategory) {
        mSrsCategory = srsCategory;
    }

    public Url getUrl() {
        return mUrl;
    }

    public void setUrl(Url url) {
        mUrl = url;
    }

    @Override
    public String toString() {
        return "Data{" +
                "mMatches=" + mMatches +
                ", mSrsCategory=" + mSrsCategory +
                ", mUrl=" + mUrl.getMatch() +
                '}';
    }
}
