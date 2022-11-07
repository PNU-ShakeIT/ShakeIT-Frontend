package com.example.pnu_front.LawMaking;

import com.google.gson.annotations.SerializedName;

public class LawMakingModel {

    @SerializedName("id")
    private String id;

    @SerializedName("daesu")
    private String daesu;

    @SerializedName("bill_no")
    private String bill_no;

    @SerializedName("bill_name")
    private String bill_name;

    @SerializedName("curr_committee")
    private String curr_committee;

    @SerializedName("proposer")
    private String proposer;

    @SerializedName("pro_kind")
    private String pro_kind;

    @SerializedName("link")
    private String link;

    @SerializedName("noti_end_dt")
    private String noti_end_dt;

    @SerializedName("billid")
    private String billid;

    @SerializedName("committee_id")
    private String committee_id;

    @SerializedName("age")
    private String age;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDaesu() {
        return daesu;
    }

    public void setDaesu(String daesu) {
        this.daesu = daesu;
    }

    public String getBill_no() {
        return bill_no;
    }

    public void setBill_no(String bill_no) {
        this.bill_no = bill_no;
    }

    public String getBill_name() {
        return bill_name;
    }

    public void setBill_name(String bill_name) {
        this.bill_name = bill_name;
    }

    public String getCurr_committee() {
        return curr_committee;
    }

    public void setCurr_committee(String curr_committee) {
        this.curr_committee = curr_committee;
    }

    public String getProposer() {
        return proposer;
    }

    public void setProposer(String proposer) {
        this.proposer = proposer;
    }

    public String getPro_kind() {
        return pro_kind;
    }

    public void setPro_kind(String pro_kind) {
        this.pro_kind = pro_kind;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getNoti_end_dt() {
        return noti_end_dt;
    }

    public void setNoti_end_dt(String noti_end_dt) {
        this.noti_end_dt = noti_end_dt;
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "LawMakingModel{" +
                "id='" + id + '\'' +
                ", daesu='" + daesu + '\'' +
                ", bill_no='" + bill_no + '\'' +
                ", bill_name='" + bill_name + '\'' +
                ", curr_committee='" + curr_committee + '\'' +
                ", proposer='" + proposer + '\'' +
                ", pro_kind='" + pro_kind + '\'' +
                ", link='" + link + '\'' +
                ", noti_end_dt='" + noti_end_dt + '\'' +
                ", billid='" + billid + '\'' +
                ", committee_id='" + committee_id + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
