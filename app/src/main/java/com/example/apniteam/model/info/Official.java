
package com.example.apniteam.model.info;

import com.google.gson.annotations.SerializedName;


@SuppressWarnings("unused")
public class Official {

    @SerializedName("referee")
    private Referee mReferee;
    @SerializedName("umpire1")
    private Umpire1 mUmpire1;
    @SerializedName("umpire2")
    private Umpire2 mUmpire2;
    @SerializedName("umpire3")
    private Umpire3 mUmpire3;

    public Referee getReferee() {
        return mReferee;
    }

    public void setReferee(Referee referee) {
        mReferee = referee;
    }

    public Umpire1 getUmpire1() {
        return mUmpire1;
    }

    public void setUmpire1(Umpire1 umpire1) {
        mUmpire1 = umpire1;
    }

    public Umpire2 getUmpire2() {
        return mUmpire2;
    }

    public void setUmpire2(Umpire2 umpire2) {
        mUmpire2 = umpire2;
    }

    public Umpire3 getUmpire3() {
        return mUmpire3;
    }

    public void setUmpire3(Umpire3 umpire3) {
        mUmpire3 = umpire3;
    }

}
