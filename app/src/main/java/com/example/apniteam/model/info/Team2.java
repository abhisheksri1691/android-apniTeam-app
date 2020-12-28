
package com.example.apniteam.model.info;

import java.util.List;
import com.google.gson.annotations.SerializedName;


@SuppressWarnings("unused")
public class Team2 {

    @SerializedName("flag")
    private String mFlag;
    @SerializedName("id")
    private String mId;
    @SerializedName("name")
    private String mName;
    @SerializedName("s_name")
    private String mSName;
    @SerializedName("squad")
    private List<Long> mSquad;
    @SerializedName("squad_bench")
    private List<Long> mSquadBench;

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

    public List<Long> getSquad() {
        return mSquad;
    }

    public void setSquad(List<Long> squad) {
        mSquad = squad;
    }

    public List<Long> getSquadBench() {
        return mSquadBench;
    }

    public void setSquadBench(List<Long> squadBench) {
        mSquadBench = squadBench;
    }

}
