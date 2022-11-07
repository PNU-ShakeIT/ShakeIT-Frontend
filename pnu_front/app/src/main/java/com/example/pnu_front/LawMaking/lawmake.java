package com.example.pnu_front.LawMaking;

public class lawmake {

        private String num;
        private String title;
        private String day;
        private String user;
        private String association;

        public lawmake(String title,String num,String user,String day, String association){
            this.title = title;
            this.num = num;
            this.user = user;
            this.day = day;
            this.association = association;
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
        public String getAssociation(){return this.association;}

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
    public void setAssociation(String association) {this.association = association;}
}
