package com.example.pnu_front.ProcessedBill;

import com.google.gson.annotations.SerializedName;

public class ProcessedBillModel {
    @SerializedName("id")
    private String id;

    @SerializedName("daesu")
    private String daesu;

    @SerializedName("bill_num")
    private String bill_num;

    @SerializedName("bill_name")
    private String bill_name;

    @SerializedName("proposer")
    private String proposer;

    @SerializedName("committee_nm")
    private String committee_nm;

    @SerializedName("url")
    private String url;

    @SerializedName("proc_date")
    private String proc_date;

    @SerializedName("billid")
    private String billid;

    @SerializedName("proc_result")
    private String proc_result;

    @SerializedName("curr_trans_dt")
    private String curr_trans_dt;

    @SerializedName("announce_dt")
    private String announce_dt;

    @SerializedName("rgs_proc_dt")
    private String rgs_proc_dt;

    @SerializedName("curr_committee_id")
    private String curr_committee_id;

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

    public String getBill_num() {
        return bill_num;
    }

    public void setBill_num(String bill_num) {
        this.bill_num = bill_num;
    }

    public String getBill_name() {
        return bill_name;
    }

    public void setBill_name(String bill_name) {
        this.bill_name = bill_name;
    }

    public String getProposer() {
        return proposer;
    }

    public void setProposer(String proposer) {
        this.proposer = proposer;
    }

    public String getCommittee_nm() {
        return committee_nm;
    }

    public void setCommittee_nm(String committee_nm) {
        this.committee_nm = committee_nm;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getProc_date() {
        return proc_date;
    }

    public void setProc_date(String proc_date) {
        this.proc_date = proc_date;
    }

    public String getBillid() {
        return billid;
    }

    public void setBillid(String billid) {
        this.billid = billid;
    }

    public String getProc_result() {
        return proc_result;
    }

    public void setProc_result(String proc_result) {
        this.proc_result = proc_result;
    }

    public String getCurr_trans_dt() {
        return curr_trans_dt;
    }

    public void setCurr_trans_dt(String curr_trans_dt) {
        this.curr_trans_dt = curr_trans_dt;
    }

    public String getAnnounce_dt() {
        return announce_dt;
    }

    public void setAnnounce_dt(String announce_dt) {
        this.announce_dt = announce_dt;
    }

    public String getRgs_proc_dt() {
        return rgs_proc_dt;
    }

    public void setRgs_proc_dt(String rgs_proc_dt) {
        this.rgs_proc_dt = rgs_proc_dt;
    }

    public String getCurr_committee_id() {
        return curr_committee_id;
    }

    public void setCurr_committee_id(String curr_committee_id) {
        this.curr_committee_id = curr_committee_id;
    }

    @Override
    public String toString() {
        return "ProcessedBillModel{" +
                "id='" + id + '\'' +
                ", daesu='" + daesu + '\'' +
                ", bill_num='" + bill_num + '\'' +
                ", bill_name='" + bill_name + '\'' +
                ", proposer='" + proposer + '\'' +
                ", committee_nm='" + committee_nm + '\'' +
                ", url='" + url + '\'' +
                ", proc_date='" + proc_date + '\'' +
                ", billid='" + billid + '\'' +
                ", proc_result='" + proc_result + '\'' +
                ", curr_trans_dt='" + curr_trans_dt + '\'' +
                ", announce_dt='" + announce_dt + '\'' +
                ", rgs_proc_dt='" + rgs_proc_dt + '\'' +
                ", curr_committee_id='" + curr_committee_id + '\'' +
                '}';
    }
}
