package cn.edu.zjut.po;

<<<<<<< HEAD
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
=======
public class Suggest {
    String name;
    String suggest;
    String time;

    public Suggest() {
    }

    public Suggest(String name, String suggest, String time) {
        this.name = name;
        this.suggest = suggest;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSuggest() {
        return suggest;
    }

    public void setSuggest(String suggest) {
        this.suggest = suggest;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
>>>>>>> origin/master
    }
}
