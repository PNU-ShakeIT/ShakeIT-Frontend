package com.example.pnu_front.Calender;

import com.google.gson.annotations.SerializedName;

public class CalenderModel {
    @SerializedName("code")
    private String code;

    @SerializedName("title")
    private String title;

    @SerializedName("elect_GBN_NM")
    private String elect_GBN_NM;

    @SerializedName("committee_name")
    private String committee_name;

    @SerializedName("date")
    private String date;

    @SerializedName("time")
    private String time;

    @SerializedName("url")
    private String url;

    @SerializedName("id")
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getElect_GBN_NM() {
        return elect_GBN_NM;
    }

    public void setElect_GBN_NM(String elect_GBN_NM) {
        this.elect_GBN_NM = elect_GBN_NM;
    }

    public String getCommittee_name() {
        return committee_name;
    }

    public void setCommittee_name(String committee_name) {
        this.committee_name = committee_name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "CalenderModer{" +
                "code='" + code + '\'' +
                ", title='" + title + '\'' +
                ", elect_GBN_NM='" + elect_GBN_NM + '\'' +
                ", committee_name='" + committee_name + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    public Object getDate(Object o) {
        return this.date;
    }
}
