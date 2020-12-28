
package com.example.apniteam.model;


import com.google.gson.annotations.SerializedName;


@SuppressWarnings("unused")
public class SrsCategory {

    @SerializedName("id")
    private Long mId;
    @SerializedName("title")
    private String mTitle;

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

}
