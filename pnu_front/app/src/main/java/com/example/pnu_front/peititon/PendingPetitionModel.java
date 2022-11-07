package com.example.pnu_front.peititon;

import com.google.gson.annotations.SerializedName;

public class PendingPetitionModel {
    @SerializedName("id")
    private int id;

    @SerializedName("num")
    private String num;

    @SerializedName("age")
    private String age;

    @SerializedName("name")
    private String name;

    @SerializedName("proposer")
    private String proposer;

    @SerializedName("approver")
    private String approver;

    @SerializedName("pro_dt")
    private String pro_dt;

    @SerializedName("curr_committee")
    private String curr_committee;

    @SerializedName("url")
    private String url;

    @SerializedName("billid")
    private String billid;

    @SerializedName("committee_id")
    private String committee_id;

    @SerializedName("committee_dt")
    private String committee_dt;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProposer() {
        return proposer;
    }

    public void setProposer(String proposer) {
        this.proposer = proposer;
    }

    public String getApprover() {
        return approver;
    }

    public void setApprover(String approver) {
        this.approver = approver;
    }

    public String getPro_dt() {
        return pro_dt;
    }

    public void setPro_dt(String pro_dt) {
        this.pro_dt = pro_dt;
    }

    public String getCurr_committee() {
        return curr_committee;
    }

    public void setCurr_committee(String curr_committee) {
        this.curr_committee = curr_committee;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getBillid() {
        return billid;
    }

    public void setBillid(String billid) {
        this.billid = billid;
    }

    public String getCommittee_id() {
        return committee_id;
    }

    public void setCommittee_id(String committee_id) {
        this.committee_id = committee_id;
    }

    public String getCommittee_dt() {
        return committee_dt;
    }

    public void setCommittee_dt(String committee_dt) {
        this.committee_dt = committee_dt;
    }

    @Override
    public String toString() {
        return "PendingPetitionModel{" +
                "id=" + id +
                ", num='" + num + '\'' +
                ", age='" + age + '\'' +
                ", name='" + name + '\'' +
                ", proposer='" + proposer + '\'' +
                ", approver='" + approver + '\'' +
                ", pro_dt='" + pro_dt + '\'' +
                ", curr_committee='" + curr_committee + '\'' +
                ", url='" + url + '\'' +
                ", billid='" + billid + '\'' +
                ", committee_id='" + committee_id + '\'' +
                ", committee_dt='" + committee_dt + '\'' +
                '}';
    }
}
