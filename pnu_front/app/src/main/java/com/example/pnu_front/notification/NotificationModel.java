package com.example.pnu_front.notification;

import com.google.gson.annotations.SerializedName;

public class NotificationModel {
    @SerializedName("id")
    private String id;

    @SerializedName("title")
    private String title;

    @SerializedName("code")
    private int code;

    @SerializedName("createdate")
    private String createDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getCreatedate() {
        return createDate;
    }

    public void setCreatedate(String createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "NotificationModel{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", code=" + code +
                ", createdate='" + createDate + '\'' +
                '}';
    }
}
