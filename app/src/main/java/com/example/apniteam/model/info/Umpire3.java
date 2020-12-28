
package com.example.apniteam.model.info;
import com.google.gson.annotations.SerializedName;


@SuppressWarnings("unused")
public class Umpire3 {

    @SerializedName("country")
    private String mCountry;
    @SerializedName("id")
    private String mId;
    @SerializedName("name")
    private String mName;

    public String getCountry() {
        return mCountry;
    }

    public void setCountry(String country) {
        mCountry = country;
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

}
