package cn.edu.zjut.po;

import java.util.Date;

public class Suggest {
    private Integer suggestID;
    private  Teacher teacher;
    private String suggestion;
    private Date date;

    public void setDate(Date date) {
        this.date = date;
    }
    public Date getDate(){
        return date;
    }

    public void setTeacher(Teacher teacher){
        this.teacher =teacher;
    }
    public Teacher getTeacher(){
        return teacher;
    }
    public void setSuggestion(String suggestion){
        this.suggestion=suggestion;
    }
    public String getSuggestion(){
        return suggestion;
    }

    public void setSuggestID(Integer suggestID) {
        this.suggestID = suggestID;
    }

    public Integer getSuggestID() {
        return suggestID;
    }
}
