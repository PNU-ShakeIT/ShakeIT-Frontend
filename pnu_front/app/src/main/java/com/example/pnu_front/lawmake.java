package com.example.pnu_front;

public class lawmake {

    private String num;
    private String title;
    private String day;
    private String user;

    public lawmake(String title,String num,String user,String day){
        this.title = title;
        this.num = num;
        this.user = user;
        this.day = day;
    }
    public String getTitle(){
        return this.title;
    }
    public String getNum(){
        return  this.num;
    }
    public String getDay(){
        return this.day;
    }
    public String getUser(){
        return this.user;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setNum(String num) {
        this.num = num;
    }
    public void setUser(String user){
        this.user = user;
    }
    public void setDay(String day){
        this.day = day;
    }
}