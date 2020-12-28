
package com.example.apniteam.model.info;
import com.google.gson.annotations.SerializedName;


@SuppressWarnings("unused")
public class Player {

    @SerializedName("bat_style")
    private String mBatStyle;
    @SerializedName("bowl_style")
    private String mBowlStyle;
    @SerializedName("f_name")
    private String mFName;
    @SerializedName("id")
    private String mId;
    @SerializedName("image")
    private String mImage;
    @SerializedName("name")
    private String mName;
    @SerializedName("speciality")
    private String mSpeciality;

    public String getBatStyle() {
        return mBatStyle;
    }

    public void setBatStyle(String batStyle) {
        mBatStyle = batStyle;
    }

    public String getBowlStyle() {
        return mBowlStyle;
    }

    public void setBowlStyle(String bowlStyle) {
        mBowlStyle = bowlStyle;
    }

    public String getFName() {
        return mFName;
    }

    public void setFName(String fName) {
        mFName = fName;
    }

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getImage() {
        return mImage;
    }

    public void setImage(String image) {
        mImage = image;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getSpeciality() {
        return mSpeciality;
    }

    public void setSpeciality(String speciality) {
        mSpeciality = speciality;
    }

}
