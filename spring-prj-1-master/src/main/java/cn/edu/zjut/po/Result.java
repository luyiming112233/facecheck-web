package cn.edu.zjut.po;

import java.sql.Date;

public class Result {
    int sign_id;//签到编号
    String name;//签到名称
    Date time;//签到发布时间
    int all;//总人数
    int fact;//实际签到人数
    int PId;

    public void set(int sign_id, String name, Date time, int all, int fact, int PId) {
        this.sign_id = sign_id;
        this.all = all;
        this.fact = fact;
        this.name = name;
        this.PId = PId;
        this.time = time;
    }

    public void setSign_id(int sign_id) {
        this.sign_id = sign_id;
    }

    public int getSign_id() {
        return sign_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Date getTime() {
        return time;
    }

    public void setAll(int all) {
        this.all = all;
    }

    public int getAll() {
        return all;
    }

    public void setFact(int fact) {
        this.fact = fact;
    }

    public int getFact() {
        return fact;
    }

    public void setPId(int PId) {
        this.PId = PId;
    }

    public int getPId() {
        return PId;
    }
}
