
package com.example.apniteam.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class BatTeam {

    @SerializedName("id")
    private String mId;
    @SerializedName("innings")
    private List<Inning> mInnings;

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public List<Inning> getInnings() {
        return mInnings;
    }

    public void setInnings(List<Inning> innings) {
        mInnings = innings;
    }

}
